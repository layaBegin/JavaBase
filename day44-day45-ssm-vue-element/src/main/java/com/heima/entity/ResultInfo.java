package com.heima.entity;

/**
封装操作结果的对象
*/
public class ResultInfo {

    private Boolean success;  //是否操作成功
    private String message;   //操作信息
    private Object data;      //其它的数据

    // 一个参数构造
    public ResultInfo(Boolean success) {
        this.success = success;
    }

    // 二个参数构造
    public ResultInfo(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    //二个参数构造方法
    public ResultInfo(Boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    // 三个参数构造
    public ResultInfo(Boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
