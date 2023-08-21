package com.agri.mis.repository;


import com.agri.mis.domain.CmsUserActive;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface CmsUserActiveRepository extends ReactiveCrudRepository<CmsUserActive, Long>, ReactiveQueryByExampleExecutor<CmsUserActive> {
 
}
