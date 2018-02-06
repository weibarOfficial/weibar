package com.weibar.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

/**
 * Created by Administrator on 2017/11/16.
 */

public class AliOssClient {


    private static final Logger logger = LoggerFactory.getLogger(AliOssClient.class);
    private static OSSClient ossClient;

    // endpoint以杭州为例，其它region请按实际情况填写
    private static final String END_POINT_DOMAIN = "oss-cn-shenzhen.aliyuncs.com";
    private static final String END_POINT = "http://" + END_POINT_DOMAIN;
    private static final String BUCKET_NAME  = "weibar";
    // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
    private static final String ACCESS_KEY = "LTAISta2AWWgUhMb";
    private static final String ACCESS_SECRET = "EZfwD0IVbBqPcCwvl3q35qZM6eKvh2";


    private static final String STATIC_YYLIVE = "static.yylive.com";


    /**
     * 您的工程中可以有多个OSSClient，也可以只有一个OSSClient。
        OSSClient可以并发使用。
        OSS支持HTTPS，当您的安全需求更高时，可以使用HTTPS。
        OSSClient.shutdown之后不能再使用。
     * @return
     */
    public static OSSClient getOssClient(){
        if(ossClient != null ){
            return ossClient;
        }

        // 创建OSSClient实例
        OSSClient client = new OSSClient(END_POINT, ACCESS_KEY, ACCESS_SECRET);

        //设置为可以随意访问
        client.setBucketAcl(BUCKET_NAME, CannedAccessControlList.PublicRead);

        //已经创建了
        //client.createBucket(BUCKET_NAME);

        return client;
        // 使用访问OSS
        // 关闭client
        //client.shutdown();
    }

    public static String uploadString(String content){
        String fileName = SignUtils.md5DigestAsHex(content);
        getOssClient().putObject(BUCKET_NAME, fileName, new ByteArrayInputStream(content.getBytes()));
        logger.info("upload string to alioss successfully fileName: " + fileName);
        return fileName;
    }


    public static String uploadBytes(byte[] content){
        String fileName = SignUtils.md5DigestAsHex(content);
        getOssClient().putObject(BUCKET_NAME, fileName, new ByteArrayInputStream(content));
        logger.info("uploadBytes to alioss successfully fileName: " + fileName);
        return fileName;
    }


    public static String getImgUrlByFileName(String fileName){
        //return "http://" + BUCKET_NAME + "." + END_POINT_DOMAIN + "/" + fileName;
        return "http://" + STATIC_YYLIVE + "/" + fileName;
    }

    public static final void main(String[] args){
        System.out.println(AliOssClient.uploadString("hello world1"));
    }




}
