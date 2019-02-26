package basePackage.services;

import org.springframework.stereotype.Service;

@Service
public interface LikeService {
    Long getOrDeleteLike(Long userId, Long postId);
}
