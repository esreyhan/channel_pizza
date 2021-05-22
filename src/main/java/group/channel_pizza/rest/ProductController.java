package group.channel_pizza.rest;

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
import group.channel_pizza.service.ItemService;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin
//(origins="http://localhost:3459")
public class ProductController {
	@Autowired
	private ItemService itemservice;
	
	@PostMapping("/addProduct")
	public String saveProduct(@RequestBody Item item) {
		
		itemservice.savePizza(item);
		return "Product id is :" + item.getId();
	}

	
	@GetMapping("/findAllItems") 
	public List<Item> getAllItems (Item item) {
		return itemservice.getAllItems();
	}
	
	
	@GetMapping("/findItemById/{id}")
	public Optional<Item> getPizza (@PathVariable String id) {
		
		
		return itemservice.getItem(id);
		
	}
	
	
	
}
