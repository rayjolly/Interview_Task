package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.entities.Robot;

public interface RobotRepository extends JpaRepository<Robot, Long> {

}
