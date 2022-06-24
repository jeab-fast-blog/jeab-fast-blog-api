package me.xueyao;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author simonxue
 */
@Slf4j
@SpringBootApplication
@MapperScan("me.xueyao.mapper")
public class JeabFastBlogApiApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(JeabFastBlogApiApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        log.info("\n----------------------------------------------------------\n\t" +
                "Application Jeab Fast Blog is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port  + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + "/\n\t" +
                "Swagger文档: \thttp://" + ip + ":" + port  + "/doc.html\n" +
                "----------------------------------------------------------");
    }

}
