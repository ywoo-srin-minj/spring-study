package com.second.spring_study.entity.user_minj;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class UserMinj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String user_id;

    @Column(nullable = false, length = 30)
    private String user_password;

    @Column(nullable = false, length = 10)
    private String user_name;

    public static UserMinj createUser(String user_id, String user_name, String user_password) {
        UserMinj userMinj = new UserMinj();
        userMinj.user_id = user_id;
        userMinj.user_name = user_name;
        userMinj.user_password = user_password;
        return userMinj;
    }
}
