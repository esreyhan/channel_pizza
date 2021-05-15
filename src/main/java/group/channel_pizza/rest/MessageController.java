package group.channel_pizza.rest;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import channelpizza.model.Item;
import channelpizza.model.Order;
import channelpizza.model.User;
import channelpizza.model.UserDTO;
import group.channel_pizza.repository.ItemRepository;
import group.channel_pizza.repository.OrderRepository;
import group.channel_pizza.repository.UserRepository;





@RestController
@RequestMapping("/api/messages")
@CrossOrigin
//(origins="http://localhost:3459")
public class MessageController {
	@Autowired
	private ItemRepository itemrepository;

	@Autowired
	private UserRepository userrepository;
	@Autowired
	private OrderRepository orderrepository;


	
	
	@PostMapping("/addProduct")
	public String savePizza(@RequestBody Item item) {
		itemrepository.save(item);
		return "Added product with id : " + item.getId();
	}
	
	@GetMapping("/findAllItems") 
	public List<Item> getPizzas (Item item) {
		
		return itemrepository.findAll();
		
	}
	
	@GetMapping("/findItemById/{id}")
	public Optional<Item> getPizza (@PathVariable String id) {
		
		return itemrepository.findById(id);
		
	}
	
	@PostMapping("/addUser")
	public User saveUser(@RequestBody  User user) {
		
		User user1 = userrepository.save(user);
		return  user1;
	}

	@GetMapping("/findUserByUsername/{username}")
	public User getUserByUsername (@PathVariable String username) {
		
		return userrepository.findByUsername(username);
		
	}
	
	@PostMapping("/addOrder")
	public Order saveOrder(@RequestBody  Order order) {
		System.out.println("order adder");		
		return orderrepository.save(order);
	}
	
	
	@PostMapping("user")
	public User login (@RequestBody  UserDTO userdto){
			SecureRandom random = new SecureRandom();
		
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