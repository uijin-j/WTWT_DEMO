package com.withtoowithtwo.demo.domain;

import com.withtoowithtwo.demo.domain.Enum.Gender;
import jakarta.persistence.*;
import lombok.Getter;

@Embeddable
@Getter
public class Preference {
    @Enumerated(EnumType.STRING)
    private Gender gender; //성별 [MALE, FEMALE, HIDE]

    private int minAge;
    private int maxAge;

    public Preference(Gender gender, int minAge, int maxAge) {
        this.gender = gender;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    protected Preference() {}
}
