package com.example.projekt.api.config;

import com.example.projekt.api.model.TokenFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    private final TokenFilter tokenFilter;

    private static final Logger logger = LoggerFactory.getLogger(FilterConfig.class);
    @Autowired
    public FilterConfig(TokenFilter tokenFilter) {
        this.tokenFilter = tokenFilter;
        logger.debug("TokenFilter bean injected into FilterConfig.");
    }
    @Bean
    public FilterRegistrationBean<TokenFilter> fooTokenFilter(TokenFilter tokenFilter) {
        logger.info("Registering TokenFilter with URL patterns '/*'");
        FilterRegistrationBean<TokenFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(tokenFilter);
        registrationBean.addUrlPatterns("/*");
        logger.info("TokenFilter registered successfully.");
        return registrationBean;
    }
}


