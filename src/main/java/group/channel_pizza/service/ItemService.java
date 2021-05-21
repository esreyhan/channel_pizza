package group.channel_pizza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import channelpizza.model.Item;
import group.channel_pizza.repository.ItemRepository;


@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemrepository;
	
	public Item savePizza(Item item) {
		itemrepository.save(item);
		return item;
	}
	public List<Item> getAllItems () {
	return itemrepository.findAll();
	}
	
public Optional<Item> getItem (String id){
		
		return itemrepository.findById(id);
		
	}

}
