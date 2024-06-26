package com.example.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author tada
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//                .cors(AbstractHttpConfigurer::disable)
//                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(formLogin -> formLogin
                // configure login
                .loginPage("/login")
                .usernameParameter("account")
                .passwordParameter("password")
                .defaultSuccessUrl("/", true)
                .permitAll()
        ).logout(logout -> logout
                // configure logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll()
                .invalidateHttpSession(true)
        ).authorizeHttpRequests(authorize -> authorize
                // configure URL authorization
                        .requestMatchers("/signup", "/signup/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/issues/").hasAuthority("readIssue")
                        .requestMatchers(HttpMethod.GET, "/issue/new").hasAuthority("writeIssue")
                        .requestMatchers(HttpMethod.POST, "/issues/").hasAuthority("writeIssue")
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers("/users").hasAuthority("manageUser")
                .anyRequest().authenticated()
        );
        return http.build();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
