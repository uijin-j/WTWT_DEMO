package com.withtoowithtwo.demo.repository;

import com.withtoowithtwo.demo.domain.TripGroup;
import com.withtoowithtwo.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripGroupRepository extends JpaRepository<TripGroup, Long> {

}
