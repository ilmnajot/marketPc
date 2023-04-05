package uz.marketpc.marketpc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http)  throws Exception{
        http
                .csrf().disable()
                .authorizeHttpRequests()
//                .requestMatchers(HttpMethod.DELETE, "/api/product/*").hasAuthority("DELETE_PRODUCT")
//                .requestMatchers(HttpMethod.PUT, "/api/product/*").hasAuthority("UPDATE_PRODUCT")
//                .requestMatchers("/api/product/**").hasAnyAuthority("READ_ALL_PRODUCT","CREATE_PRODUCT","READ_ONE_PRODUCT","DELETE_PRODUCT","UPDATE_PRODUCT")
//                .requestMatchers("/api/orders/**").hasAnyAuthority("READ_ALL_PRODUCT","CREATE_PRODUCT","READ_ONE_PRODUCT","DELETE_PRODUCT","UPDATE_PRODUCT")
//                .requestMatchers("/api/category/**").hasAnyAuthority("READ_ALL_PRODUCT","CREATE_PRODUCT","READ_ONE_PRODUCT","DELETE_PRODUCT","UPDATE_PRODUCT")
//                .requestMatchers("/api/blogs/**").hasAnyAuthority("READ_ALL_PRODUCT","CREATE_PRODUCT","READ_ONE_PRODUCT","DELETE_PRODUCT","UPDATE_PRODUCT")
//                .requestMatchers("/api/attachments/**").hasAnyAuthority("READ_ALL_PRODUCT","CREATE_PRODUCT","READ_ONE_PRODUCT","DELETE_PRODUCT","UPDATE_PRODUCT")
//                .requestMatchers("/api/AttachContent/**").hasAnyAuthority("READ_ALL_PRODUCT","CREATE_PRODUCT","READ_ONE_PRODUCT","DELETE_PRODUCT","UPDATE_PRODUCT")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return http.build();
    }
    @Bean
    public UserDetailsService users(){
        UserDetails superAdmin = User.builder()
                .username("superAdmin")
                .password(passwordEncoder().encode("superAdmin")).roles("SUPER_ADMIN").authorities("READ_ALL","CREATE","READ_ONE","DELETE","UPDATE")
                .build();
        UserDetails moderator = User.builder()
                .username("moderator")
                .password(passwordEncoder().encode("moderator")).roles("MODERATOR").authorities("READ_ALL","CREATE","READ_ONE","UPDATE")

                .build();
        UserDetails operator = User.builder()
                .username("operator")
                .password(passwordEncoder().encode("operator")) .roles("OPERATOR").authorities("READ_ALL","CREATE","READ_ONE")

                .build();
        return new InMemoryUserDetailsManager(superAdmin,moderator, operator);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
