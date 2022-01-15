package cn.itlemon.best.arthas.exception;

/**
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2022-01-16
 */
public class ApiException extends RuntimeException {

    public ApiException() {
    }

    public ApiException(String msg) {
        super(msg);
    }

}
