package br.com.gz.finance.apifinance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ApiFinanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiFinanceApplication.class, args);
    }
}
