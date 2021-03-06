package com.second.spring_study.entity.ywoo.userYwoo;

import com.second.spring_study.entity.ywoo.postYwoo.PostYwoo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table()
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserYwoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private Long id;

    @Column(length = 30, unique = true, nullable = false, name = "user_id")
    private String userId;

    @Column(length = 10, nullable = false, name = "user_name")
    private String userName;

    @Column(length = 30, nullable = false, name = "user_password")
    private String userPassword;

    @OneToMany(mappedBy = "userYwoo",cascade = CascadeType.ALL)
    private List<PostYwoo> postYwoos = new ArrayList<>();

    public static UserYwoo createUser(String userId, String userName, String userPassword) {
        UserYwoo userYwoo = new UserYwoo();
        userYwoo.userId = userId;
        userYwoo.userName = userName;
        userYwoo.userPassword = userPassword;
        return userYwoo;
    }

    public UserYwoo updateUser(String userName, String userPassword){
        this.userName = userName;
        this.userPassword = userPassword;
        return this;
    }
}
