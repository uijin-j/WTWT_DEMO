package com.withtoowithtwo.demo;

import com.withtoowithtwo.demo.domain.Category;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *  카테고리 생성
 *  [프랑스, 영국, 스페인, 이탈리아, 독일...]
 */
@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.initCategories();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;
        public void initCategories() {
            createCategories("프랑스", "영국", "스페인", "이탈리아", "독일");
        }

        private void createCategories(String... categories) {
            for (String category : categories) em.persist(new Category(category));
        }
    }
}
