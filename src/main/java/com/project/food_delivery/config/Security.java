package com.project.food_delivery.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class Security {
    private final JwtRequestFilter jwtRequestFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers( "/auth/**")
                        .permitAll()
                        .requestMatchers(HttpMethod.GET, "/place-categories", "/places/**", "/products",
                                "/product-categories").permitAll()
                        .requestMatchers("/products/save-in-memory", "/products/get-all-from-memory",
                                "/products/get-product-from-memory", "/products/delete-from-memory",
                                "/products/increase-product-amount", "/products/decrease-product-amount")
                        .hasAuthority("USER")
                        .requestMatchers(HttpMethod.GET, "/orders/{username}").hasAuthority("USER")
                        .requestMatchers(HttpMethod.POST, "/orders/{username}/{payment}").hasAuthority("USER")
                        .requestMatchers("/users/**").hasAuthority("USER")
                        .requestMatchers(HttpMethod.POST, "/place-categories/{place-category}",
                                "/product-categories").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/places", "/products").hasAuthority("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/orders/{order-id}").hasAuthority("MANAGER")
                        .anyRequest()
                        .authenticated()
                )
                .logout(logout -> logout
                        .deleteCookies("JSESSIONID")
                )
                .sessionManagement(sessionManagement -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
