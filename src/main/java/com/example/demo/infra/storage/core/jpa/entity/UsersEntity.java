package com.example.demo.infra.storage.core.jpa.entity;

import com.example.demo.domain.Users;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;

    public UsersEntity() {
    }

    public UsersEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static UsersEntity create(Users users) {
        return new UsersEntity(users.getName(), users.getEmail());
    }
}
