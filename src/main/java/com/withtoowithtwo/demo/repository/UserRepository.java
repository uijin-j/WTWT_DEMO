package com.withtoowithtwo.demo.repository;

import com.withtoowithtwo.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findByPhoneNumber(String number);
}
