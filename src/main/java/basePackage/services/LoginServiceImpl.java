package basePackage.services;

import basePackage.models.User;
import basePackage.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean authenticateUser(String userName, String userPassword) {
        User user = usersRepository.findOneByUserName(userName).orElseThrow(IllegalArgumentException::new);
        if (user == null)
            return false;
        else
            return passwordEncoder.matches(userPassword, user.getUserPassword());
    }
}
