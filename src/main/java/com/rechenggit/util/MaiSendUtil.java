package com.rechenggit.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@ToString
@Configuration
public class MaiSendUtil {
    /*
    email;// 收件人邮箱
    code;// 激活码
    url;//链接跳转地址
    content;//内容
    *
    */

    //发送激活邮箱
    public static void verifyingMailbox(String email,String code,String url) {
        String subject = "Account activation";
        String content = "<html><head></head><body>" +
                "<h3>Please do not reply directly to this system-generated email.</h3>" +
                "<h3>Please Verify Your Mailbox</h3>" +
                "<br/>" +
                "<h3>Dear customer:</h3>" +
                "<h3>Thank you for choosing Supay cross-border payment solution.</h3>" +
                "<h2>Please click " +
                "<a href='"+url+"/user/verification?email="+email+"&code="+code+"'> here</a>"+
                "&nbsp;to verify your email. </h2></body></html>"+
                "<h3>&nbsp; &nbsp; Best regards</h3>"+
                "<h3>&nbsp; &nbsp; www.supay.com</h3>";
        new Thread(new MailUtil(email,code,url,content,subject)).start();
    }
    //发送邮件找回密码 暂不开发
    public static void findLoginPassword(String email,String code,String url) {
        String subject = "possword";
        String content = "<html><head></head><body>" +
                "<h3>Please do not reply directly to this system-generated email.</h3>" +
                "<h3>Please Verify Your Mailbox</h3>" +
                "<br/>" +
                "<h3>Dear customer:</h3>" +
                "<h3>Thank you for choosing Supay cross-border payment solution.</h3>" +
                "<h2>Please click " +
                "<a href='"+url+"/user/verification?email="+email+"&code="+code+"'> here</a>"+
                "&nbsp;to verify your email. </h2></body></html>"+
                "<h3>&nbsp; &nbsp; Best regards</h3>"+
                "<h3>&nbsp; &nbsp; www.supay.com</h3>";
        new Thread(new MailUtil(email,code,url,content,subject)).start();
    }
}
