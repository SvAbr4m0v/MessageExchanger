package basePackage.repositories;

import basePackage.models.UserPage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPageRepository extends JpaRepository<UserPage, java.lang.Long> {
    UserPage findOneById(java.lang.Long id);

    UserPage findOneByUserId(java.lang.Long id);
}
