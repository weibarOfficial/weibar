package com.weibar.controller;

import com.weibar.utils.AliOssClient;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



/**
 * Created by Administrator on 2017/11/14.
 */
@RestController
public class PicController {

    private static final Logger logger = LoggerFactory.getLogger(PicController.class);

    /**
     * Upload single file using Spring Controller
     */
    @RequestMapping(value = "/h5/uploadPic", method = {RequestMethod.POST,RequestMethod.GET})
    public Object uploadFileHandler(@RequestParam("file") MultipartFile file) throws BaseException {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String fileName  = AliOssClient.getImgUrlByFileName(AliOssClient.uploadBytes(bytes));
                return BaseResult.getSuccessfulResult(fileName);
            } catch (Exception e) {
                logger.error("uploadPic error ",e);
                throw BaseException.getException(ErrorCodeEnum.PIC_PIC_UPLOAD_FAIL.getCode());
            }
        } else {
            throw BaseException.getException(ErrorCodeEnum.PIC_PIC_UPLOAD_FAIL.getCode());
        }
    }


    @RequestMapping(value = "/h5/uploadPicBase64", method = {RequestMethod.POST,RequestMethod.GET})
    public Object uploadFileHandlerBase64(@RequestParam("file") String file) throws BaseException {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String fileName  = AliOssClient.getImgUrlByFileName(AliOssClient.uploadBytes(Base64.decodeBase64(bytes)));
                return BaseResult.getSuccessfulResult(fileName);
            } catch (Exception e) {
                logger.error("uploadPicBase64 error ",e);
                throw BaseException.getException(ErrorCodeEnum.PIC_PIC_UPLOAD_FAIL.getCode());
            }
        } else {
            throw BaseException.getException(ErrorCodeEnum.PIC_PIC_UPLOAD_FAIL.getCode());
        }
    }
}
