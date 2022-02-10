package com.second.spring_study.entity.user_ywoo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table()

public class UserYwoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private Long id;

    @Column(length = 30, unique = true, nullable = false, name = "user_id")
    private String user_id;

    @Column(length = 10, nullable = false, name = "user_name")
    private String user_name;

    @Column(length = 30, nullable = false, name = "user_password")
    private String user_password;

    public static UserYwoo createUser(String user_id, String user_name, String user_password) {
        UserYwoo userYwoo = new UserYwoo();
        userYwoo.user_id = user_id;
        userYwoo.user_name = user_name;
        userYwoo.user_password = user_password;
        return userYwoo;
    }


    public UserYwoo updateUser(String user_name, String user_password){
        this.user_name = user_name;
        this.user_password = user_password;
        return this;
    }
}
