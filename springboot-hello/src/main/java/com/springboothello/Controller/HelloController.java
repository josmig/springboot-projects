package com.springboothello.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloController {

	@GetMapping
	public ResponseEntity<String> helloWorld(){
		return new ResponseEntity<>("Hello World", HttpStatus.OK);
	}
	
}
