package com.agri.mis.repository;


import com.agri.mis.domain.CmsTag;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface CmsTagRepository extends ReactiveCrudRepository<CmsTag, Long>, ReactiveQueryByExampleExecutor<CmsTag> {

    Flux<CmsTag> findAllByCorpId(Long corpId);
}
