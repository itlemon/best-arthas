package cn.itlemon.best.arthas.http;

import lombok.Getter;
import lombok.ToString;

/**
 * 返回码
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2022-01-15
 */
@Getter
@ToString
public enum ResultCode {

    /**
     * 系统返回码
     */
    SUCCESS(200, "success"),
    BAD_REQUEST(400, "bad request"),
    UNAUTHORIZED(401, "authentication failed"),
    NOT_FOUND(404, "interface does not exist"),
    INTERNAL_SERVER_ERROR(500, "system error"),
    METHOD_NOT_ALLOWED(405, "request method not allowed"),

    /**
     * 业务返回码：1000-9999
     */
    PARAMS_IS_INVALID(1000, "invalid parameter");

    private final int code;
    private final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
