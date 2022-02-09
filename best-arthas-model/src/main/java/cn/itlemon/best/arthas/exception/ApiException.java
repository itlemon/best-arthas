package cn.itlemon.best.arthas.http.exception;

import cn.itlemon.best.arthas.http.ResultCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2022-01-25
 */
@ToString
@Getter
public class ApiException extends RuntimeException {

    private final int code;
    private final String msg;
    private ResultCode resultCode;

    private ApiException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public ApiException(ResultCode resultCode) {
        this(resultCode.getCode(), resultCode.getDesc());
        this.resultCode = resultCode;
    }
}
