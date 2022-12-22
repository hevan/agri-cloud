package com.agri.mis.service;

import com.agri.mis.domain.Corp;
import com.agri.mis.domain.MarkCategory;
import com.agri.mis.repository.MarkCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

//业务层
@Service
public class MarkCategoryService {

    @Autowired
    private MarkCategoryRepository markCategoryRepository;//数据操作层


    public Mono<MarkCategory> findById(Long id) {
        return markCategoryRepository.findById(id);
    }


    public Mono<MarkCategory> add(MarkCategory markCategory){
        return markCategoryRepository.save(markCategory);
    }

    public Mono<MarkCategory> update(Long id,MarkCategory markCategory){
        return markCategoryRepository.findById(id).flatMap(
                s ->{
                    markCategory.setId(s.getId());
                    return markCategoryRepository.save(markCategory);
                });
    }

    public Mono<Void> delete(MarkCategory markCategory){
        return markCategoryRepository.delete(markCategory);
    }

    public Mono<Page<MarkCategory>> pageQuery(String name,PageRequest pageRequest){
        MarkCategory markCategory = new MarkCategory();
        markCategory.setName(name);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("name",ExampleMatcher.GenericPropertyMatchers.contains());
        return  this.markCategoryRepository.findBy(Example.of(markCategory,exampleMatcher),pageRequest)
                .collectList()
                .zipWith(this.markCategoryRepository.count(Example.of(markCategory,exampleMatcher)))
                .map(t -> new PageImpl<>(t.getT1(),pageRequest,t.getT2()));
    }

}
