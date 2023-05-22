package com.withtoowithtwo.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class TripGroup {

    @Id @GeneratedValue
    @Column(name = "group_id")
    private Long id;

    @OneToOne(mappedBy = "group", cascade = CascadeType.ALL)
    private Post post; // 작성자 = 그룹리더 + 중복 데이터 제거를 위해

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<GroupUser> members = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "prefer_id")
    private Preference preference; //선호 동행인
}
