package com.agri.mis.service;

import com.agri.mis.domain.Address;
import com.agri.mis.domain.BatchBase;
import com.agri.mis.domain.Corp;
import com.agri.mis.repository.BatchBaseRepository;
import lombok.val;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BatchBaseService {

    @Autowired
    private BatchBaseRepository repository;

    @Autowired
    private DSLContext dslContext;

    public Mono<BatchBase> findById(Long id){
        return repository.findById(id);
    }

    public Mono<BatchBase> add(BatchBase batchBase) {
        return repository.save(batchBase);
    }

    public Mono<BatchBase> update(Long id, BatchBase batchBase) {
      return repository.findById(id).flatMap(
              r ->{
                  batchBase.setBatchId(r.getId());
                  return repository.save(batchBase);
              }
      );
    }

    public Mono<Void> delete(BatchBase batchBase) {
        return  repository.delete(batchBase);
    }



}
