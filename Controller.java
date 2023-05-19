package com.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/user")
	public String usersStatus1() {
		return "welcome";
	}
	@PostMapping("/user")
	public String usersStatus2() {
		return "welcome";
	}
	@PutMapping("/user")
	public String usersStatus3() {
		return "welcome";
	}
	@DeleteMapping("/user")
	public String usersStatus() {
		return "welcome";
	}
	@GetMapping("/admin")
	public String usersStatus11() {
		return "welcome";
	}
	@PostMapping("/admin")
	public String usersStatus21() {
		return "welcome";
	}
	@PutMapping("/admin")
	public String usersStatus13() {
		return "welcome";
	}
	@DeleteMapping("/admin")
	public String usersStatus111() {
		return "welcome";
	}
}
