package entity.user_minj.repository;

import entity.user_minj.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
