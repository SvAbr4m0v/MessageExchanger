package basePackage.controllers;

import basePackage.models.Post;
import basePackage.models.User;
import basePackage.repositories.PostRepository;
import basePackage.repositories.UserPageRepository;
import basePackage.repositories.UsersRepository;
import basePackage.services.DoPostService;
import basePackage.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserPageController {
    @Autowired
    UserPageRepository userPageRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    DoPostService doPostService;
    @Autowired
    LikeService likeService;

    @GetMapping(path = "/user_page/{user-id}")
    public ModelAndView display(@PathVariable("user-id") Long id,
                                @CookieValue(value = "userCookie", required = false) String userCookie) {
        User user = usersRepository.findUserById(id);
        List<Post> postList = postRepository.findAllByUserPageId(user.getUserPage().getId());
        postList.sort((y, x) -> (int) (x.getId() - y.getId()));
        ModelAndView modelAndView = new ModelAndView("user_page");
        modelAndView.addObject("user", user);
        modelAndView.addObject("posts", postList);
        return modelAndView;
    }

    @PostMapping(path = "/user_page/{user-id}")
    public ModelAndView savePost(@PathVariable("user-id") Long id,
                                 String post,
                                 HttpServletRequest request) {
        User user = usersRepository.findUserById(id);
        ModelAndView modelAndView = new ModelAndView("user_page");
        modelAndView.addObject("user", user);
        if (post != null) {
            modelAndView.addObject("posts", doPostService.savePost(post, user));
            return modelAndView;
        } else {
            return modelAndView;
        }
    }

    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout/";
    }

    @PostMapping(path = "/user_page/{user-id}/doLike")
    public String doLike(@PathVariable("user-id") Long id,
                         Long postId) {
        likeService.getOrDeleteLike(id, postId);
        return "redirect:/user_page/{user-id}/";
    }

    @PostMapping(path = "/user_page/{user-id}/delete")
    public String deletePost(@PathVariable("user-id") Long userId,
                             Long id) {
        doPostService.deletePost(id);
        return "redirect:/user_page/{user-id}/";
    }
}
