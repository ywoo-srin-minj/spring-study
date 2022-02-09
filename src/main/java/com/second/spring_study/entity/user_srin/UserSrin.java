package com.second.spring_study.entity.user_srin;

import com.second.spring_study.dto.request.srin.UserUpdateRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//lombok 라이브러리를 이용
@Entity     //@Table을 통해 테이블을 직접적으로 매핑하지 않으면 현 클래스명의 카멜케이스가 기본적인 테이블명으로 setting
@Getter     //변수의 Getter 자동 생성
//@Setter     //변수의 Setter 자동 생성 -> 이후 name과 password만 변경가능하도록 작성? //feedback) Setter를 사용하면, 값 변경이 가능하므로 가급적 작성하지 않는것이 좋다.
@AllArgsConstructor //클래스의 모든 변수를 멤버변수로 받는 생성자
@NoArgsConstructor
public class UserSrin {
    @Id //PK지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //기본키 생성을 데이터 베이스에 위임(MySQL - Auto_increment를 사용하여 기본키 생성)
    private Long id;

    //name속성을 명시하지 않으면 칼럼변수의 이름으로 DB에 생성됨(카멜케이스라면 _형식으로 작성하는것이 좋음)
    //현재 칼럼 변수는 _형식이므로 굳이 작성하지 않아도 됨
    //length가 없으면 기본적으로 255가 지정
    @Column(name = "user_id" ,nullable = false, unique = true, length = 30) //테이블의 Column임을 명시
    private String user_id;

    @Column(nullable = false, length = 10)
    private String user_name;

    @Column(nullable = false, length = 30)
    private String user_password;

    public static UserSrin createUser(String user_id, String user_name, String user_password){
        UserSrin userSrin = new UserSrin();
        userSrin.user_id = user_id;
        userSrin.user_name = user_name;
        userSrin.user_password = user_password;
        return userSrin;
    }

    public static UserSrin updateUser(UserSrin userSrin, UserUpdateRequestDto userUpdateRequestDto){
        userSrin.user_name = userUpdateRequestDto.getUser_name();
        userSrin.user_password = userUpdateRequestDto.getUser_password();
        return userSrin;
    }

/*
    //직접 작성(window 단축키 Alt + insert)
    //생성자
    public User(int id, String user_id, String user_name, String user_password) {
        this.id = id;
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
    }

    //각 변수별 Getter와 Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
 */
}
