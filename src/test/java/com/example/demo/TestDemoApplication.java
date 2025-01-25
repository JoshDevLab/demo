package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.testcontainers.utility.TestcontainersConfiguration;

public class TestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.from(DemoApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
