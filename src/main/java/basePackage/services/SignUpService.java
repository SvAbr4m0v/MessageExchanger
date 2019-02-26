package basePackage.services;

import org.springframework.stereotype.Service;

@Service
public interface SignUpService {
    boolean isSignedUp(String userName,
                       String userPassword,
                       String name,
                       String lastName);
}
