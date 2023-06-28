package com.spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppSecurityConfig {

    /* Basic Security configuration */
   /* @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
       http.authorizeHttpRequests()
               .requestMatchers("/account","/cards","/balance","/loans").authenticated()
               .requestMatchers("/contact","/notice").permitAll()
               .and()
               .formLogin()
               .and().httpBasic();
        return http.build();

    }*/

    // In Memory User detail manager
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails adminUser = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("12345")
                .authorities("admin")
                .build();

        UserDetails normalUser = User.withDefaultPasswordEncoder()
                .username("testuser")
                .password("12345")
                .authorities("readonly")
                .build();
        return new InMemoryUserDetailsManager(adminUser,normalUser);
    }
}
