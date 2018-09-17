package com.rechenggit.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;

/**
 * @author jazz chou
 * @Title:
 * @Package super
 * @Description:
 * @date 2018/4/1717:09
 */
@Slf4j
@Service
public class OssManage {
    @Value("${oss.upload.accesskeyid}")
    public   String ACCESS_KEY_ID  ;
    @Value("${oss.upload.accesskeysecret}")
    public   String  ACCESS_KEY_SECRET ;
    @Value("${oss.upload.url}")
    public   String  ENDPOINT ;
    @Value("${oss.upload.bucketname}")
    public   String  BUCKETNAME ;
    @Value("${oss.upload.bucketname}")
    public   String  BUCKETNAME_VIDEO ;
    public static Long OUT_OF_DATE = null;
    private OSSClient client  = null;
    private ObjectMetadata meta = null;
    static{
        try {
            OUT_OF_DATE =3600l * 1000 * 24 * 365 * 10; // 10年
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(){
        // 初始化一个OSSClient
        client = new OSSClient(ENDPOINT,ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        meta = new ObjectMetadata();
    }

    /**
     * @Description: 上传文件到OSS文件服务器
     * @param content  文件流
     * @param key    上传为OSS文件服务器的唯一标识
     * @param mimeType  文档类型
     * @throws Exception
     * @ReturnType:String   OSSObject的ETag值。
     */
    public String  uploadFile(InputStream content, String key, String mimeType) throws Exception{
        //进行初始化
        init();
        // 必须设置ContentLength
        meta.setContentType(mimeType);
        // 上传Object.
        log.info("*****************上传图片到oss服务器开始*****************" + key);
        PutObjectResult result = client.putObject(BUCKETNAME, key, content, meta);
        log.info("*****************上传图片到oss服务器结束*****************" + key);
        return result.getETag();
    }



    /**
     * @Description: 根据key获取oss服务器上的图片地址
     * @param key
     * @return
     * @ReturnType:String
     */
    public String getImgURl(String key){
        init();
        Date expires = new Date (new Date().getTime() + OUT_OF_DATE); // 30 minute to expire
        GeneratePresignedUrlRequest generatePresignedUrlRequest ;
        if(key.startsWith("msplatform")){
            generatePresignedUrlRequest =new GeneratePresignedUrlRequest(BUCKETNAME, key);
        }else {
            generatePresignedUrlRequest =new GeneratePresignedUrlRequest(BUCKETNAME_VIDEO, key);
        }
        generatePresignedUrlRequest.setExpiration(expires);
        URL url = client.generatePresignedUrl(generatePresignedUrlRequest);
        return url.toString();
    }
    /**
     * @Description:根据key获取oss服务器上的ipa文件地址
     * @param key
     * @return
     * @ReturnType:String
     */
    public String getIpaURl(String key){
        init();
        Date expires = new Date(new Date().getTime()+ 10*365*24*3600*1000);
        GeneratePresignedUrlRequest generatePresignedUrlRequest ;
        if(key.startsWith("msplatform")){
            generatePresignedUrlRequest =new GeneratePresignedUrlRequest(BUCKETNAME, key);
        }else {
            generatePresignedUrlRequest =new GeneratePresignedUrlRequest(BUCKETNAME_VIDEO, key);
        }
        generatePresignedUrlRequest.setExpiration(expires);
        URL url = client.generatePresignedUrl(generatePresignedUrlRequest);
        return url.toString();
    }

    /**
     * @Description: 根据key获取oss服务器上的图片地址
     * @param key
     * @return
     * @ReturnType:String
     */
    public InputStream  getObject(String key){
        init();
        OSSObject object = null;
        if(key.startsWith("msplatform")){
            object= client.getObject(BUCKETNAME, key);
        }else{
            object= client.getObject(BUCKETNAME_VIDEO, key);
        }
        object.getObjectMetadata().getContentType();
        // 获取Object的输入流
        InputStream objectContent = object.getObjectContent();


        return objectContent;
    }


    /**
     * @Description:删除文件
     * @param key  OSS文件服务器上文件的唯一标识
     * @ReturnType:void
     */
    public void deleteFile(String key){
        init();
        client.deleteObject(BUCKETNAME, key);
    }


    /**
     * @Description: 断点上传文件到OSS文件服务器
     * @param content  文件流
     * @param key    上传为OSS文件服务器的唯一标识
     * @param position 位置
     */
    public String  appendObjectFile(InputStream content,String key,int position,String mimeType) throws Exception{
        //进行初始化
        init();
        // 必须设置ContentLength
        meta.setContentLength(position);
        meta.setContentType(mimeType);
        meta.setCacheControl("no-cache");
        meta.setContentEncoding("utf-8");
        // 上传
        log.info("*****************断点上传图片到oss服务器开始*****************" + key);
        AppendObjectRequest appendObjectRequest = new AppendObjectRequest(BUCKETNAME, key, content, meta);
        appendObjectRequest.setPosition(Long.valueOf(position));
        AppendObjectResult appendObjectResult =client.appendObject(appendObjectRequest);
        log.info("*****************断点上传图片到oss服务器结束*****************" + key);
        return appendObjectResult.getNextPosition().toString();
    }

    public static void main(String[] args) {
        OssManage ossManage = new OssManage();
        System.out.println( ossManage.getImgURl("111.png"));

    }
}
