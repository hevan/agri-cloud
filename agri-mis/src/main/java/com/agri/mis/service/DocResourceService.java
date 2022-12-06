package com.agri.mis.service;

import com.agri.mis.domain.DocResource;
import com.agri.mis.repository.DocResourceRepository;
import com.agri.mis.repository.DocResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DocResourceService {

    @Autowired
    private DocResourceRepository docResourceRepository;

    public Mono<DocResource> findById(Long id) {
      return docResourceRepository.findById(id);
    }

    public Flux<DocResource> findAllByEntityIdAndEntityName(Long entityId, String entityName) {
        return docResourceRepository.findAllByEntityIdAndEntityName(entityId,entityName);
    }

    public Mono<DocResource> add(DocResource docResource) {
        return docResourceRepository.save(docResource);
    }

    public Mono<DocResource> update(Long id, DocResource docResource) {
        return docResourceRepository.findById(id)
                .flatMap(s -> {
                    docResource.setId(s.getId());
                    return docResourceRepository.save(docResource);
                });
    }

    public Mono<Void> delete(DocResource docResource) {
        return docResourceRepository.delete(docResource);
    }
}
