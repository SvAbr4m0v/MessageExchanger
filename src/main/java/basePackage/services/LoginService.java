package basePackage.services;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    boolean authenticateUser(String userName, String userPassword);
}
