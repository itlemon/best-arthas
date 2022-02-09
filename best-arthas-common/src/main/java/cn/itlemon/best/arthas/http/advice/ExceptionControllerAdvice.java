package cn.itlemon.best.arthas.http.advice;

import java.util.Objects;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cn.itlemon.best.arthas.http.Result;
import cn.itlemon.best.arthas.http.ResultCode;
import cn.itlemon.best.arthas.http.exception.ApiException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2022-01-16
 */
@Slf4j
@RestControllerAdvice(basePackages = {"cn.itlemon"})
public class ExceptionControllerAdvice {

    /**
     * 处理参数校验异常的处理器
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> argumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        // 从异常中提取错误信息
        String defaultMessage = exception.getAllErrors().get(0).getDefaultMessage();

        // 获取发生异常的属性
        String fieldName = Objects.requireNonNull(exception.getBindingResult().getFieldError()).getField();

        log.warn("No exceptionCode get, fieldName: {}, message: {}", fieldName, defaultMessage);
        // 统一响应体返回
        return Result.fail(ResultCode.PARAMS_IS_INVALID, defaultMessage);
    }

    @ExceptionHandler(ApiException.class)
    public Result<String> apiExceptionHandler(ApiException exception) {
        log.warn("ExceptionCode: {}, ExceptionMessage: {}.", exception.getCode(), exception.getMsg());
        // 统一响应体返回
        return Result.fail(exception.getResultCode());
    }

}
