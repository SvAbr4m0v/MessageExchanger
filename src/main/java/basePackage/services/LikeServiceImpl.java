package basePackage.services;

import basePackage.models.Like;
import basePackage.models.Post;
import basePackage.repositories.LikeRepository;
import basePackage.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    LikeRepository likeRepository;
    @Autowired
    PostRepository postRepository;

    @Override
    public Long getOrDeleteLike(Long userId, Long postId) {
        Post post = postRepository.findOneById(postId);
        if (likeRepository.findLikeByUserIdAndPostId(userId, postId).isPresent()) {
            post.decreaseAmountOfLikes();
            postRepository.save(post);
            likeRepository.deleteByUserIdAndPostId(userId, postId);
            return post.getAmountOfLikes();
        } else {
            post.increaseAmountOfLikes();
            postRepository.save(post);
            Like like = Like.builder()
                    .userId(userId)
                    .postId(postId)
                    .build();
            likeRepository.save(like);
            return post.getAmountOfLikes();
        }
    }
}
