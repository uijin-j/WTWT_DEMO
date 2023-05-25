package com.withtoowithtwo.demo.service;

import com.withtoowithtwo.demo.domain.Post;
import com.withtoowithtwo.demo.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    /**
     * 게시물 생성
     */
    @Transactional //기본은 readOnly = false
    public Long savePost(Post post) {
        return postRepository.save(post).getId();
    }

    /**
     * 게시물 조회
     */
    List<Post> findPosts() {
        return postRepository.findAll();
    }
}
