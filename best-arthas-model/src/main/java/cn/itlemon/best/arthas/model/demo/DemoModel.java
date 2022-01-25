package cn.itlemon.best.arthas.model.demo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2022-01-19
 */
@Getter
@Setter
public class DemoModel {

    private String username;

    private String password;

    private Date date;

    private Demo2Model model;

    private Integer age;

    private Integer[] ages;

    private Boolean flag;

    private class Demo2Model {
        String name;
        String pass;
    }

}
