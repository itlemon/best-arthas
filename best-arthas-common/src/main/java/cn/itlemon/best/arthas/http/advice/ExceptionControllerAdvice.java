package cn.itlemon.best.arthas.http.advice;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cn.itlemon.best.arthas.http.Result;
import cn.itlemon.best.arthas.http.ResultCode;

/**
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2022-01-16
 */
//@RestControllerAdvice
public class ExceptionControllerAdvice {

//    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> argumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
//        // 从异常对象中拿到ObjectError对象
//        ObjectError objectError = exception.getBindingResult().getAllErrors().get(0);
//        // 然后提取错误提示信息进行返回
//        return new Result<>(ResultCode.PARAMS_IS_INVALID, objectError.getDefaultMessage());
        return null;
    }

}
