package com.rechenggit.util;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * @author jazz chou
 * @Title:
 * @Package super
 * @Description:
 * @date 2018/4/1711:50
 */
public class OssUtils {
    // endpoint以杭州为例，其它region请按实际情况填写
    static   String  endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
    static   String accessKeyId = "LTAIZ4cUbZRTYoSB";
    static String accessKeySecret = "aX3TnUGHrHOCJDRMqYrCO7obuYBZ9C";

    public static void upload( ) throws IOException {
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传字符串
//        String content = "Hello OSS";
        File file = new File("");
        InputStream in = new FileInputStream("C:\\Users\\jackson\\Desktop\\123.png");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        byte[] data = out.toByteArray();
        PutObjectResult result = ossClient.putObject("super-app", "test/222.png", new ByteArrayInputStream(data));

        //{"clientCRC":-4219636308456691087,
        // "eTag":"0655BE53AAC35097A20AAC443655ABF9",
        // "requestId":"5AD5A749355BE82D5D49B3EC","serverCRC":-4219636308456691087}
//     OSSObject obj =  ossClient.getObject("super-app","111.png");
//      System.out.println(JSON.toJSONString(result));
        // 设置URL过期时间为10年  3600l* 1000*24*365*10
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl("super-app", "test/222.png", expiration);
        System.out.println("1111111111111111111111111111");
        System.out.println(JSON.toJSONString(url));
        // 关闭client
        ossClient.shutdown();
    }

    public static String view(HttpServletResponse response) throws IOException {
        ServletOutputStream out = null;
        InputStream ips = null;
        try {
            // 创建OSSClient实例
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            //获取图片存放路径
//            String imgPath = Constans.FOLDER_IMAGE + imgName;
            Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
            URL url = ossClient.generatePresignedUrl("super-app", "111.png", expiration);
            // 打开到url的连接
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            // 以下为java IO部分，大体来说就是先检查文件夹是否存在，不存在则创建,然后的文件名重复问题，没有考虑
             ips = connection.getInputStream();

            response.setContentType("multipart/form-data");
            out = response.getOutputStream();
            //读取文件流
            int len = 0;
            byte[] buffer = new byte[1024 * 10];
            while ((len = ips.read(buffer)) != -1){
                out.write(buffer,0,len);
            }
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
            ips.close();
        }
        return null;
    }
    public static void main(String[] args) throws IOException {
        upload();
    }





}
