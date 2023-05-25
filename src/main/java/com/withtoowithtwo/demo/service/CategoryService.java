package com.withtoowithtwo.demo.service;

import com.withtoowithtwo.demo.domain.Category;
import com.withtoowithtwo.demo.domain.Post;
import com.withtoowithtwo.demo.domain.User;
import com.withtoowithtwo.demo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * 카테고리 생성
     */
    @Transactional //기본은 readOnly = false
    public Long saveCategory(String name) {
        validateDuplicateCategory(name);
        return categoryRepository.save(new Category(name)).getId();
    }

    private void validateDuplicateCategory(String name) {
        Category result = categoryRepository.findByName(name);
        if(result != null) throw new IllegalStateException("이미 존재하는 카테고리입니다.");
    }

    /**
     * 카테고리 조회
     */
    public Category findOne(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    public Category findOneByName(String name) { return categoryRepository.findByName(name); }
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


    /**
     * 카테고리 수정
     */


    /**
     * 카테고리 삭제
     */


}
