package com.learning.security.secConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class MyUserDetailsService {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("aniket")  // ✅ username
                .password(new BCryptPasswordEncoder().encode("password")) // ✅ password
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}

