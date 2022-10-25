package com.sahu.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahu.model.Actor;

@RestController
@RequestMapping("/actor")
public class ActorOperationsController {
	
	@GetMapping("/wish")
	public ResponseEntity<String> displayWishMessage() {
		return new ResponseEntity<String>("Good morning", HttpStatus.OK);
	}
	
	@GetMapping("/wish/{id}/{name}")
	public ResponseEntity<String> displayWishMessage(@PathVariable Integer id, @PathVariable String name) {
		return new ResponseEntity<String>("Good morning "+id+" "+name, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> regiserActor(@RequestBody Actor actor) {
		return new ResponseEntity<String>("Actor data "+actor.toString(), HttpStatus.OK);
	}
	
	@GetMapping("/find")
	public ResponseEntity<Actor> searhActor() {
		return new ResponseEntity<Actor>(new Actor(200, "Salaman", 56, "Hero"), HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Actor>> fetchAllAtors() {
		return new ResponseEntity<List<Actor>>(List.of(
				new Actor(101, "Salman", 55, "Hero"),
				new Actor(102, "Rajesh", 65, "ero"),
				new  Actor(103, "Raveen", 35, "Hero")), 
				HttpStatus.OK);
	}
	
}
