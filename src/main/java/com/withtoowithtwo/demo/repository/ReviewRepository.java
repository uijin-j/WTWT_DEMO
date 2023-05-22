package com.withtoowithtwo.demo.repository;

import com.withtoowithtwo.demo.domain.Post;
import com.withtoowithtwo.demo.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
