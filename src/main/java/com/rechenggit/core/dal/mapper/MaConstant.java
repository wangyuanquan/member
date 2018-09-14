package com.rechenggit.core.dal.mapper;
/**
 * 注释
 */
public interface MaConstant {
    /** 默认接口版本号 */
    public static final String DEFAULT_VERSION = "10";

    /** 默认国家编码（中国） **/
    public static final String COUNTRY_CODE_CHINA = "000000";

    /** Mac签名字段分隔符 **/
    public static final char MAC_SIGN_SPERATOR = '|';

    /** 缓存对象命名空间--会员 */
    public static final String CACHE_NAMESPACE_MEMBER = "Member";

    /** 缓存对象命名空间--会员 */
    public static final String CACHE_NAMESPACE_MEMBER_EXT_INFO_CONFIG = "MemberExtInfoConfig";

    /** 缓存对象命名空间--登录名 */
    public static final String CACHE_NAMESPACE_LOGINNAME = "LoginName";

    /** 缓存对象命名空间--操作员 */
    public static final String CACHE_NAMESPACE_OPERATOR = "Operator";

    /** 缓存对象命名空间--支付密码 */
    public static final String CACHE_NAMESPACE_PASSWORD = "Password";

    /** 缓存对象命名空间--验证信息 */
    public static final String CACHE_NAMESPACE_VERIFY = "Verify";

    /** 缓存对象命名空间--银行账号信息 */
    public static final String CACHE_NAMESPACE_BANKACCOUNT = "NewBankAccount";

    /** 缓存对象命名空间--会员联系人信息 */
    public static final String CACHE_NAMESPACE_CONTACT = "Contact";

    /** 缓存对象命名空间--会员账户关系 */
    public static final String CACHE_NAMESPACE_ACCOUNT_REF = "NewAccountRef";


    /** 校验位长度 */
    public static final int MEMBER_ID_VALIDATE_BIT_LENGTH = 1;

    /** 补足长度占位符 */
    public static final char ID_FIX_CHAR = '0';

    /** 操作员备注信息 */
    public static final String MEMO = "memo";

    /** 会员id其中序列号部分的长度 */
    public static final int MEMBER_ID_SEQ_LENGTH = 10;
    /** 默认会员账户关系个数配制 */
    public static final int DEFAULT_ACCOUNT_CONFIG=1;
    public static final String PRE_MEMBER_PERSONAL_ID = "10";
    public static final String PRE_MEMBER_COMPANY_ID = "20";
    public static final String PRE_MEMBER_INSTITUTION_ID = "30";
    public static final String PRE_MEMBER_PERMERCHANT_ID = "40";

    public static final String PRE_MERCHANT_ID = "40";

    public static final String PRE_ORGANIZATION_ID = "50";
    public static final String PRE_CONTACT_ID = "60";
    public static final String PRE_OPERATOR_ID = "70";

    // 会员系统配置
    public static final String TYPE_MEMBER_CONFIG = "MEMBER_CONFIG";
    /** 集团节点的最大孩子节点数 */
    public static final String SUB_TYPE_MAX_ORG_NODE_CHILD_COUNT = "MAX_ORG_NODE_CHILD_COUNT";
    /** 会员操作员最大数量 */
    public static final String SUB_TYPE_MAX_OPERATOR_COUNT = "MAX_OPERATOR_COUNT";
    /** 支付密码key */
    public static final String SUB_TYPE_PASSWORD_MD5_KEY = "PASSWORD_MD5_KEY";

    //账户批量查询中查询项最大个数
    public static final String SUB_TYPE_MAX_BULK_ACCT_QUERY_ITEM_COUNT = "MAX_BULK_ACCT_QUERY_ITEM_COUNT";

    //账户批量查询中查询项无限制个数配置
    public static final int BULK_ACCT_QUERY_ITEM_UNLIMITED_COUNT = -1;

    // 工业类型编码配置
    public static final String TYPE_INDUSTRY_CODE = "INDUSTRY_TYPE_CODE";

    // 认证类型编码配置
    public static final String TYPE_VERIFY_TYPE = "VERIFY_TYPE";

    // 认证子类型编码配置
    public static final String TYPE_VERIFY_SUB_TYPE = "VERIFY_SUB_TYPE";

    // 认证渠道
    public static final String TYPE_VERIFY_CHANNEL = "VERIFY_CHANNEL";

    // 会员标识平台类型配置
    public static final String TYPE_MEMBER_IDENTITY_PID = "MEMBER_IDENTITY_PID";

    public static final int PWD_MIN_SCORE = 31;

    /** 支付密码锁定规则配置 */
    public static final String PAY_PWD_LOCK_STRATEGY_OP = "OP";

    /** 登录密码锁定规则配置 */
    public static final String LOGIN_PWD_LOCK_STRATEGY_OP = "LOGIN_OP";

    /** 密码错误重试次数 */
    public static final int PWD_ERROR_RETRY_COUNT = -1;

    public static final String SUB_TYPE_MAX_SDPCARD_COUNT_FOR_MBR = "MAX_SDPCARD_COUNT_FOR_MBR";

    public static final String SUB_TYPE_MAX_MBR_COUNT_FOR_SDPCARD = "MAX_MBR_COUNT_FOR_SDPCARD";

    // 激活会员MQ队列名
    public static final String QUEUE_NAME_MA_ACTIVE_MEMBER = "netfinworks.ma.activeMemberQueue";

    /** 安全处理 ticket与 摘要的分隔符 */
    public static final String SECURITY_TICKET_SUMMARY_SPLIT_CHAR = ":=";

    /** 安全处理 verify class 实证实体属性名 */
    public static final String SECURITY_VERIFY_ENTITY = "verifyEntity";

    /** 安全处理 verify class 实证实体类型属性名 */
    public static final String SECURITY_VERIFY_TYPE = "verifyType";

    /** 安全处理 email 属性名 */
    public static final String SECURITY_EMAIL = "email";

    /** 安全处理 真实姓名 属性名*/
    public static final String SECURITY_TRUE_NAME = "trueName";

    /** 安全处理 银行账号 属性名 */
    public static final String SECURITY_BANK_ACCOUNT_NO = "bankAccountNo";

    /** 安全处理 银行账号掩码  属性名 */
    public static final String SECURITY_BANK_ACCOUNT_NO_MASK = "bankAccountSummary";

    /** 安全处理 加密字段拆分后，ticket 字段后缀（字段全名为：密码字段名+ ticket） */
    public static final String SECURITY_TICKET_FIELD_SUFFIX = "Ticket";

    /** 扩展字段 安全标志字段 1代表绑定数字证书 */
    public static final String SECURITY_FLAG = "securityFlag";

    //银行卡过滤字段
    public static final String BANK_FILTER = "BANK_FILTER";

    /** 安全处理 BankAccount class certNo属性名 */
    public static final String SECURITY_CERT_NO = "certNo";

    /** 安全处理 BankAccount class certType属性名 */
    public static final String SECURITY_CERT_TYPE = "certType";

    /** 日志跟踪号名字 */
    public static final String LOGGER_TRACE_ID_NAME = "traceId";

    /**解密会员加密码信息接口扩展参数认证状态key */
    public static final String VERIFY_STATUS = "verifyStatus";

    /**新浪平台类型 */
    public static final int SINA_PLATFORM = 1;

    /**信用账户开户时扩展参数 */
    public static final String LOGIN_UID = "loginUId";

    /** 默认手机区号 */
    public static final String DEFAULT_AREA_CODE = "";

    public static final String SEQ_MEMBER_ID = "seq_member_id";

    public static final String SEQ_MERCHANT_ID = "seq_merchant_id";

    public static final String SEQ_OPERATOR_ID = "seq_operator_id";

    public static final String SEQ_REMOTE_REQUEST_NO = "seq_remote_request_no";

    public static final String SEQ_CONTACT_ID = "seq_contact_id";
}
