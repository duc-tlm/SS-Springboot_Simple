package dev.duc.tlmse.config.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Info info = new Info();

        info.setTitle("Project SAPI");
        info.setVersion("1.0.0");
        License ducDEV = new License().name("DucDEV").url("https://github.com/DucDEV");
        info.license(ducDEV);

        Server localhost = new Server();
        localhost.url("http://localhost:8082");

        return new OpenAPI()
                .info(info).servers(List.of(localhost));
    }

}
