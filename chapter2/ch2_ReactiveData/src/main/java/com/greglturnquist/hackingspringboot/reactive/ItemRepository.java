package com.greglturnquist.hackingspringboot.reactive;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ItemRepository extends ReactiveCrudRepository<Item, String>, ReactiveQueryByExampleExecutor<Item> {
    // 입력한 검색어가 이름에 포함된 상품을 반환하는 메서드
    Flux<Item> findByNameContaining(String partialName);

    // name 검색
    Flux<Item> findByNameContainingIgnoreCase(String partialName);

    // description 검색
    Flux<Item> findByDescriptionContainingIgnoreCase(String partialName);

    // name AND description 검색
    Flux<Item> findByNameContainingAndDescriptionContainingAllIgnoreCase(String partialName, String partialDesc);

    // name OR description 검색
    Flux<Item> findByNameContainingOrDescriptionContainingAllIgnoreCase(String partialName, String partialDesc);
}
