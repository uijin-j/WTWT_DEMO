package com.withtoowithtwo.demo.repository.post;

import com.withtoowithtwo.demo.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
