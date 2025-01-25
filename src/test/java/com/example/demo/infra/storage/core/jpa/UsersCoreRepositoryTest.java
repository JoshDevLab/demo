package com.example.demo.infra.storage.core.jpa;

import com.example.demo.domain.Users;
import com.example.demo.infra.storage.core.jpa.entity.UsersEntity;
import com.example.demo.support.IntegrationTestSupport;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsersCoreRepositoryTest extends IntegrationTestSupport {

    @Autowired
    UsersCoreRepository exampleRepository;

    @Autowired
    UserJpaRepository userJpaRepository;

    @Test
    public void saveUsers() {
        Users users = new Users(null, "Test user2", "test2@test.com");
        exampleRepository.create(users);
        List<UsersEntity> all = userJpaRepository.findAll();
        Assertions.assertThat(all).hasSize(2);
    }

    @Test
    public void saveUsers2() {
        Users users = new Users(null, "Test user3", "test3@test.com");
        exampleRepository.create(users);
        List<UsersEntity> all = userJpaRepository.findAll();
        Assertions.assertThat(all).hasSize(2);
    }


}