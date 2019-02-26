package basePackage.controllers;

import basePackage.models.User;
import basePackage.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DisplayUsersController {
    @Autowired
    UsersRepository usersRepository;

    @PostMapping(path = "/display_users")
    public @ResponseBody
    String displayUser(@RequestParam(value = "searchId", required = true) String searchName, HttpServletRequest request) {
        User user = usersRepository.findOneByUserName(searchName).orElseThrow(IllegalArgumentException::new);
        String userInfo = "First Name: " + user.getName() + ", Last Name: " + user.getLastName() + ", User Page: " + request.getServletPath() + "user_page/" + user.getId();
        return userInfo;
    }

    @GetMapping(path = "/display_users")
    public String display() {
        return "display_users";
    }
}
