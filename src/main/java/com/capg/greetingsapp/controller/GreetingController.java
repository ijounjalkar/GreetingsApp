package com.capg.greetingsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.greetingsapp.model.Greeting;
import com.capg.greetingsapp.model.User;
import com.capg.greetingsapp.service.IGreetingInterface;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	@Autowired
	private IGreetingInterface greetingService;

	@GetMapping(value = { "", "/", "/home" })
	public Greeting greeting(@RequestParam(value = "fname", defaultValue = "World") String fname,
			@RequestParam(value = "lname", defaultValue = "World") String lname) {
		User user = new User();
		user.setFirstName(fname);
		user.setLastName(lname);
		return greetingService.addGreeting(user);
	}

	@GetMapping("/id")
	public Greeting getId(@RequestParam(value = "id") long id) {
		return greetingService.getGreetingById(id);
	}

	@GetMapping("/getall")
	public List<Greeting> getAll() {
		return greetingService.getAll();
	}

	@PutMapping("/update")
	public Greeting updateGreeting(@RequestParam(value = "id") long id,
			@RequestParam(value = "fname", defaultValue = "World") String fname,
			@RequestParam(value = "lname", defaultValue = "World") String lname) {
		User user = new User();
		user.setFirstName(fname);
		user.setLastName(lname);
		return greetingService.updateGreeting(id, user);
	}

	@DeleteMapping("/delete/{id}")
	public List<Greeting> deleteGreeting(@RequestParam(value = "id") long id) {
		return greetingService.deleteGreeting(id);
	}
}
