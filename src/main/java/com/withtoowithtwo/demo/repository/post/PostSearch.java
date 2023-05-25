package com.withtoowithtwo.demo.repository.post;

import com.withtoowithtwo.demo.domain.Category;
import com.withtoowithtwo.demo.domain.Preference;
import com.withtoowithtwo.demo.domain.Enum.OrderOption;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class PostSearch {
    private OrderOption option; //정렬 옵션 [RECENT, POPULAR, SOON]
    private Preference preference; //선호 동행인 Gender, minAge, maxAge
    private LocalDate date; //여행 날짜
    private Category category; // 카테고리
    private String keyword; // 키워드
}
