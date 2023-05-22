package com.withtoowithtwo.demo.domain;

import com.withtoowithtwo.demo.domain.Enum.Gender;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Preference {
    @Id @GeneratedValue
    @Column(name = "prefer_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Gender gender; //성별 [MALE, FEMALE, HIDE]

    private int minAge;
    private int maxAge;
}
