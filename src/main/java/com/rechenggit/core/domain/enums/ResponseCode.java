package com.rechenggit.core.domain.enums;

/**
 * <p>应答码定义</p>
 * @author netfinworks
 * @version $Id: ResponseCode.java, v 0.1 2010-11-29 下午01:58:24 netfinworks Exp $
 */
public enum ResponseCode {
    //000~199全局
    SUCCESS("200", "operation.success"),
    NO_QUERY_RESULT("001", "no_query_result"),
    ARGUMENT_ERROR("002", "argument_error"),
    SIGN_CHECK_FAILURE("003", "sign_check_failure"),
    TRANS_AUTH_FAILURE("004", "trans_auth_failure"),
    INTERFACE_COMPATIBALE_ERROR("005", "interface_compatibale_error"),
    OPERATION_FAILURE("006", "operation_failure"),
    EXCEED_COUNT_LIMIT("007", "exceed_count_limit"),
    DUPLICATE_RECORD("008", "duplicate_record"),
    NO_EXIST_RECORD("009", "no_exist_record"),



    //100~899会员-逻辑
    MEMBER_CREATE_FAIL("101", "member_create_fail"),
    MEMBER_EXIST("102", "member_exist"),
    MEMBER_NOT_EXIST("103", "member_not_exist"),
    MEMBER_IDENTITY_EXIST("104","member_identity_exist"),
    MEMBER_NOT_SAME("105","member_not_same"),
    MEMBER_CREATE_IDENTITY_FAIL("106", "member_create_identity_fail"),
    MEMBER_CANCEL_FAIL("108","member_cancel_fail"),
    MEMBER_ACTIVE_FAIL("110","member_active_fail"),
    MEMBER_SLEEP_FAIL("112","member_sleep_fail"),
    MEMBER_AWAKE_FAIL("114","member_awake_fail"),
    MEMBER_LOCK_FAIL("115","member_lock_fail"),
    MEMBER_UNLOCK_FAIL("116","member_unlock_fail"),
    MEMBER_UPDATE_FAIL("117","member_update_fail"),
    MEMBER_CANCELLED("118", "member_cancelled"),
    MEMBER_TYPE_FAIL("119", "member_type_fail"),
    MEMBER_DUPLICATE_CANCELLED("120", "member_duplicate_cancelled"),
    MEMBER_LOCKED("121", "member_locked"),
    MEMBER_ALREADY_ACTIVE("122","member_already_active"),
    EXTERNAL_USER_ALEREADY_BIND("124","external_user_aleready_bind"),
    OPERATIONS_NOT_ALLOWED_ON_TEMP_MEMBER("125","operations_not_allowed_on_temp_member"),
    TEMP_MEMBER_BIND_FAIL("126","temp_member_bind_fail"),
    TEMP_MEMBER_UPGRADE_FAIL("127","temp_member_upgrade_fail"),
    MEMBER_IDENTITY_NOT_EXIST("128", "member_identity_not_exist"),
    ACCOUNT_ACTIVE_FAIL("129","account_active_fail"),
    MEMBER_UNACTIVE("130","member_unactive"),
    MEMBER_SLEEP("132","member_sleep"),
    MEMBER_STATUS_UPDATE_FAIL("133","member_status_update_fail"),
    ACCOUNT_ID_NOT_EXIST("134","account_id_not_exist"),
    OPERATOR_ACCOUNT_ID_NOT_MATCH("135","operator_account_id_not_match"),
    MEMBER_EXT_CONFIG_NOT_EXIST("136","member_ext_config_not_exist"),


    OPERATOR_NOT_EXIST("201", "operator_not_exist"),
    OPERATOR_CREATE_FAIL("202", "operator_create_fail"),
    OPERATOR_CREATE_FAIL_MEMBER_STATUS("203","operator_create_fail_member_status"),
    OPERATOR_NOT_SAME("204","operator_not_same"),
    OPERATOR_UPDATE_FAIL("205","operator_update_fail"),
    OPERATOR_CANCEL_FAIL("206","operator_cancel_fail"),
    OPERATOR_ACTIVE_FAIL("207","operator_active_fail"),
    OPERATOR_LOCK_FAIL("208","operator_lock_fail"),
    OPERATOR_UNLOCK_FAIL("209","operator_unlock_fail"),
    OPERATOR_STATUS_NOT_MATCH("210","operator_status_not_match"),
    OPERATOR_NOT_IN_MEMBER("211","operator_not_in_member"),
    OPERATOR_LOCKED("212","operator_locked"),
    OPERATOR_DEFAULT_EXIST("213","operator_default_exist"),
    OPERATOR_LOGIN_NAME_NOT_MATCH("214", "operator_login_name_not_match"),
    OPERATOR_DUPLICATE_LINK("215", "operator_duplicate_link"),
    OPERATOR_CREATE_FAIL_MEMBER_TYPE("216","operator_create_fail_member_type"),

    OPERATOR_UNACTIVE("230","operator_unactive"),
    OPERATOR_CANCEL("233","operator_cancel"),

    LOGIN_NAME_ADD_FAIL("249","login_name_add_fail"),
    LOGIN_NAME_NOT_EXIST("250", "login_name_not_exist"),
    LOGIN_NAME_EXIST("251", "login_name_exist"),
    LOGIN_NAME_LAST_ONE("252","login_name_last_one"),
    LOGIN_NAME_NOT_ADD("253", "login_name_not_add"),
    LOGIN_NAME_REMOVE_FAIL("254","login_name_remove_fail"),

    PASSWORD_SET_FAIL("255","password_set_fail"),
    PASSWORD_CHECK_FAIL("256","password_check_fail"),
    PASSWORD_NOT_EXISTS("257","password_not_exists"),
    PASSWORD_TOO_SIMPLE("259","password_too_simple"),
    PASSWORD_TOO_SHORT("260","password_too_short"),
    PASSWORD_TOO_LONG("261","password_too_long"),
    PASSWORD_ILLEGAL_CHAR("262","password_illegal_char"),
    PASSWORD_EQUAL_LOGIN_PASSWORD("263","password_equal_login_password"),
    PASSWORD_LOCKED("264","password_locked"),

    LOGIN_PASSWORD_UPDATE_FAIL("265","login_password_update_fail"),
    LOGIN_PASSWORD_CHECK_FAIL("266","login_password_check_fail"),
    LOGIN_PASSWORD_NOT_EXISTS("267","login_password_not_exists"),
    LOGIN_PASSWORD_LOCKED("274","login_password_locked"),
    PASSWORD_FLAG_NULL("275","password_flag_null"),
    LOGIN_PASSWORD_EQUAL_PAY("276","login_password_equal_pay"),

    CONTACT_EXIST("280", "contact_exist"),
    CONTACT_NOT_EXIST("281", "contact_not_exist"),
    CONTACT_SAVE_FAIL("282", "contact_save_fail"),
    CONTACT_UPDATE_FAIL("283", "contact_update_fail"),
    CONTACT_DELETE_FAIL("284", "contact_delete_fail"),

    ACCOUNT_NOT_EXIST("290","account_not_exist"),
    ACCOUNT_QUERY_FAIL("291","account_query_fail"),
    ACCOUNT_CREATE_FAIL("292","account_create_fail"),
    ACCOUNT_CHECK_CLEAR_FAIL("293","account_check_clear_fail"),
    ACCOUNT_TYPE_NOT_EXIST("294", "account_type_not_exist"),
    ACCOUNT_MEMBER_TYPE_NOT_MATCH("295", "account_member_type_not_match"),
    ACCOUNT_EXCEED_MAX_COUNT("297", "account_exceed_max_count"),
    ACCOUNT_SET_STATUS_FAIL("298", "account_set_status_fail"),
    ACCOUNT_BULK_QUERY_FAIL("299", "account_bulk_query_fail"),

    
    MERCHANT_CREATE_FAIL("300", "merchant_create_fail"),
    MERCHANT_ACT_FAIL("301", "merchant_act_fail"),
    MERCHANT_CAN_FAIL("302", "merchant_can_fail"),
    MERCHANT_NOT_EXIST("303", "merchant_not_exist"),
    DUPLICATE_MERCHANT_NAME("304", "duplicate_merchant_name"),
    DUPLICATE_MERCHANT_ID("305", "duplicate_merchant_id"),
    MERCHANT_CANCELLED("306", "merchant_cancelled"),
    MERCHANT_DUPLICATE_CANCELLED("307", "merchant_duplicate_cancelled"),
    MEMBER_MERCHANT_EXIST("308", "member_merchant_exist"),
    MERCHANT_NOT_CREATE("309", "merchant_not_create"),
    MERCHANT_UPDATE_FAIL("310", "merchant_update_fail"),
    MERCHANT_UPDATE_STATUS_FAIL("311", "merchant_update_status_fail"),
    MERCHANT_MEMBER_FAIL("312","merchant_member_fail"),


    ORG_CREATE_FAIL("401", "org_create_fail"),
    ORG_CAN_FAIL("402", "org_can_fail"),
    ORG_UPDATE_FAIL("403", "org_update_fail"),
    ORG_ADD_NODE_FAIL("404", "org_add_node_fail"),
    RMV_ORG_NODE_FAIL("405", "rmv_org_node_fail"),
    ADD_ORG_CONT_FAIL("407", "add_org_cont_fail"),
    ORG_NOT_EXIST("408", "org_not_exist"),
    MOVE_ORG_NODE_FAIL("410", "move_org_node_fail"),
    ORG_CANCELLED("412", "org_cancelled"),
    ORG_NODE_NOT_EXIST("413", "org_node_not_exist"),
    MOVE_ORG_NODE_ROOT("417", "move_org_node_root"),
    ORG_NODE_NEW_PARENT_CAUSE_CYCLE("419", "org_node_new_parent_cause_cycle"),
    MEMBER_IN_ORG("421", "member_in_org"),
    MEMBER_NOT_IN_ORG("422", "member_not_in_org"),
    MEMBER_NOT_DESCENDANT("423", "member_not_descendant"),
    MEMBER_NOT_ROOT("424", "member_not_root"),


    ADD_VERIFY_FAIL("451", "add_verify_fail"),
    GET_VERIFY_FAIL("452", "get_verify_fail"),
    UPDATE_VERIFY_FAIL("453", "update_verify_fail"),
    SAVE_VERIFY_IMG_FAIL("454", "save_verify_img_fail"),
    DUPLICATE_VERIFY("455", "duplicate_verify"),
    VERIFY_NOT_EXIST("456", "verify_not_exist"),
    VERIFY_MEMBER_FAIL("457","verify_member_fail"),
    VERIFY_MOBILE_FAIL("458","verify_mobile_fail"),


    DISTRICT_NOT_EXIST("501", "district_not_exist"),
    DECIPHERED_TYPE_NOT_EXIST("502", "deciphered_type_not_exist"),

    SET_BANK_ACCOUNT_FAIL("600","set_bank_account_fail"),
    SET_BANK_ACCOUNT_STATUS_FAIL("601", "set_bank_account_status_fail"),
    VERIFIE_BANK_ACCOUNT_FAIL("602", "verifie_bank_account_fail"),
    BANK_ACCOUNT_NOT_EXISTS("603", "bank_account_not_exists"),
    BANK_ACCOUNT_NO_SUMMARY_CONFLICT("604", "bank_account_no_summary_conflict"),
    MEMBER_BANK_ACCOUNT_NOT_MATCH("605","member_bank_account_not_match"),
    BANK_ACCOUNT_TOO_MANY("607","bank_account_too_many"),
    BANK_ACCOUNT_LOCK("609","bank_account_lock"),
    CERT_NO_FILL_FAIL("611","cert_no_fill_fail"),
    BANK_ACCOUNT_PAY_DONT_UPDATE("613","bank_account_pay_dont_update"),

    QUERY_ACCOUNT_BALANCE_FAIL("701", "query_account_balance_fail"),
    QUERY_ACCOUNT_BALANCE_LIST_FAIL("702", "query_account_balance_list_fail"),
    ACTIVATE_ACCOUNT_STATUS_FAIL("703","activate_account_status_fail"),
    CHANGE_DENY_ACCOUNT_STATUS_FAIL("704","change_deny_account_status_fail"),
    CHANGE_CANCELED_ACCOUNT_STATUS_FAIL("705","change_canceled_account_status_fail"),
    GET_ACCOUNT_BALANCE_LIST_FAIL("706","get_account_balance_list_fail"),
    GET_ACCOUNT_STATUS_LIST_FAIL("707","get_account_status_list_fail"),

    CREATE_CREDIT_FAIL_MOBILE("720","create_credit_fail_mobile"),

    QUERY_CARD_BIN_FAIL("750","query_card_bin_fail"),



    //900-999全局
    UNKNOWN("999", "unknown"),
    DB_NO_EFFECTED_ROWS("998","db_no_effected_rows"),
    DB_MORE_EFFECTED_ROWS("997","db_more_effected_rows");

    /** 代码 */
    private final String code;
    /** 信息 */
    private final String message;

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过代码获取枚举项
     * @param code
     * @return
     */
    public static ResponseCode getByCode(String code) {
        if (code == null) {
            return null;
        }

        for (ResponseCode responseCode : ResponseCode.values()) {
            if (responseCode.getCode().equals(code)) {
                return responseCode;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
