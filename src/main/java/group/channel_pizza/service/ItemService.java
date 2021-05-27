package group.channel_pizza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import group.channel_pizza.model.Item;
import group.channel_pizza.repository.ItemRepository;
/**
 * Service layer for the Entity Item
 * 
 *  Please see: {@link group.channel_pizza.model.Item} class 
 * 
 * @author Enis Sinan Reyhan
 *
 */

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemrepository;

	/**
	 * <p> Saves the item </p>
	 * @param item input from Controller class:
	 * Please see:  {@link group.channel_pizza.rest.ProductController}
	 * @return returns Item entity to the Controller class
	 * Please see: {@link group.channel_pizza.rest.ProductController}
	 */
	
	public Item saveItem(Item item) {
		
		return itemrepository.save(item);
	}
	
	/**
	 * <p> List all items </p>
	 * @return returns Item list to the Controller class
	 * Please see: {@link group.channel_pizza.rest.ProductController}
	 */
	public List<Item> getAllItems () {
	return itemrepository.findAll();
	}
	
	/**
	 * <p> Get an item from id </p>
	 * @param id Item id from Controler class: 
	 * Please see:  {@link group.channel_pizza.rest.ProductController}
	 * @return returns Item entity to the Controller class
	 * Please see: {@link group.channel_pizza.rest.ProductController}
	 */
	
public Optional<Item> getItem (String id){
		
		return itemrepository.findById(id);
		
	}

/**
 * <p> Get an item from id </p>
 * @param id Item id from Controler class: 
 * Please see:  {@link group.channel_pizza.rest.ProductController}
 */
public void deletItem (String id) {
	itemrepository.deleteById(id);
}
}
