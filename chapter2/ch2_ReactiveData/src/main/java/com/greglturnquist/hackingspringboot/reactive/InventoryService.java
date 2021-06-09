package com.greglturnquist.hackingspringboot.reactive;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.ReactiveFluentMongoOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.stream.Collectors;

@Service
public class InventoryService {
    private ItemRepository repository;
    private ReactiveFluentMongoOperations fluentMongoOperations;

    public InventoryService(ItemRepository repository, ReactiveFluentMongoOperations fluentMongoOperations) {
        this.repository = repository;
        this.fluentMongoOperations = fluentMongoOperations;
    }

    Flux<Item> search(String partialName, String partialDescription, boolean useAnd) {
        if (partialName != null) {
            if (partialDescription != null) {
                if (useAnd) {
                    return repository //
                            .findByNameContainingAndDescriptionContainingAllIgnoreCase( //
                                    partialName, partialDescription);
                } else {
                    return repository.findByNameContainingOrDescriptionContainingAllIgnoreCase( //
                            partialName, partialDescription);
                }
            } else {
                return repository.findByNameContaining(partialName);
            }
        } else {
            if (partialDescription != null) {
                return repository.findByDescriptionContainingIgnoreCase(partialDescription);
            } else {
                return repository.findAll();
            }
        }
    }

    Flux<Item> searchByExample(String name, String description, boolean useAnd) {
        Item item = new Item(name, 0.0, description);
        ExampleMatcher matcher = (useAnd ? ExampleMatcher.matchingAll() : ExampleMatcher.matchingAny())
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase()
                .withIgnorePaths("price");

        Example<Item> probe = Example.of(item, matcher);
        System.out.println(repository.findAll(probe).collect(Collectors.toList()));
        return repository.findAll(probe);
    }
}
