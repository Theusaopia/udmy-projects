package com.udemy.webservicecourse.config;

import com.udemy.webservicecourse.entities.User;
import com.udemy.webservicecourse.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    private final UserRepository userRepository;

    public TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Matheus Dias", "matheus@email.com", "999631025", "corinthians");
        User u2 = new User(null, "Cassio Ramos", "casio@email.com", "995631475", "goleiro_casio");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
