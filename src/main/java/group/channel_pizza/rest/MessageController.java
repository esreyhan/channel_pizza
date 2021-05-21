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
import group.channel_pizza.service.ItemService;
import group.channel_pizza.service.OrderService;
import group.channel_pizza.service.UserService;





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

	@Autowired
	private ItemService itemservice;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private OrderService orderservice;
	
	/*
	@PostMapping("/addProduct")
	public String savePizza(@RequestBody Item item) {
		itemrepository.save(item);
		return "Added product with id : " + item.getId();
	}*/
	
	@PostMapping("/addProduct")
	public String savePizza(@RequestBody Item item) {
		Item item2 = itemservice.savePizza(item);
		return "Added product with id : " + item2.getId();
	}
	/*
	@GetMapping("/findAllItems") 
	public List<Item> getPizzas (Item item) {
		
		return itemrepository.findAll();
		
	}*/
	
	@GetMapping("/findAllItems") 
	public List<Item> getAllItems (Item item) {
		System.out.println("itemlistsent");
		return itemservice.getAllItems();
	}
	/*
	@GetMapping("/findItemById/{id}")
	public Optional<Item> getPizza (@PathVariable String id) {
		
		return itemrepository.findById(id);
		
	}*/
	
	@GetMapping("/findItemById/{id}")
	public Optional<Item> getPizza (@PathVariable String id) {
		
		return itemservice.getItem(id);
		
	}
	
	/*
	
	@PostMapping("/addUser")
	public User saveUser(@RequestBody  User user) {
		
		User user1 = userrepository.save(user);
		return  user1;
	}
	*/
	@PostMapping("/addUser")
	public User saveUser(@RequestBody  User user) {
		
		
		return  userservice.saveUser(user);
	}
	
	/*

	@GetMapping("/findUserByUsername/{username}")
	public User getUserByUsername (@PathVariable String username) {
		
		return userrepository.findByUsername(username);
		
	}
	
	*/
	
	@GetMapping("/findUserByUsername/{username}")
	public User getUserByUsername (@PathVariable String username) {
		
		return userservice.getUserByUsername(username);
		
	}
	/*
	@PostMapping("/addOrder")
	public Order saveOrder(@RequestBody  Order order) {
		System.out.println("order adder");		
		return orderrepository.save(order);
	}
	*/
	
	@PostMapping("/addOrder")
	public Order saveOrder(@RequestBody  Order order) {	
		return orderservice.saveOrder(order);
	}
	
	/*
	
	@PostMapping("user")
	public User login (@RequestBody  UserDTO userdto){
			
		
		String username = userdto.getUsername();
		if(userrepository.existsByUsername(username)){
			User user = userrepository.findByUsername(username);
			if (userdto.getPassword().equals(user.getPassword())) {
				return user;
			}
		}
		return null;
		
	}*/
	@PostMapping("user")
	public User login (@RequestBody  UserDTO userdto){
			
		
		return userservice.login(userdto);
		
	}


}