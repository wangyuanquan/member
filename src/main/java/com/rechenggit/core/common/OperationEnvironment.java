package com.rechenggit.core.common;

import com.netfinworks.common.domain.Extension;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OperationEnvironment {

    /** 客户端IP */
    private String            clientIp;
    /** 客户端MAC */
    private String            clientMac;
    /** 客户端的唯一标识 */
    private String            clientId;
    /** 服务器IP */
    private String            serverIp;
    /** 服务器名称 */
    private String            serverName;
    /** 扩展信息 */
    private Extension extension;
}
