package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        System.out.println("=== USER FOUND ===");
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password from DB: " + user.getPassword());
        System.out.println("Matches password: " + new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder()
                .matches("password", user.getPassword()));

        System.out.println("Matches admin123: " + new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder()
                .matches("admin123", user.getPassword()));
        System.out.println("Roles: " + user.getRoles());

        System.out.println(new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode("admin123"));
        System.out.println(new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode("user123"));
        System.out.println(new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode("student123"));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName()))
                        .toList()
        );
    }
}