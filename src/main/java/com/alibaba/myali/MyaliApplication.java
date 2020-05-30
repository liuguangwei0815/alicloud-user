package com.alibaba.myali;

import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.io.ClassPathResource;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.alibaba")
@EnableDiscoveryClient
public class MyaliApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(MyaliApplication.class);
        //  设置启动图片
        springApplication.setBanner(new ResourceBanner(new ClassPathResource("banner_bak.txt")));
        springApplication.run(args);
    }


}
