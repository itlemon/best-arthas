package cn.itlemon.best.arthas.demo.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.itlemon.best.arthas.http.ResultCode;
import cn.itlemon.best.arthas.http.advice.ResponseResult;
import cn.itlemon.best.arthas.http.exception.ApiException;
import cn.itlemon.best.arthas.model.demo.DemoModel;

/**
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2022-01-15
 */
@RestController
@ResponseResult
public class DemoController {

    @GetMapping("/")
    public int index() {
        return 1;
    }

    @GetMapping("/v2")
    public DemoModel index3() {
        DemoModel demoModel = new DemoModel();
        demoModel.setUsername("江平平");
        demoModel.setPassword(null);
        demoModel.setDate(new Date());
        demoModel.setModel(null);
        demoModel.setAge(null);
        demoModel.setAges(null);
        demoModel.setFlag(null);
        if (true) {
            throw new ApiException(ResultCode.BAD_REQUEST);
        }
        return demoModel;
    }


}
