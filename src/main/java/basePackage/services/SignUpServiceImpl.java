package basePackage.services;

import basePackage.models.Role;
import basePackage.models.State;
import basePackage.models.User;
import basePackage.models.UserPage;
import basePackage.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override

    public boolean isSignedUp(String userName, String userPassword, String name, String lastName) {
        if (name.matches("[^A-Za-z]+")
                | lastName.matches("[^A-Za-z]+")
                | userName.isEmpty()
                | userPassword.isEmpty()
                | name.isEmpty()
                | lastName.isEmpty()
                | usersRepository.findOneByUserName(userName).isPresent())
            return false;
        else {
            User user = User.builder()
                    .userName(userName)
                    .userPassword(passwordEncoder.encode(userPassword))
                    .lastName(lastName)
                    .name(name)
                    .role(Role.USER)
                    .state(State.ACTIVE)
                    .build();
            user.setUserPage(UserPage.builder().user(user).build());
            usersRepository.save(user);
            return true;
        }
    }
}
