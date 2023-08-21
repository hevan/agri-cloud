package com.agri.mis.repository;


import com.agri.mis.domain.CmsCategory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface CmsCategoryRepository extends ReactiveCrudRepository<CmsCategory, Long>, ReactiveQueryByExampleExecutor<CmsCategory> {
  Flux<CmsCategory> findAllByCorpId(Long corpId);
}
