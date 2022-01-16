package cn.itlemon.best.arthas.demo.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.itlemon.best.arthas.http.DemoResponseBody;
import cn.itlemon.best.arthas.http.advice.ResponseResult;

/**
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2022-01-15
 */
@RestController
@ResponseResult
public class DemoController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/v1", produces = "application/json;charset=utf-8")
    public String index2() {

        HttpServletResponse response = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
        assert response != null;
        System.out.println("Default charset: " + response.getCharacterEncoding());

        String s = DemoResponseBody.newBuilder()
                .setCode("succ")
                .setMessage("请求成功")
                .build().toString();
        return s;
    }


}
