package com.lx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.lx.mapper")
public class BigDataAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigDataAdminApplication.class,args);
    }
}
