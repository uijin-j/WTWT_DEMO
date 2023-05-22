package com.withtoowithtwo.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDate firstDay;
    private LocalDate lastDay;
    private int headCount; //동행 인원

    private LocalDateTime postDate; //게시물 작성 시간
    private int hits; // 조회수
}
