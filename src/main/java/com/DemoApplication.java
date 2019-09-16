package com;

import com.huyi.demo.interceptor.WebMvcConfg;
import com.huyi.redis.RedisUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
@ServletComponentScan(basePackages = "huyi.demo.listener.RequestListener")
public class DemoApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        RedisUtil redisUtil = context.getBean(RedisUtil.class);
        WebMvcConfg loginInterceptor = context.getBean(WebMvcConfg.class);
        System.err.println("redisUtil:" + redisUtil);
        System.err.println("loginInterceptor:" + loginInterceptor);

    }

}
