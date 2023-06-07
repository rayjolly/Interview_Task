package com.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.entities.Robot;
import com.task.entities.User;
import com.task.repository.RobotRepository;

@Service
public class RobotServiceImpl implements RobotService {
     
	@Autowired
	private RobotRepository robotRepository;
	@Override
	public List<Robot> getAllRobot() {	
		return robotRepository.findAll();
	}
}
