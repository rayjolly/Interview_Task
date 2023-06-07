package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.task.entities.Robot;
import com.task.repository.RobotRepository;
import com.task.service.RobotService;
import java.util.List;

@RestController
@RequestMapping("/testRobot")
public class RobotController {

	@Autowired
	private RobotRepository robotRepository;
	@Autowired
	private RobotService robotService;

	// localhost:8080/robots
	@PostMapping("/robots")
	public ResponseEntity<String> saveRobotsDetails(@RequestBody List<Robot> robots) {
		List<Robot> savedRobots = robotRepository.saveAll(robots);

		if (!savedRobots.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body("Robot details inserted successfully");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert data");
		}
	}

	// localhost:8080/testRobot/robotDetails
	@GetMapping("/robotDetails")
	public ResponseEntity<List<Robot>> getAllRobot() {
		List<Robot> robot = robotService.getAllRobot();
		return new ResponseEntity<>(robot, HttpStatus.OK);
	}
}
