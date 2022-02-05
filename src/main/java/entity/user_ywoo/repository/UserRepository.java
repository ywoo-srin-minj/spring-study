package entity.user_ywoo.repository;


import entity.user_ywoo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
