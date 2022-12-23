package com.agri.mis.service;

import com.agri.mis.domain.CmsBlog;
import com.agri.mis.repository.CmsBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CmsBlogService {

    @Autowired
    private CmsBlogRepository cmsBlogRepository;


    public Mono<CmsBlog> findById(Long id) {
      return cmsBlogRepository.findById(id);
    }


    public Mono<CmsBlog> add(CmsBlog cmsBlog) {
        return cmsBlogRepository.save(cmsBlog);
    }

    public Mono<CmsBlog> update(Long id, CmsBlog cmsBlog) {
        return cmsBlogRepository.findById(id)
                .flatMap(s -> {
                    cmsBlog.setId(s.getId());
                    return cmsBlogRepository.save(cmsBlog);
                });
    }

    public Mono<Void> delete(CmsBlog cmsBlog) {
        return cmsBlogRepository.delete(cmsBlog);
    }

    public Mono<Page<CmsBlog>> pageQueryByExample(CmsBlog cmsBlog, PageRequest pageRequest){

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

        return this.cmsBlogRepository.findBy(Example.of(cmsBlog, exampleObjectMatcher), pageRequest).collectList()
                .zipWith(this.cmsBlogRepository.count(Example.of(cmsBlog, exampleObjectMatcher)))
                .map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));


    }
}
