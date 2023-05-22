package com.withtoowithtwo.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class GroupUser {
    @Id @GeneratedValue
    @Column(name = "group_user_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private TripGroup group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
