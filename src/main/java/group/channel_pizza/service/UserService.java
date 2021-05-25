package group.channel_pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import group.channel_pizza.model.User;
import group.channel_pizza.model.UserDTO;
import group.channel_pizza.repository.ItemRepository;
import group.channel_pizza.repository.UserRepository;

/**
 * Service layer for the Entity User
 * 
 *  Please see: {@link group.channel_pizza.model.User} class 
 * 
 * @author Enis Sinan Reyhan
 *
 */

@Service
public class UserService {

@Autowired
private UserRepository userrepository;
	

/**
 * <p> Saves the item </p>
 * @param user input from Controller class:
 * Please see:  {@link group.channel_pizza.rest.UserController}
 * @return returns User entity to the Controller class
 * Please see: {@link group.channel_pizza.rest.UserController}
 */
public User saveUser(User user) {
		return userrepository.save(user);
	}

public User getUserByUsername (String username) {
	
	return userrepository.findByUsername(username);
	
}


/**
 * <p> Method is for login check </p>
 * @param userdto
 * @return User if the login is successful, otherwise returns null
 */
public User login (UserDTO userdto){
	
	
	String username = userdto.getUsername();
	if(userrepository.existsByUsername(username)){
		User user = userrepository.findByUsername(username);
		if (userdto.getPassword().equals(user.getPassword())) {
			return user;
		}
	}
	return null;
	
}
	
}
