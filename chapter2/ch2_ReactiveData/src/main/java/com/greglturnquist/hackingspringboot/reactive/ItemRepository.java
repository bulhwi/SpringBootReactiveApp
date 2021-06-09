package com.greglturnquist.hackingspringboot.reactive;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ItemRepository extends ReactiveCrudRepository<Item, String> {
    // 입력한 검색어가 이름에 포함된 상품을 반환하는 메서드
    Flux<Item> findByNameContaining(String partialName);

//    @Query("{'name' : ?0, 'age' : ?1}")
//    Flux<Item> findItemsForCustomerMonthlyReport(String name, int age);
//
//    @Query(sort = "{'age' : -1}")
//    Flux<Item> findSortedStuffForWeeklyReport();
}
