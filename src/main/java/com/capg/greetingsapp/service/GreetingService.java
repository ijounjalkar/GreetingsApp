package com.capg.greetingsapp.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.greetingsapp.model.Greeting;
import com.capg.greetingsapp.model.User;
import com.capg.greetingsapp.repository.GreetingRepository;
@Service
public class GreetingService implements IGreetingInterface{
	private static String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	@Autowired
	private GreetingRepository greetingRepository;

	@Override
	public Greeting addGreeting(User user) {
		String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
		return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
	}

	@Override
	public Greeting getGreetingById(long id) {
		return greetingRepository.findById(id).get();
	}

	@Override
	public List<Greeting> getAll() {
		return greetingRepository.findAll();
	}

	@Override
	public Greeting updateGreeting(long id, User user) {
		String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
		return greetingRepository.save(new Greeting(id, message));
	}

	@Override
	public List<Greeting> deleteGreeting(long id) {
		greetingRepository.deleteById(id);
		return getAll();
	}

}
