package com.withtoowithtwo.demo.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Birthday { // year, month, day는 데이터 베이스 예약어
    private String bYear;
    private String bMonth;
    private String bDay;

    public Birthday() {}

    public Birthday(String bYear, String bMonth, String bDay) {
        this.bYear = bYear;
        this.bMonth = bMonth;
        this.bDay = bDay;
    }
}
