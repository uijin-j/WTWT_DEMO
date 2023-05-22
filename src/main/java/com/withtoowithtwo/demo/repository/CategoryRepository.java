package com.withtoowithtwo.demo.repository;

import com.withtoowithtwo.demo.domain.Category;
import com.withtoowithtwo.demo.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
