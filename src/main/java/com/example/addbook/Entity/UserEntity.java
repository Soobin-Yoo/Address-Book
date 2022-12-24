package com.example.addbook.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "users")
public class UserEntity {
    @Id
    private String userId;
    private String userName;
    private String passwd;
    private String birth;
    private String userTel;
}
