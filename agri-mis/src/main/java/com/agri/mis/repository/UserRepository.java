package com.agri.mis.repository;

import com.agri.mis.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveSortingRepository<User, Long>, ReactiveCrudRepository<User, Long> {
     Mono<User> findByMobile(String mobile);
     Mono<User> findByUsername(String username);

     Flux<User> findAllByNickNameLike(String nickName, Pageable pageable);

     Mono<Long> countAllByNickNameLike(String nickName);

     Flux<User> findAllByMobileLike(String mobile, Pageable pageable);

     Mono<Long> countAllByMobileLike(String mobile);

     Flux<User> findAllBy(Pageable pageable);
}
