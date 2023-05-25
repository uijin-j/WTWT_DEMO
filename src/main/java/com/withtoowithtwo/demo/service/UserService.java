package com.withtoowithtwo.demo.service;

import com.withtoowithtwo.demo.domain.User;
import com.withtoowithtwo.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    /**
     * 회원 가입
     */
    @Transactional //기본은 readOnly = false
    public Long join(User user) {
        validateDuplicateUser(user); //중복 회원 검증
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateUser(User user) {
        User findUser1 = userRepository.findByEmail(user.getEmail());
        if(findUser1 != null) throw new IllegalStateException("이미 존재하는 이메일입니다.");

        User findUser2 = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if(findUser2 != null) throw new IllegalStateException("이미 존재하는 휴대폰 번호입니다.");
    }

    /**
     * 로그인
     */
    public Long login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if(user == null) throw new IllegalStateException("존재하지 않는 이메일 입니다.");

        if(user.getPassword().equals(password)) return user.getId();
        else throw new IllegalStateException("잘못된 비밀번호 입니다.");
    }

    /**
     * 회원 조회
     */
    public User findOne(Long userId) {
        return userRepository.findById(userId).get();
    }
}
