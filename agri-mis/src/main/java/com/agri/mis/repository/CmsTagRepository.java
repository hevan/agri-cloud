package com.agri.mis.repository;


import com.agri.mis.domain.CmsTag;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface CmsTagRepository extends ReactiveCrudRepository<CmsTag, Long>, ReactiveQueryByExampleExecutor<CmsTag> {
 
}
