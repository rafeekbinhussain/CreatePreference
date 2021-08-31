package com.tbpay.preference;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEncryptableProperties
@Slf4j
public class PreferenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PreferenceApplication.class, args);
        log.info("Welcome to TB Pay Preference CreateOrUpdate Service");
    }
}
