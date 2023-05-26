package com.studydemo.constant;

public enum stateCodeMsg {
    SUCCESS(0,"成功"),
    ERROR(-1,"接口调用异常"),
    JWT_EXCEPTION(101,"JWT校检异常"),
    TOKEN_EXCEPTION(102,"TOKEN失效"),


    // 通用业务 格式500 xxx
    BUSINESS_ERROR(500000,"业务异常"),
    ONLINE_USER_OVER(500003,"在线用户数超出允许登录的最大用户限制。"),
    NOT_FIND_DATA(500005,"查找不到对应数据"),
    VERIFY_CODE_ERROR(500006,"验证码错误"),
    PARAMETER_ISNULL(500007,"参数为空"),
    PARAMETER_ILLEGAL(500008,"参数不合法"),
    UPLOAD_IMAGE_ILLEGAL(500009,"上传的图片不能为空"),
    EMPTY_PAGE_SIZE_OR_PAGE_INDEX(500010,"分页大小或页码为空"),
    ADD_DATA_ERROR(500011,"添加数据失败"),
    EDIT_DATA_ERROR(500012,"编辑数据失败"),
    OPERATE_FAILED(500013,"本次操作失败"),
    PASSWORD_ERROR(500014,"密码或用户名错误"),
    USER_ERROR(500015,"用户已存在"),


    // 系统相关 格式600 xxx
    ROLE_EDIT_NOT_ALLOWED(600005, "系统内置角色请勿删除或改名"),

    // 记账相关 格式700 xxx
    INSERT_RECORD_ERROR(700001,"新增记账记录失败"),
    UPDATE_RECORD_ERROR(700002,"更新记账记录失败"),
    DEL_RECORD_FORBIDDEN(700003,"禁止删除他人记账记录"),
    DEL_RECORD_ERROR(700004,"删除记账记录失败"),
    RECORD_TYPE_CODE_ERROR(700005,"记账类型编码错误"),
    ;


    private final int retCode;
    private String message;
    stateCodeMsg(int retCode, String message) {
        this.retCode = retCode;
        this.message = message;
    }

    public int getRetCode() {
        return retCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

