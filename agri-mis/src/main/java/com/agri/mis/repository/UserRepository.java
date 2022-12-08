package com.agri.mis.repository;

import com.agri.mis.domain.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Long>, ReactiveQueryByExampleExecutor<User> {
     Mono<User> findByMobile(String mobile);

     Mono<User> findByUsername(String username);

     Flux<User> findAllBy(Example user, Pageable pageable);
}
