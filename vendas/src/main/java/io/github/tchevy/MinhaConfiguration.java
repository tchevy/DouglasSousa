package io.github.tchevy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
public class MinhaConfiguration {
    @Bean(name = "applicationName")
    public String applicationName(){
        return "Sistema de Vendas";
    }

    @SpringBootApplication
    @RestController
    public static class VendasApplication {

        @Autowired
        @Qualifier("applicationName")
        private String applicationName;

        @GetMapping("/hello")
        public String helloWord(){
            return "hello word";
        }
        public static void main(String[] args) {
            SpringApplication.run(VendasApplication.class, args);


        }
    }
}
