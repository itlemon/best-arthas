package cn.itlemon.best.arthas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2022-01-15
 */
@SpringBootApplication(scanBasePackages = {"cn.itlemon.best.arthas"})
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }


}
