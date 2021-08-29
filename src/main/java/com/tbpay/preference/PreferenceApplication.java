package com.tbpay.preference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class PreferenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PreferenceApplication.class, args);
        log.info("Welcome to TB Pay");
    }

}
