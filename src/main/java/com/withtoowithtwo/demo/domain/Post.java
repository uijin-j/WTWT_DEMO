package com.withtoowithtwo.demo.domain;

import com.withtoowithtwo.demo.domain.Enum.PostStatus;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Post {
    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id") //FK
    private Category category;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id") //FK, 연관 관계 주인
    private TripGroup group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User writer;

    private String title;
    private String content;
    private int headCount; //선호 동행 인원
    @Embedded
    private Preference preference; //선호 동행인
    private LocalDateTime postDate; //게시물 작성 시간
    private int hits; // 조회수

    @Enumerated(EnumType.STRING)
    private PostStatus status; // 게시물 상태 [OPEN, CLOSE]

    public Post(Category category, TripGroup group, User writer, String title, String content,
                int headCount, Preference preference) {
        this.category = category;
        this.group = group;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.headCount = headCount;
        this.preference = preference;

        postDate = LocalDateTime.now();
        status = PostStatus.OPEN;
        hits = 0;
    }

    protected Post() {}
}
