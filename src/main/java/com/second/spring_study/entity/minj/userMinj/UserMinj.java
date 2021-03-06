package com.second.spring_study.entity.minj.userMinj;

import com.second.spring_study.entity.minj.postMinj.PostMinj;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserMinj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id", nullable = false, unique = true, length = 30)
    private String userId;

    @Column(name="user_password", nullable = false, length = 30)
    private String userPassword;

    @Column(name="user_name", nullable = false, length = 10)
    private String userName;

    @OneToMany(mappedBy = "userMinj", cascade = CascadeType.ALL)
    private List<PostMinj> postMinjs = new ArrayList<>();

    public static UserMinj createUser(String userId, String userName, String userPassword) {
        UserMinj userMinj = new UserMinj();
        userMinj.userId = userId;
        userMinj.userName = userName;
        userMinj.userPassword = userPassword;
        return userMinj;
    }
}
