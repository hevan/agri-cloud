package com.agri.mis.repository;


import com.agri.mis.domain.CmsResource;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface CmsResourceRepository extends ReactiveCrudRepository<CmsResource, Long>, ReactiveQueryByExampleExecutor<CmsResource> {
  Flux<CmsResource> findBy(Example cmsResource, Pageable pageable);
}
