package com.agri.mis.service;

import com.agri.mis.domain.CmsUserActive;
import com.agri.mis.repository.CmsUserActiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CmsUserActiveService {

    @Autowired
    private CmsUserActiveRepository cmsUserActiveRepository;


    public Mono<CmsUserActive> findById(Long id) {
      return cmsUserActiveRepository.findById(id);
    }

    public Flux<CmsUserActive> findAll() {
        return cmsUserActiveRepository.findAll();
    }

    public Mono<CmsUserActive> add(CmsUserActive cmsUserActive) {
        return cmsUserActiveRepository.save(cmsUserActive);
    }

    public Mono<CmsUserActive> update(Long id, CmsUserActive cmsUserActive) {
        return cmsUserActiveRepository.findById(id)
                .flatMap(s -> {
                    cmsUserActive.setId(s.getId());
                    return cmsUserActiveRepository.save(cmsUserActive);
                });
    }

    public Mono<Void> delete(CmsUserActive cmsUserActive) {
        return cmsUserActiveRepository.delete(cmsUserActive);
    }


}
