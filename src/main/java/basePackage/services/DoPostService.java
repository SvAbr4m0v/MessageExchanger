package basePackage.services;

import basePackage.models.Post;
import basePackage.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoPostService {
    List<Post> savePost(String post, User user);

    void deletePost(Long postId);
}
