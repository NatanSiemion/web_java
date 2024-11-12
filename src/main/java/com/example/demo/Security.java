package com.example.demo;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class Security {

    @Autowired
    private final AppUserService appUserService;

    @Bean
    public UserDetailsService userDetailsService() {
        return appUserService;
    }

    @Bean
    public DaoAuthenticationProvider authenticationManager() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        return daoAuthenticationProvider;
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .formLogin(httpForm -> {
                    httpForm.loginPage("/logowanie").permitAll();
                })
                .authorizeHttpRequests(registry ->{
                    registry.requestMatchers("/rejestracja", "/logowanie", "/css/**", "/js/**").permitAll();
                    registry.anyRequest().authenticated();
                })
                .logout(logout -> logout.permitAll())
                .build();
    }
}
