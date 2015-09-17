package springwstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@Configuration
@EnableScheduling
public class SpringWebsocketTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebsocketTestApplication.class, args);
    }
}
