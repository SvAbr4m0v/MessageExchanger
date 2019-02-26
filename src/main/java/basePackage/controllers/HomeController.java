package basePackage.controllers;

import basePackage.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    @Autowired
    UsersRepository usersRepository;

    @GetMapping(value = {"/", "/home"})
    public String display(Authentication authentication,
                          HttpServletResponse response) {
        if (authentication != null) {
            Long id = usersRepository.findOneByUserName(authentication.getName()).get().getId();
            Cookie cookie = new Cookie("userCookie", id.toString());
            response.addCookie(cookie);
            return "redirect:/user_page/" + id;
        }
        return "login";
    }

}
