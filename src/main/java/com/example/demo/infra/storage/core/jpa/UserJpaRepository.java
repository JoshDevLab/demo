package com.example.demo.infra.storage.core.jpa;

import com.example.demo.infra.storage.core.jpa.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UsersEntity, Long> {
}
