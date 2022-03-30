package com.example.jwttoken.component;

import com.example.jwttoken.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Dataloader implements CommandLineRunner {
    @Value("${spring.sql.init.mode}")
    private String mode; //always

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl; //create

    final UserRepository userRepository;
    final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {


    }
}
