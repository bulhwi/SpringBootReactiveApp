package com.greglturnquist.hackingspringboot.reactive;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveQueryByExampleExecutor<T> {
    <S extends T> Mono<S> findOne(Example<S> var1);

    <S extends T> Flux<S> findAll(Example<S> var1);

    <S extends T> Flux<S> findAll(Example<S> var1, Sort var2);

    <S extends T> Mono<Long> count(Example<S> var1);

    <S extends T> Mono<Boolean> exists(Example<S> var1);
}
