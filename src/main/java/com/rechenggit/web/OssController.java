package com.rechenggit.web;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import com.rechenggit.util.OssManage;
import com.rechengit.cheng.cloud.auth.client.annotation.CheckClientToken;
import com.rechengit.cheng.cloud.auth.client.annotation.CheckUserToken;
import com.rechengit.cheng.cloud.auth.client.annotation.IgnoreClientToken;
import com.rechengit.cheng.cloud.auth.client.annotation.IgnoreUserToken;
import com.rechengit.cheng.cloud.common.util.UUIDUtils;
import com.rechengit.common.entity.response.ResponseMessage;
import com.rechengit.common.enums.exception.ReturnCodes;
import com.rechengit.common.pay.channel.common.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map;

/**
 * @author jazz chou
 * @Title:
 * @Package super
 * @Description:
 * @date 2018/4/1717:27
 */
@RestController
@RequestMapping("oss")
@Slf4j
//@CheckClientToken
//@IgnoreUserToken
public class OssController {

    @Autowired
    private OssManage ossManage;

    @RequestMapping("/api/upload")
    //@IgnoreClientToken
    //@IgnoreUserToken
    //@CrossOrigin
    public ResponseMessage upload(@RequestParam("file")MultipartFile file, @RequestParam(value = "model",required = false,defaultValue = "super")String model){
        ResponseMessage resp = new ResponseMessage();
        try {
//            OssManage ossManage = new OssManage();
//            byte[] data = file.getInputStream();
            String fileName = file.getOriginalFilename();
//            fileName =  UUIDUtils.generateUuid();
            String uuid = UUIDUtils.generateUuid();
//            fileName = uuid +fileName;
            String suffix  = fileName.substring(fileName.lastIndexOf(".")+1);
            String caselsh = uuid;
            BufferedImage image = ImageIO.read(file.getInputStream());

            if (image != null) {//如果image=null 表示上传的不是图片格式
                uuid =model+"/"+ DateUtil.getDateString(new Date())+"/"+caselsh+"_w"+image.getWidth()+"_h"+image.getHeight() +"."+suffix;
            }

            String tag =   ossManage.uploadFile(file.getInputStream(),uuid,suffix);

            Map resultMap = new HashMap();
            resultMap.put("osskey",uuid);
            resp.setStatus(ReturnCodes.SUCCESS.getCode());
            resp.setMessage("success");
            resp.setData(resultMap);


        } catch (Exception e){
            log.error("上传文件失败",e);
            resp.setStatus(ReturnCodes.INTERNAL_FAIL.getCode());
            resp.setMessage("上传文件失败");
        }
         return  resp;
    }


    @RequestMapping("/api/getAuthUrl")
    public ResponseMessage getAuthUrl(@RequestBody String osskey){
        ResponseMessage resp = new ResponseMessage();
        try {

           String url =  ossManage.getImgURl(osskey);
            resp.setStatus(ReturnCodes.SUCCESS.getCode());
            resp.setMessage("success");
            Map resultMap = new HashMap();
            resultMap.put("url",url);
            resp.setData(resultMap);
        } catch (Exception e){
            log.error("获取文件链接失败",e);
            resp.setStatus(ReturnCodes.INTERNAL_FAIL.getCode());
            resp.setMessage("获取文件链接失败");
        }
        return  resp;
    }

    /**
     *
     * @param osskeyMap 包含 osskey
     * @return
     */
    @RequestMapping("/api/delete")
    public ResponseMessage deleteAttach(@RequestBody Map  osskeyMap){
        ResponseMessage resp = new ResponseMessage();
        try {
//            if(osskeyMap == null || osskeyMap.get("osskey") == null){
//                resp.setStatus(ReturnCodes.VALIDATE_FAIL.getCode());
//                resp.setMessage("图片不存在");
//                return resp;
//
//            }
//            OssManage ossManage = new OssManage();
//
//
//            ossManage.deleteFile((String)osskeyMap.get("osskey"));
            resp.setStatus(ReturnCodes.SUCCESS.getCode());
            resp.setMessage("success");
        } catch (Exception e){
            log.error("删除文件异常",e);
            resp.setStatus(ReturnCodes.INTERNAL_FAIL.getCode());
            resp.setMessage("删除文件异常");
        }
        return  resp;
    }

    /**
     *
     * @return
     */
    @RequestMapping("/getToken")
    @IgnoreClientToken
    @IgnoreUserToken
    public ResponseMessage getToken(){
        ResponseMessage resp = new ResponseMessage();
        String endpoint = "sts.cn-hangzhou.aliyuncs.com";
        String accessKeyId = "LTAIGSadUHzyewPR";
        String accessKeySecret = "rqaMYa4UfFBranAWKHJvLBF60UAyOp";
        String roleArn = "acs:ram::1252494030021758:role/aliyunosstokengeneratorrole";
        String roleSessionName = "session-name";
        String policy = "{\n" +
                "  \"Version\": \"1\",\n" +
                "  \"Statement\": [\n" +
                "    {\n" +
                "      \"Effect\": \"Allow\",\n" +
                "      \"Action\": [\n" +
                "        \"oss:*\"\n" +
                "      ],\n" +
                "      \"Resource\": [\n" +
                "        \"acs:oss:*:*:super-app\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"Effect\": \"Deny\",\n" +
                "      \"Action\": [\n" +
                "        \"oss:DeleteObject\"\n" +
                "      ],\n" +
                "      \"Resource\": [\n" +
                "        \"acs:oss:*:*:super-app\",\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        try {
            DefaultProfile.addEndpoint("", "", "Sts", endpoint);
            IClientProfile profile = DefaultProfile.getProfile("", accessKeyId, accessKeySecret);
            DefaultAcsClient client = new DefaultAcsClient(profile);
            final AssumeRoleRequest request = new AssumeRoleRequest();
            request.setMethod(MethodType.POST);
            request.setRoleArn(roleArn);
            request.setRoleSessionName(roleSessionName);
//            request.setPolicy(policy); // Optional
            final AssumeRoleResponse response = client.getAcsResponse(request);
            log.info("Expiration: " + response.getCredentials().getExpiration());
            log.info("Access Key Id: " + response.getCredentials().getAccessKeyId());
            log.info("Access Key Secret: " + response.getCredentials().getAccessKeySecret());
            log.info("Security Token: " + response.getCredentials().getSecurityToken());
            log.info("RequestId: " + response.getRequestId());
            resp.setStatus(200);
            resp.setMessage("success");
            resp.setData(response.getCredentials());
        } catch (ClientException e) {
            log.error("Failed：");
            log.error("Error code: " + e.getErrCode());
            log.error("Error message: " + e.getErrMsg());
            log.error("RequestId: " + e.getRequestId());
            resp.setStatus(500);
            resp.setMessage(e.getErrMsg());
        }


        return  resp;
    }

}
