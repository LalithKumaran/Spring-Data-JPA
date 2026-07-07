package com.dailycodebuffer.spring_data_jpa_tutorial.checker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SecretTest implements CommandLineRunner {
    @Value("${db_username}")
    private String username;

    @Value("${db_password}")
    private String password;

    @Override
    public void run(String... args) {
        System.out.println("Username = " + username);
        System.out.println("Password = " + password);
    }
}
