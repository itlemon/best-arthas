package cn.itlemon.best.arthas.http;

import java.io.Serializable;

import lombok.Getter;
import lombok.ToString;

/**
 * 统一API响应结果格式封装
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2022-01-16
 */
@Getter
@ToString
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 6308315887056661996L;

    private int code;
    private String msg;
    private T data;
    private final long timestamp;

    private Result() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.code = ResultCode.SUCCESS.getCode();
        result.msg = ResultCode.SUCCESS.getMsg();
        result.data = data;
        return result;
    }

    public static <T> Result<T> fail(ResultCode resultCode) {
        Result<T> result = new Result<>();
        result.code = resultCode.getCode();
        result.msg = resultCode.getMsg();
        return result;
    }

}
