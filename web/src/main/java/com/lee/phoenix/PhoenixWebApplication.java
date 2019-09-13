package com.lee.phoenix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
@ComponentScan("com.lee.phoenix")
@EnableJpaRepositories("com.lee.phoenix")
@EntityScan("com.lee.phoenix")
尽量使用默认路径，让spring可以扫描到所有的模块内容，不然就是考验你耐心的时刻
*/
@SpringBootApplication
public class PhoenixWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(PhoenixWebApplication.class, args);
    }

}
