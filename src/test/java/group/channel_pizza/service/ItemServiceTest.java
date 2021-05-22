package group.channel_pizza.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import channelpizza.model.Item;
import channelpizza.model.Order;
import group.channel_pizza.repository.ItemRepository;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class ItemServiceTest {

	@MockBean
	private ItemRepository itemrepository;
	
	@InjectMocks
	private ItemService service;
	
	
	@Test
	public void testSaveItem() {
		
		Item savedItem = new Item("1","CokeLight","Coca Cola Light", "cokelight.jpg", 2.0,"beverage","2020-10-02");
		Item newItem = new Item(null,"CokeLight","Coca Cola Light", "cokelight.jpg", 2.0,"beverage","2020-10-02");
		Mockito.when(itemrepository.save(Mockito.any(Item.class))).thenReturn(savedItem);
		Item result = service.saveItem(savedItem);
		assert(result).equals(savedItem);
	}
	
	
	@Test
	public void testGetAllItems() {
		List<Item> items = new ArrayList<>();
		items.add(new Item("1","CokeLight","Coca Cola Light", "cokelight.jpg", 2.0,"beverage","2020-10-02"));
		items.add(new Item("2","Coke","Coca Cola", "coke.jpg", 2.0,"beverage","2020-10-01"));
		
		Mockito.when(itemrepository.findAll()).thenReturn(items);
		
		List<Item> result = service.getAllItems();
		assert(result).equals(items);
		
	}
	
	//When item is found
	@Test
	public void testGetItem() {
		Item returnedItem = new Item("1","CokeLight","Coca Cola Light", "cokelight.jpg", 2.0,"beverage","2020-10-02");
		String id = "1";
		Optional<Item> opReturnedItem = Optional.of(returnedItem);
		Mockito.when(itemrepository.findById(Mockito.any(String.class))).thenReturn(opReturnedItem);
		Optional<Item> result = service.getItem(id);
		assert(result).equals(opReturnedItem);
	}
	
	//When item is not found
	public void testGetItemNull() {
		String id = "1";
		Mockito.when(itemrepository.findById(Mockito.any(String.class))).thenReturn(null);
		Optional<Item> result = service.getItem(id);
		assertThat(result).isNull();
	}
}
