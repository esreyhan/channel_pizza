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

import group.channel_pizza.model.Item;
import group.channel_pizza.model.Order;
import group.channel_pizza.repository.ItemRepository;

/**
 * 
 * The class is for the unit tests of ItemService class. ItemRepository methods are mocked and ItemService methods outputs are checked. 
 * 
 * Mockito and junit are used for testing and testing environment. 
 * 
 * @author Enis Sinan Reyhan
 *
 */

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class ItemServiceTest {

	@MockBean
	private ItemRepository itemrepository;
	
	@InjectMocks
	private ItemService service;
	
	/**
	 * Itemrepository saveItem method is mocked as to return Item object. Method successfully returns. 
	 */
	@Test
	public void testSaveItem() {
		
		//Given
		
		Item newItem = new Item(null,"CokeLight","Coca Cola Light", "cokelight.jpg", 2.0,"beverage","2020-10-02");
		Item savedItem = new Item("1","CokeLight","Coca Cola Light", "cokelight.jpg", 2.0,"beverage","2020-10-02");
		
		
		//When
		
		
		Mockito.when(itemrepository.save(Mockito.any(Item.class))).thenReturn(savedItem);
		Item result = service.saveItem(newItem);
		
		//Then
		assert(result).equals(savedItem);
	}
	
	/**
	 * Itemrepository findAll method is mocked as to return items list. Method succesfully returns the list. 
	 */
	@Test
	public void testGetAllItems() {
		
		//Given
		List<Item> items = new ArrayList<>();
		items.add(new Item("1","CokeLight","Coca Cola Light", "cokelight.jpg", 2.0,"beverage","2020-10-02"));
		items.add(new Item("2","Coke","Coca Cola", "coke.jpg", 2.0,"beverage","2020-10-01"));
		
		
		//When 
		Mockito.when(itemrepository.findAll()).thenReturn(items);
		
		List<Item> result = service.getAllItems();
		
		//Then
		assert(result).equals(items);
		
	}
	/**
	 * Itemrepository findById method is mocked to return Item object, for the case where an item is found. The method returns the Item object. 
	 */
	//When item is found
	@Test
	public void testGetItem() {
		//Given 
		Item returnedItem = new Item("1","CokeLight","Coca Cola Light", "cokelight.jpg", 2.0,"beverage","2020-10-02");
		String id = "1";
		Optional<Item> opReturnedItem = Optional.of(returnedItem);
		
		//When
		Mockito.when(itemrepository.findById(Mockito.any(String.class))).thenReturn(opReturnedItem);
		Optional<Item> result = service.getItem(id);
		
		//Then
		
		assert(result).equals(opReturnedItem);
	}
	/**
	 * Itemrepository findById is mocked as to return null, for the case where the items does not exist. Method also returns null. 
	 */
	//When item is not found
	public void testGetItemNull() {
		//Given
		String id = "1";
		
		//When
		Mockito.when(itemrepository.findById(Mockito.any(String.class))).thenReturn(null);
		Optional<Item> result = service.getItem(id);
		
		//Then 
		
		assertThat(result).isNull();
	}
}
