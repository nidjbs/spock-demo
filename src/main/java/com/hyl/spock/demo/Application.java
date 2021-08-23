package com.hyl.spock.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author huayuanlin
 * @date 2021/08/22 17:27
 * @desc the class desc
 */
@SpringBootApplication()
@MapperScan("com.hyl.spock.demo.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
