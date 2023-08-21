package com.agri.mis.service;

import com.agri.mis.domain.Category;
import com.agri.mis.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public Mono<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }


    public Mono<Category> add(Category category) {
        return categoryRepository.save(category);
    }

    public Mono<Category> update(Long id, Category category) {
        return categoryRepository.findById(id)
                .flatMap(s -> {
                    category.setId(s.getId());
                    return categoryRepository.save(category);
                });
    }

    public Mono<Void> delete(Category category) {
        return categoryRepository.delete(category);
    }

    public Flux<Category> findAllByCorpId(Long corpId) {
        return categoryRepository.findAllByCorpIdOrderByPathName(corpId);
    }

}