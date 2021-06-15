package com.hoda3.hellohuman;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HumanControler {
//Create an app that will render a page with either a default value of "human" or with the name provided in the URL query string
	@RequestMapping("/")
    public String index(@RequestParam(value="name", required=false) String searchQuery) {
		if(searchQuery==null) {
        return "Hello! Human " +"<br>"+" Welcom to SpringBoot" ;
		}
		else {
			return "Hello! "+searchQuery +"<br>"+" Welcom to SpringBoot";
		}
    }

}
 