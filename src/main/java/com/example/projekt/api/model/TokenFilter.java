package com.example.projekt.api.model;

import com.example.projekt.service.UserService;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Component
public class TokenFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(TokenFilter.class);
    private static final String AUTH_TOKEN = "Authorization";

    private final UserService userService;

    @Autowired
    public TokenFilter(UserService userService) {
        this.userService = userService;
        logger.debug("TokenFilter initialized with UserService.");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("TokenFilter initialized.");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        final String val = request.getHeader(AUTH_TOKEN);

        logger.debug("Received request with Authorization header: {}", val);

        if (val == null || userService == null || !userService.isTokenValid(val)) {
            logger.warn("Invalid token or UserService: token={}, userService={}", val, userService);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            logger.debug("Token is valid, proceeding with the request.");
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
        logger.info("TokenFilter destroyed.");
    }
}
