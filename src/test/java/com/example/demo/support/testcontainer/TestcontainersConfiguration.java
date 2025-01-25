package com.example.demo.support.testcontainer;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

    @Bean
    @ServiceConnection // MySQLContainer를 Spring 데이터 소스로 자동 등록
    MySQLContainer<?> mysqlContainer() {
        return new MySQLContainer<>(DockerImageName.parse("mysql:latest"))
                .withDatabaseName("test_db")
                .withUsername("test_user")
                .withPassword("test_password");
    }

    @Bean
    @ServiceConnection(name = "redis") // RedisContainer를 Spring Redis 설정으로 자동 등록
    GenericContainer<?> redisContainer() {
        return new GenericContainer<>(DockerImageName.parse("redis:latest"))
                .withExposedPorts(6379);
    }

}
