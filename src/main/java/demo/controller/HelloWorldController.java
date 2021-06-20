package demo.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	private MultiValueMap<String,String> headers = new LinkedMultiValueMap<String,String>() {{
//		put("Access-Control-Allow-Origin", Arrays.asList("*"));
		put("Access-Control-Allow-Methods", Arrays.asList("GET,POST,DELETE,PUT,OPTIONS"));
	}};

	
	@GetMapping("/testGet")
	public ResponseEntity<Object> testGet() {
		return new ResponseEntity<>(testService.list(), headers, HttpStatus.OK);
	}
	
	@PostMapping("/testPost")
	public ResponseEntity<Object> testPost(@RequestBody TestTable testTable) {
		testService.insert(testTable);
		return new ResponseEntity<>("Inserted successfully", headers, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/testDelete")
	public ResponseEntity<Object> testDelete() {
		testService.delete();
		return new ResponseEntity<>("Deleted successfully", headers, HttpStatus.ACCEPTED);
	}
}
