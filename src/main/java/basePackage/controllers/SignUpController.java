package basePackage.controllers;

import basePackage.models.User;
import basePackage.repositories.UsersRepository;
import basePackage.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignUpController {
    @Autowired
    SignUpService signUpService;

    @Autowired
    UsersRepository usersRepository;

    @GetMapping(path = "/signup")
    public String  display() {
        return "/signup";
    }

    @PostMapping(path = "/signup")
    public String signUp(String userName,
                         String userPassword,
                         String name,
                         String lastName,
                         HttpServletResponse response) {
        if (signUpService.isSignedUp(userName,
                userPassword,
                name,
                lastName)) {
            User newUser = usersRepository.findOneByUserName(userName).orElseThrow(IllegalArgumentException::new);
            response.addCookie(new Cookie("userCookie", newUser.getId().toString()));
            return "redirect:/user_page/" + newUser.getId();
        } else
            return "redirect:/signup/";

    }

}
