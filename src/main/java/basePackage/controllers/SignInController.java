package basePackage.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller

public class SignInController {

    @GetMapping(path = "/login")
    public String display(Authentication authentication,
                          Model model,
                          HttpServletRequest request) {
        if (authentication != null) {
            return "redirect:/home";
        }
        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", true);
        }
        return "login";
    }


//    @Autowired
//    UsersRepository userRepository;
//
//    @Autowired
//    LoginService loginService;
//    @RequestMapping(path = "/signin", method = RequestMethod.POST)
//    public String login(@CookieValue(value = "userCookie", required = false) String userCookie,
//                              String username,
//                              String userpassword,
//                              HttpServletResponse response) {
//        if(loginService.authenticateUser(username, userpassword)) {
//            User user = userRepository.findUserByUserName(username);
//            response.addCookie(new Cookie("userCookie", user.getId().toString()));
//            return "redirect:/user_page/"+user.getId();
//        }
//        else{
//            return "redirect:/signup";
//        }
//    }
}
