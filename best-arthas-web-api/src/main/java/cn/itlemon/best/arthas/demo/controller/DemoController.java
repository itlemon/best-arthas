package cn.itlemon.best.arthas.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/v1")
    public String index2() {
        return DemoResponseBody.newBuilder()
                .setCode("succ")
                .setMessage("请求成功")
                .build().toString();
    }


}
