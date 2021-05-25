package group.channel_pizza.rest;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group.channel_pizza.model.User;
import group.channel_pizza.model.UserDTO;
import group.channel_pizza.repository.UserRepository;
import group.channel_pizza.service.UserService;

/**
 * 
 * The rest service class for entity User
 *
 *  Please see: {@link group.channel_pizza.model.User} class 
 * 
 * @author Enis Sinan Reyhan
 *
 */

@RestController
@RequestMapping("/api/messages")
@CrossOrigin
//(origins="http://localhost:3459")
public class UserController {
	@Autowired
	private UserService userservice;
	@Autowired
	private UserRepository userrepository;
	
	/**
	 * <p> Add user from rest service </p>
	 * @param user: get user as input from web service
	 * @return returns user as an output upon successful registration 
	 */
	@PostMapping("/addUser")
	public User saveUser (@RequestBody  User user) {
	
		
		return  userservice.saveUser(user);
	}
	

	@GetMapping("/findUserByUsername/{username}")
	public User getUserByUsername (@PathVariable String username) {
		
		return userservice.getUserByUsername(username);
		
	}
	@PostMapping("user")
	public User login (@RequestBody  UserDTO userdto){
					
		
		return userservice.login(userdto);
		
	}

}
