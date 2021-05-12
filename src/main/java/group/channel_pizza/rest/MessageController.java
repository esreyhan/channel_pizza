package group.channel_pizza.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import channelpizza.model.Item;
import channelpizza.model.Order;
import channelpizza.model.User;
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
	public String saveUser(@RequestBody  User user) {
		userrepository.save(user);
		return "Added pizza with id : " + user.getId();
	}
	
	@GetMapping("/findUserById/{id}")
	public Optional<User> getUser (@PathVariable int id) {
		
		return userrepository.findById(id);
		
	}
	
	@PostMapping("/addOrder")
	public String saveOrder(@RequestBody  Order order) {
		
		
		
		orderrepository.save(order);
		
		return "Added pizza with id : " + order.getId();
	}
	
	

}