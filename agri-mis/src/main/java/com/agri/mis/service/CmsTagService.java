package com.agri.mis.service;

import com.agri.mis.domain.CmsTag;
import com.agri.mis.repository.CmsTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CmsTagService {

    @Autowired
    private CmsTagRepository cmsTagRepository;


    public Mono<CmsTag> findById(Long id) {
      return cmsTagRepository.findById(id);
    }

    public Flux<CmsTag> findAll() {
        return cmsTagRepository.findAll();
    }

    public Mono<CmsTag> add(CmsTag cmsTag) {
        return cmsTagRepository.save(cmsTag);
    }

    public Mono<CmsTag> update(Long id, CmsTag cmsTag) {
        return cmsTagRepository.findById(id)
                .flatMap(s -> {
                    cmsTag.setId(s.getId());
                    return cmsTagRepository.save(cmsTag);
                });
    }

    public Mono<Void> delete(CmsTag cmsTag) {
        return cmsTagRepository.delete(cmsTag);
    }


}
