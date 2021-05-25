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

import group.channel_pizza.model.Item;
import group.channel_pizza.service.ItemService;

/**
 * 
 * The rest service class for entity Item
 * 
 *  Please see: {@link group.channel_pizza.model.Item} class 
 * 
 * @author Enis Sinan Reyhan
 *
 */

@RestController
@RequestMapping("/api/messages")
@CrossOrigin
//(origins="http://localhost:3459")
public class ProductController {
	@Autowired
	private ItemService itemservice;
/**
 * <p> The method is used to add product from request sent by client </p>
 * 
 * @param item: gets item as a parameter from rest service, parsed from JSON
 * @return string is returned to the client with id upon successful query
 */
	
	@PostMapping("/addProduct")
	public String saveProduct(@RequestBody Item item) {
		itemservice.saveItem(item);
		return "Product id is :" + item.getId();
	}

	/**
	 * 
	 * <p> The method is used for listing the products </p>
	 * @param item:gets item as a parameter from rest service, parsed from JSON
	 * @return returns items as a JSON list 
	 */
	@GetMapping("/findAllItems") 
	public List<Item> getAllItems (Item item) {
		return itemservice.getAllItems();
	}
	/**
	 * <p> The method is used to get an item with id
	 * @param id as string
	 * @return Item entity as a JSON object on web service 
	 */
	
	@GetMapping("/findItemById/{id}")
	public Optional<Item> getItem (@PathVariable String id) {
		
		
		return itemservice.getItem(id);
		
	}
	
	
	
}
