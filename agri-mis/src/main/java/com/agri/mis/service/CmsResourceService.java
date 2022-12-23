package com.agri.mis.service;

import com.agri.mis.domain.CmsResource;
import com.agri.mis.repository.CmsResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CmsResourceService {

    @Autowired
    private CmsResourceRepository cmsResourceRepository;


    public Mono<CmsResource> findById(Long id) {
      return cmsResourceRepository.findById(id);
    }

    public Flux<CmsResource> findAllByBlogId(Long blogId) {
        return cmsResourceRepository.findAllByBlogId(blogId);
    }


    public Mono<CmsResource> add(CmsResource cmsResource) {
        return cmsResourceRepository.save(cmsResource);
    }

    public Mono<CmsResource> update(Long id, CmsResource cmsResource) {
        return cmsResourceRepository.findById(id)
                .flatMap(s -> {
                    cmsResource.setId(s.getId());
                    return cmsResourceRepository.save(cmsResource);
                });
    }

    public Mono<Void> delete(CmsResource cmsResource) {
        return cmsResourceRepository.delete(cmsResource);
    }


}
