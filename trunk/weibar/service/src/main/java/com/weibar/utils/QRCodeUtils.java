package com.weibar.utils;

import com.github.binarywang.utils.qrcode.MatrixToImageWriter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

public class QRCodeUtils {

    private static final Logger LOG = LoggerFactory.getLogger(QRCodeUtils.class);
    private static final int DEFAULT_QR_CODE_WIDTH = 400;
    private static final int DEFAULT_QR_CODE_HEIGHT = 400;
    private static final String DEAULT_SUFFIX_TEMP = "tmp";
    private static final String DEAULT_SUFFIX_PNG = "png";



    public static File getQrCodeFile(String content){
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        Map hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, DEFAULT_QR_CODE_WIDTH, DEFAULT_QR_CODE_HEIGHT, hints);
            File file = File.createTempFile(String.valueOf(System.currentTimeMillis()),DEAULT_SUFFIX_TEMP);
            MatrixToImageWriter.writeToFile(bitMatrix, DEAULT_SUFFIX_PNG, file);
            return file;
        } catch (IOException e) {
            LOG.error("get QRCODE error content " + content , e);
            return null;
        } catch (WriterException e) {
            LOG.error("get QRCODE error content " + content , e);
            return null;
        }
    }


    public static String getQrCodeImgUrl(String content){
        File file = getQrCodeFile(content);

        try {
            InputStream in = new FileInputStream(file);
            int flen = (int)file.length();
            byte[] strBuffer = new byte[flen];
            in.read(strBuffer, 0, flen);
            String fileName  = AliOssClient.getImgUrlByFileName(AliOssClient.uploadBytes(strBuffer));
            return fileName;
        }  catch (IOException e) {
            LOG.error("get QRCODE error content " + content , e);
        }
        return null;
    }



//    public static void main(String[] args) throws IOException {
//        System.out.println(getQrCodeImgUrl("http://www.baidu.com"));
//    }

}
