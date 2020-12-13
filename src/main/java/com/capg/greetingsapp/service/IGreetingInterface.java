package com.capg.greetingsapp.service;

import java.util.List;

import com.capg.greetingsapp.model.Greeting;
import com.capg.greetingsapp.model.User;

public interface IGreetingInterface {
	Greeting addGreeting(User user);

	Greeting getGreetingById(long id);

	List<Greeting> getAll();
	
	Greeting updateGreeting(long id, User user);
	
	List<Greeting> deleteGreeting(long id);
}
