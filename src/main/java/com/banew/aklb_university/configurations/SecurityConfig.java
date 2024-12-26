package com.banew.aklb_university.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.banew.aklb_university.repositories.UserRepository;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            var users = userRepository.getByNickname(username);
            if (users.size() != 0)
                return users.get(0);
            throw new UsernameNotFoundException("Користувача " + username + " не існує!");
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login/**","/register/**").permitAll()
                .requestMatchers(HttpMethod.POST,"/register/**").permitAll()
                .requestMatchers("/img/**","/css/**","js/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .usernameParameter("name")
                .passwordParameter("password")
                .failureUrl("/login?error=true")
            )
            .csrf(csrf -> csrf
                .disable()
            )
            .build();
    }
}
