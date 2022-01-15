package cn.itlemon.best.arthas.http.advice;

import static cn.itlemon.best.arthas.constant.CommonConstants.RESPONSE_RESULT_ANN;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.itlemon.best.arthas.http.Result;
import lombok.SneakyThrows;

/**
 * 返回体统一处理
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2022-01-16
 */
@RestControllerAdvice
public class ResponseResultAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(
                RequestContextHolder.getRequestAttributes())).getRequest();
        // 判断请求是否有包装标志
        return request.getAttribute(RESPONSE_RESULT_ANN) != null && (boolean) request.getAttribute(RESPONSE_RESULT_ANN);
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
            ServerHttpResponse response) {
        if (body instanceof String) {
            // 注意：string类型返回要单独json序列化返回一下，不然会报转换异常
            return objectMapper.writeValueAsString(Result.success(body));
        } else if (body instanceof Result) {
            return body;
        } else {
            return Result.success(body);
        }
    }
}
