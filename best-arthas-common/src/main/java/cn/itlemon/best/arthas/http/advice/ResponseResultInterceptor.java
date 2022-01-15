package cn.itlemon.best.arthas.http.advice;

import static cn.itlemon.best.arthas.constant.CommonConstants.RESPONSE_RESULT_ANN;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2022-01-16
 */
public class ResponseResultInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 注解应用在方法上
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            // 设置此请求返回体需要是否需要包装，往下传递，在ResponseBodyAdvice接口进行判断
            request.setAttribute(RESPONSE_RESULT_ANN,
                    clazz.isAnnotationPresent(ResponseResult.class) || method.isAnnotationPresent(
                            ResponseResult.class));
        }
        return true;
    }
}
