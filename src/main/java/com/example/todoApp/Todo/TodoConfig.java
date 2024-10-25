package com.example.todoApp.Todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;
import static java.time.Month.MARCH;

@Configuration
public class TodoConfig {
    @Bean
    CommandLineRunner commandLineRunner(TodoRepository repository){
        System.out.println("test");
        return args ->{
            Todo t1  = new Todo(
                    "mike@mikemail.com",
                    true
            );
            Todo t2  = new Todo(
                    "Andrew@andymail.com",
                    false

            );
            repository.saveAll(
                    List.of(t1,t2)
            );
        };
    }
}
