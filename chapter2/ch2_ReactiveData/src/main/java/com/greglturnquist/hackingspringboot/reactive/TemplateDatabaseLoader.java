package com.greglturnquist.hackingspringboot.reactive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component
public class TemplateDatabaseLoader {
    @Bean
    CommandLineRunner initialize(MongoOperations mongo) {
        return args -> {
            mongo.save(new Item("Alf alarm clock", 19.99, "this is sample1"));
            mongo.save(new Item("Smurf TV tray", 24.99, "this is sample1"));
            mongo.save(new Item("sample item-1", 80, "this is sample2"));
            mongo.save(new Item("sample item-2", 70.1, "this is sample3"));
        };
    }
}
