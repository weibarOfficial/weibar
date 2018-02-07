package com.weibar.utils;

import org.apache.commons.codec.binary.Base64;
import org.springframework.util.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;

/**
 * Created by Administrator on 2017/11/16.
 * 加解密 签名相关工具类
 */
public class SignUtils {


    private static final String DEFAULT_KEY = "Bar54321Bar12345";
    private static final String DEFAULT_INIT_VECTOR = "RandomInitVector";

    public static String md5DigestAsHex(String str){
        String result = DigestUtils.md5DigestAsHex(str.toString().getBytes(Charset.forName("utf-8")))
                .toLowerCase();
        return result;
    }


    public static String md5DigestAsHex(byte[] bytes){
        String result = DigestUtils.md5DigestAsHex(bytes).toLowerCase();
        return result;
    }


    public static String encryptAES(String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(DEFAULT_INIT_VECTOR.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(DEFAULT_KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            System.out.println("encrypted string: "
                    + Base64.encodeBase64String(encrypted));

            return Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String decryptAES( String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(DEFAULT_INIT_VECTOR.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(DEFAULT_KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
