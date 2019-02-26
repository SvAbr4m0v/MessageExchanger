package basePackage.repositories;

import basePackage.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsersRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    Optional<User> findOneByUserName(String userName);

    User findUserByUserName(String userName);
}
