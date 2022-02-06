package com.second.spring_study.entity.user_ywoo;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name="user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private Long id;

    @Column(length = 30, unique = true, nullable = false, name = "user_id")
    private Long user_id;

    @Column(length = 10, nullable = false, name = "user_name")
    private String user_name;

    @Column(length = 30, nullable = false, name = "user_password")
    private String user_password;

}
