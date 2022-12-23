package com.agri.mis.service;

import com.agri.mis.domain.CmsResource;
import com.agri.mis.repository.CmsResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CmsResourceService {

    @Autowired
    private CmsResourceRepository cmsResourceRepository;


    public Mono<CmsResource> findById(Long id) {
      return cmsResourceRepository.findById(id);
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

    public Mono<Page<CmsResource>> pageQueryByExample(CmsResource cmsResource, PageRequest pageRequest){

        ExampleMatcher exampleObjectMatcher = ExampleMatcher.matching()
                .withMatcher("link_name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("link_mobile", ExampleMatcher.GenericPropertyMatchers.contains());

        /*
        List<Criteria> listWeres = new ArrayList<Criteria>();

        if(StringUtils.hasLength(nickName)){
            listWeres.add(where("nick_name").like("%" + nickName + "%"));
        }
        if(StringUtils.hasLength(nickName)){
            listWeres.add(where("mobile").like("%" + mobile + "%"));
        }
        Query queryA = null;
        if(listWeres.size() > 0){
            queryA = Query.query(Criteria.from(listWeres)).offset((pageRequest.getPageNumber() - 1) * pageRequest.getPageSize()).limit(pageRequest.getPageSize()) ;

        }else{
            queryA =  Query.empty().offset((pageRequest.getPageNumber() - 1) * pageRequest.getPageSize()).limit(pageRequest.getPageSize()) ;
        }

         */

        return this.cmsResourceRepository.findBy(Example.of(cmsResource, exampleObjectMatcher), pageRequest).collectList()
                .zipWith(this.cmsResourceRepository.count(Example.of(cmsResource, exampleObjectMatcher)))
                .map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));


    }
}
