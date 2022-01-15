package cn.itlemon.best.arthas.http.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import cn.itlemon.best.arthas.http.advice.ResponseResultInterceptor;

/**
 * web相关的全局配置都在这里
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2022-01-16
 */
@Configuration
public class GlobalWebConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        registry.addInterceptor(new ResponseResultInterceptor()).addPathPatterns("/**");
    }

}
