package com.rechenggit.util;
import com.sun.mail.util.MailSSLSocketFactory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
@Setter
@Getter
@ToString
@Configuration
public class MailUtil implements Runnable {
    private String email;// 收件人邮箱
    private String code;// 激活码
    private  String url;//链接跳转地址
    private String content;// 激活码
    private String subject;// 主题
    public MailUtil(String email, String code,String url,String content,String subject) {
        this.email = email;
        this.code = code;
        this.url = url;
        this.content = content;
        this.subject = subject;
    }

    public MailUtil() {
    }
    public void run() {
        // 1.创建连接对象javax.mail.Session
        // 2.创建邮件对象 javax.mail.Message
        // 3.发送一封激活邮件
        String from = "15902137921@163.com";// 发件人电子邮箱
        String host = "smtp.163.com"; // 指定发送邮件的主机smtp.qq.com(QQ)|smtp.163.com(网易)

        Properties properties = System.getProperties();// 获取系统属性

        properties.setProperty("mail.smtp.host", host);// 设置邮件服务器
        properties.setProperty("mail.smtp.auth", "true");// 打开认证

        try {
            //QQ邮箱需要下面这段代码，163邮箱不需要
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);
            // 1.获取默认session对象
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("15902137921@163.com", "wang0921"); // 发件人邮箱账号、授权码
                }
            });

            // 2.创建邮件对象
            Message message = new MimeMessage(session);
            // 2.1设置发件人
            message.setFrom(new InternetAddress(from));
            // 2.2设置接收人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            // 2.3设置邮件主题
            message.setSubject(subject);
            // 2.4设置邮件内容
            message.setContent(content, "text/html;charset=UTF-8");
            // 3.发送邮件
            Transport.send(message);
            System.out.println("邮件发送成功!");
        } catch (Exception e) {
            System.out.println("邮件发送失败!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //new Thread( new MailUtil("1101699612@qq.com", "asasas","http://localhost:8000")).start();
        String pwd = Utils.hashSignContent("111111");
        System.out.println(pwd);
    }
}