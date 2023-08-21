package com.agri.mis.service;

import com.agri.mis.domain.CmsCategory;
import com.agri.mis.repository.CmsCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CmsCategoryService {

    @Autowired
    private CmsCategoryRepository cmsCategoryRepository;


    public Mono<CmsCategory> findById(Long id) {
      return cmsCategoryRepository.findById(id);
    }

    public Flux<CmsCategory> findAllByCorpId(Long corpId) {
        return cmsCategoryRepository.findAllByCorpId(corpId);
    }

    public Mono<CmsCategory> add(CmsCategory cmsCategory) {
        return cmsCategoryRepository.save(cmsCategory);
    }

    public Mono<CmsCategory> update(Long id, CmsCategory cmsCategory) {
        return cmsCategoryRepository.findById(id)
                .flatMap(s -> {
                    cmsCategory.setId(s.getId());
                    return cmsCategoryRepository.save(cmsCategory);
                });
    }

    public Mono<Void> delete(CmsCategory cmsCategory) {
        return cmsCategoryRepository.delete(cmsCategory);
    }


}
