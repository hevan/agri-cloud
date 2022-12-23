package com.agri.mis.service;

import com.agri.mis.domain.CmsCategory;
import com.agri.mis.repository.CmsCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CmsCategoryService {

    @Autowired
    private CmsCategoryRepository cmsCategoryRepository;


    public Mono<CmsCategory> findById(Long id) {
      return cmsCategoryRepository.findById(id);
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

    public Mono<Page<CmsCategory>> pageQueryByExample(CmsCategory cmsCategory, PageRequest pageRequest){

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

        return this.cmsCategoryRepository.findBy(Example.of(cmsCategory, exampleObjectMatcher), pageRequest).collectList()
                .zipWith(this.cmsCategoryRepository.count(Example.of(cmsCategory, exampleObjectMatcher)))
                .map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));


    }
}
