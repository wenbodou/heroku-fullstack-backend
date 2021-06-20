package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import demo.model.TestTable;
import demo.service.TestService;

@CrossOrigin("*")
@Controller
public class HelloWorldController {
	@Autowired
	TestService testService;
	
	@GetMapping("/testGet")
	public ResponseEntity<Object> testGet() {
		return new ResponseEntity<>(testService.list(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/testPost")
	public ResponseEntity<Object> testPost(@RequestBody TestTable testTable) {
		testService.insert(testTable);
		return new ResponseEntity<>("Inserted successfully", HttpStatus.ACCEPTED);
	}
}
