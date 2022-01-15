package cn.itlemon.best.arthas.http.advice;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解：当使用该注解后，返回体则自动使用{@link cn.itlemon.best.arthas.http.Result} 来进行包装，否则直接返回结果
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2022-01-16
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseResult {


}
