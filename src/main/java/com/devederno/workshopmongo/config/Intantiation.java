package com.devederno.workshopmongo.config;

import com.devederno.workshopmongo.domain.User;
import com.devederno.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Intantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User eder = new User(null, "Eder N. Oliveira", "eder@gmail.com");
        User minoru = new User(null, "Minoru Gondon", "minoru@gmail.com");
        User khalleb = new User(null, "Khalleb Ribeiro", "maria@gmail.com");

        userRepository.saveAll((Arrays.asList(eder, minoru, khalleb)));
    }
}
