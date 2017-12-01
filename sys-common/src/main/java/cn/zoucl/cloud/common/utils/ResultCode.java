package cn.zoucl.cloud.common.utils;

/**
 * Created by vicqiang on 2017/6/1 0001.
 * 返回结果代码类
 */
public enum ResultCode {
    /** 成功 */
    SUCCESS("0", "success"),

    /** 未请求成功 */
    FAIL("1", "fail"),

    /** 未授权 */
    AUTH_ERROR("101", "Unauthorized");

    ResultCode(String value, String msg){
        this.val = value;
        this.msg = msg;
    }

    public String val() {
        return val;
    }

    public String msg() {
        return msg;
    }

    private String val;
    private String msg;
}
