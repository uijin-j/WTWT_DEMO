package com.withtoowithtwo.demo.repository;

import com.withtoowithtwo.demo.domain.GroupUser;
import com.withtoowithtwo.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupUserRepository extends JpaRepository<GroupUser, Long> {
}
