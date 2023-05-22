package com.withtoowithtwo.demo.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Profile {
    @Id @GeneratedValue
    @Column(name = "profile_id")
    private Long id;

    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY)
    private User user;

//    @Embedded
//    private Image image;
    private String statusMessage; // 한줄 소개

    public Profile() {}

    public Profile(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
