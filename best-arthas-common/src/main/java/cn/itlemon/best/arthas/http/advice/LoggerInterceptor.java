package cn.itlemon.best.arthas.http.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Strings;

import cn.itlemon.best.arthas.constant.CommonConstants;
import cn.itlemon.best.arthas.utils.UuidUtil;

/**
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2022-01-26
 */
public class LoggerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 如果有上层调用就用上层的ID
        String traceId = request.getHeader(CommonConstants.HTTP_TRACE_ID);
        if (Strings.isNullOrEmpty(traceId)) {
            traceId = UuidUtil.uuid();
        }
        MDC.put(CommonConstants.HTTP_TRACE_ID, traceId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // do nothing
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // 调用结束后删除
        MDC.remove(CommonConstants.HTTP_TRACE_ID);
    }
}
