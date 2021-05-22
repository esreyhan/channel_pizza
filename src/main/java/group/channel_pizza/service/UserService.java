package group.channel_pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import channelpizza.model.User;
import channelpizza.model.UserDTO;
import group.channel_pizza.repository.ItemRepository;
import group.channel_pizza.repository.UserRepository;

@Service
public class UserService {

@Autowired
private UserRepository userrepository;
	
public User saveUser(User user) {
		return userrepository.save(user);
	}

public User getUserByUsername (String username) {
	
	return userrepository.findByUsername(username);
	
}

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
