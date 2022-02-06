package entity.user_minj;

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

    public static User createUser(Long id, String user_id, String user_password, String user_name){
        User user = new User();
        user.id = id;
        user.user_id = user_id;
        user.user_password = user_password;
        user.user_name = user_name;

        return user;
    }
}
