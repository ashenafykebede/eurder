package com.switchfully.selfeval.eurder.service.security;

import com.switchfully.selfeval.eurder.domain.user.User;
import com.switchfully.selfeval.eurder.domain.user.UserRepository;
import com.switchfully.selfeval.eurder.service.security.exceptions.UnauthorizedException;
import com.switchfully.selfeval.eurder.service.security.exceptions.WrongPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class SecurityService {
    private UserRepository userRepository;

    @Autowired
    public SecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public int validateAuthorization(String authorization, Feature feature){
        Credential decodedAuthorization = decodeAuth(authorization);
        User user = userRepository.getUserByEmail(decodedAuthorization.getEmail());

        if (!user.doesPasswordMatch(decodedAuthorization.getPassword())){
            throw new WrongPasswordException("Incorrect password");
        }
        if (!user.canHaveAccessTo(feature)){
            throw new UnauthorizedException("not enough access level. Permisson denied.");
        }
        return user.getUserID();
    }

    private Credential decodeAuth(String authorization) {
        String decodedAuthorization = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String email = decodedAuthorization.substring(0,decodedAuthorization.indexOf(":"));
        String password = decodedAuthorization.substring(decodedAuthorization.indexOf(":")+1);
        return new Credential(email,password);
    }
}
