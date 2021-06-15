package com.hoda.firstproject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/coding")

public class CodingController {
	 @RequestMapping("/")
     public String hello() {
             return "Hello Coding Dojo!";
     }

}


