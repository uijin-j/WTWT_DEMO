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
        User findMember1 = userRepository.findByEmail(user.getEmail());
        if(findMember1 != null) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }

        User findMember2 = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if(findMember2 != null) {
            throw new IllegalStateException("이미 존재하는 휴대폰 번호입니다.");
        }
    }

    /**
     * 회원 조회
     */
    public User findOne(Long userId) {
        return userRepository.findById(userId).get();
    }
}
