package com.second.spring_study.entity.user_minj;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String user_id;

    @Column(nullable = false, length = 30)
    private String user_password;

    @Column(nullable = false, length = 10)
    private String user_name;

}
