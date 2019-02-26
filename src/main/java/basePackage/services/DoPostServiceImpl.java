package basePackage.services;

import basePackage.models.Post;
import basePackage.models.User;
import basePackage.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DoPostServiceImpl implements DoPostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> savePost(String post, User user) {
        Date date = new Date();
        String postHeader = date.toString() + "\n" + user.getName() + " " + user.getLastName();
        postRepository.save(new Post(post, postHeader, user.getUserPage()));
        List<Post> postList = postRepository.findAllByUserPageId(user.getUserPage().getId());
        return postList;
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
