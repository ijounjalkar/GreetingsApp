package com.capg.greetingsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.greetingsapp.model.Greeting;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {

}