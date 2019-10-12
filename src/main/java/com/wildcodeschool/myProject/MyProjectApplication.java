package com.wildcodeschool.myProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;


@Controller
@SpringBootApplication
public class MyProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyProjectApplication.class, args);
    }
    
    @RequestMapping("/doctor/{id}")
    @ResponseBody
    public ResponseEntity<?> getDoctorId(@PathVariable int id) {
    	String rep ="";
    	if (id < 9) {
    		return new ResponseEntity<>("303 See Other.",HttpStatus.SEE_OTHER);
    	}
    	
    	switch(id) {
		case 9:
			rep = "{\"number\": 9, \"name\": \"Christopher Eccleston\"}";
			break;
		case 10: 
			rep = "{\"number\": 10, \"name\": \"David Tennant\"}";
			break;
		case 11:
			rep = "{\"number\": 11, \"name\": \"Matt Smith\"}";
			break;
		case 12:
			rep = "{\"number\": 12, \"name\": \"Peter Capaldi\"}";
			break;
		case 13:
			rep = "{\"number\": 13, \"name\": \"Jodie Whittaker\"}";
			break;
		default:
			return new ResponseEntity<>("Impossible de récupérer l'incarnation "+id, HttpStatus.NOT_FOUND);
		}
  
        return new ResponseEntity<>(rep,HttpStatus.OK); 
    }
}
