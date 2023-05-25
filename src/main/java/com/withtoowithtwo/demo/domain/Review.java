package com.withtoowithtwo.demo.domain;

import com.withtoowithtwo.demo.domain.Enum.Personality;
import com.withtoowithtwo.demo.domain.Enum.TripStyle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Review {
    @Id @GeneratedValue
    @Column(name = "review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private List<Personality> personality = new ArrayList<> ();

    @Enumerated(EnumType.STRING)
    private List<TripStyle> tripStyle = new ArrayList<> ();

    @NotEmpty
    private int rate; //별점은 0 - 5 (소숫점 X)
    private String comment;

}
