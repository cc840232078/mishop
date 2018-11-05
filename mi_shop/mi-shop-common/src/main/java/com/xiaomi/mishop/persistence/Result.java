package com.xiaomi.mishop.persistence;

/**
 * service返回的信息
 */
public class Result<T> {

    public static final int ERROR_STATUS = 500;//失败的状态

    public static final int SUCCESS_STATUS = 200;//成功状态

    private int status = SUCCESS_STATUS;//处理结果是否成功

    private String message;//返回信息

    private Object data;//返回的数据

    /**
     * 出错的时候可以直接用
     *
     * @param message
     * @return
     */
    public static Result fail(String message) {
        Result result = new Result();
        result.setMessage(message);
        result.setStatus(ERROR_STATUS);
        return result;
    }

    /**
     * 成功时可以调用
     *
     * @param message
     * @param data
     * @return
     */
    public static Result success(String message, Object data) {
        Result result = new Result();
        result.setMessage(message);
        result.setStatus(SUCCESS_STATUS);
        result.setData(data);
        return result;
    }

    public static int getSuccessStatus() {
        return SUCCESS_STATUS;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        return "Result{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
