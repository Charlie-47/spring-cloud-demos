package top.charlie.cloud.registercenter;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegisterCenter {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RegisterCenter.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

}
