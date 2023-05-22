package com.withtoowithtwo.demo.service;

import com.withtoowithtwo.demo.domain.User;
import org.junit.Test; // Junit 4!
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) // junit 실행할 때 spring과 엮어서 실행하려면! <- Junit5를 사용하면 이걸 지워야함!
@SpringBootTest
@Transactional
public class UserServiceTest {
    @Autowired UserService userService;

    @Test
    public void 회원가입() throws Exception {
        //given
        User user = new User("정의진","010-3066-2820", "2pm0531@naver.com", "password", "nick");

        //when
        Long savedId = userService.join(user);

        //then
        assertEquals(user, userService.findOne(savedId));
    }

    @org.junit.Test(expected = IllegalStateException.class) // Junit4
    public void 이메일_중복_회원_가입() throws Exception {
        //given
        User user1 = new User("정의진","010-3066-2820", "2pm0531@naver.com", "password", "nick");
        User user2 = new User("정의진","010-9966-2820", "2pm0531@naver.com", "password", "nick");

        //when
        userService.join(user1);
        userService.join(user2); //예외가 발생해야 함!

        //then
        fail("예외가 발생해야 한다.");
    }

    @org.junit.Test(expected = IllegalStateException.class) // Junit4
    public void 전화번호_중복_회원_가입() throws Exception {
        //given
        User user1 = new User("정의진","010-3066-2820", "2pm0531@naver.com", "password", "nick");
        User user2 = new User("정의진","010-3066-2820", "juj0531@naver.com", "password", "nick");

        //when
        userService.join(user1);
        userService.join(user2); //예외가 발생해야 함!

        //then
        fail("예외가 발생해야 한다.");
    }
}
