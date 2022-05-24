package com.society.backend.configuration;

import com.society.backend.entity.User;
import com.society.backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class InitDatabase {

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            log.warn("Preloading users...");
            userRepository.save(new User("Kirill", "Rudnikov", "flainsky","kirillrudnikov811@gmail.com"));
            userRepository.save(new User("Olga", "Avdeeva", "olyasha98", "o.avdeeva@mail.ru"));
            userRepository.save(new User("Sasha", "Vorobyov", "san4ez_vor","sanya.vor97@gmail.com"));
            userRepository.save(new User("Anastasia", "Vinogradova", "nastya.vino","anas.vinogr4dova@yandex.ru"));
            userRepository.save(new User("Alexey", "Lex", "lex.alex","leha.2001lex@yahoo.com"));
        };
    }

}