package com.withtoowithtwo.demo.repository;

import com.withtoowithtwo.demo.domain.Profile;
import com.withtoowithtwo.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
