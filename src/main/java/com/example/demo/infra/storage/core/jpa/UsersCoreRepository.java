package com.example.demo.infra.storage.core.jpa;

import com.example.demo.domain.ExampleRepository;
import com.example.demo.domain.Users;
import com.example.demo.infra.storage.core.jpa.entity.UsersEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UsersCoreRepository implements ExampleRepository {

    private final UserJpaRepository userJpaRepository;

    public UsersCoreRepository(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public void create(Users users) {
        userJpaRepository.save(UsersEntity.create(users));
    }
}
