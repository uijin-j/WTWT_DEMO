package com.withtoowithtwo.demo.domain;

import com.withtoowithtwo.demo.domain.Enum.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@Getter
public class User { // User는 h2의 예약어
    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToMany(mappedBy = "writer", cascade = CascadeType.ALL)
    private List<Post> posts;

    @NotEmpty
    private String name;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Gender gender; //성별 [MALE, FEMALE, HIDE]

    @Embedded
    private Birthday birthday;

    private int age; //birthday로 계산하기!
    private Float rate; //별점 평균

    public User() {}

    public User(String name, String phoneNumber, String email, String password, String nickname) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.nickname = nickname;

        setAge(birthday.getBYear());
        this.rate = 0f;
    }

    public User(Profile profile, String name, String phoneNumber, String email, String password, String nickname, Gender gender, Birthday birthday) {
        this.profile = profile;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
        this.birthday = birthday;

        setAge(birthday.getBYear());
        this.rate = 0f;
    }

    public void setAge(String BYear) {
        System.out.println("Byear = " + getBirthday().getBYear());
        if(BYear == null) return;
        this.age = Integer.parseInt(BYear) - LocalDate.now().getYear();
    }
}
