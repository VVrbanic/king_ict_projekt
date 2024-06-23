package com.example.projekt.service;
import com.example.projekt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    public List<String> getAllTokens() {
        List<String> tokens = userRepository.findAllTokens();
        logger.info("Retrieved tokens: {}", tokens);
        return tokens;
    }

    public boolean isTokenValid(String token) {
        List<String> tokens = getAllTokens();
        boolean doesContain = tokens.contains(token);
        logger.info("Token validation for '{}': {}", token, doesContain);
        return tokens.contains(token);
    }

}
