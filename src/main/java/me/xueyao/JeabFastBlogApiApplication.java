package me.xueyao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author simonxue
 */
@SpringBootApplication
@MapperScan("me.xueyao.mapper")
public class JeabFastBlogApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JeabFastBlogApiApplication.class, args);
    }

}
