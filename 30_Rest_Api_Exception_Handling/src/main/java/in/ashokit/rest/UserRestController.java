package in.ashokit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.exception.UserNotFoundException;

@RestController
public class UserRestController {
	
	@GetMapping(value = "/user/{userId}")
	public String getUserName(@PathVariable("userId") Integer userId) throws Exception{
		if(userId==100) {
			return "John";
		}else if(userId==200) {
			return "smith";
		}else {
			throw new UserNotFoundException("User Not Found");
		}
	}

}
