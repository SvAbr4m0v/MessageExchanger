package basePackage.repositories;

import basePackage.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findOneById(Long id);

    List<Post> findAllByUserPageId(Long id);

    @Transactional
    void deleteById(Long id);
}
