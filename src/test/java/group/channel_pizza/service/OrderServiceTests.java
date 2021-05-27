package group.channel_pizza.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import group.channel_pizza.model.Item;
import group.channel_pizza.model.Order;
import group.channel_pizza.repository.OrderRepository;

/**
 * 
 * The class is for the unit tests of OrderService class. OrderRepository methods are mocked and OrderService methods outputs are checked. 
 * 
 * Mockito and junit are used for testing and testing environment. 
 * 
 * @author Enis Sinan Reyhan
 *
 */

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class OrderServiceTests {
	
	@MockBean
	private OrderRepository orderrepository;
	
	@InjectMocks
	private OrderService service;
/**
 * Itemrepository save method is mocked to return an order. Saved order is sent successfully by web service .
 * 
 *  
 */
	@Test
	public void testSaveOrder() {
		
		//Given 
		Order newOrder = new Order();
		List<String> items = new ArrayList<>();
		items.add("id 1");
		items.add("id 2");
		newOrder.setOrderitems(items);
		List<Integer> itemsquantity = new ArrayList<>();
		itemsquantity.add(2);
		itemsquantity.add(3);
		newOrder.setQuantity(itemsquantity);
		newOrder.setTotal(5.0);
		newOrder.setUserid("user12");
		
		Order savedOrder = new Order();
		savedOrder.setOrderitems(items);
		savedOrder.setQuantity(itemsquantity);
		savedOrder.setTotal(5.0);
		savedOrder.setUserid("user12");
		savedOrder.setId("1");
		
		//When
		Mockito.when(orderrepository.save(Mockito.any(Order.class))).thenReturn(savedOrder);
		Order result = service.saveOrder(savedOrder);
		
		//Then 
		
		assert(result).equals(savedOrder);
	}
	
	/**
	 * orderrepository findAll method is mocked as to return items list. Method succesfully returns the list. 
	 */
	@Test
	public void testGetAllItems() {
		
		//Given
		List<Order> orders = new ArrayList<>();
		Order order1 = new Order();
		order1.setId ("1");
		List<String> items = new ArrayList<>();
		items.add("2");
		items.add("3");
		order1.setOrderitems(items);
		List<Integer> quantities = new ArrayList<>();
		quantities.add(2);
		quantities.add(3);
		order1.setQuantity(quantities);
		
		Order order2 = new Order();
		order1.setId ("5");
		List<String> items2 = new ArrayList<>();
		items2.add("7");
		items2.add("8");
		order1.setOrderitems(items2);
		List<Integer> quantities2 = new ArrayList<>();
		quantities2.add(9);
		quantities2.add(5);
		order1.setQuantity(quantities2);
		orders.add(order1);
		orders.add(order2);
		
		
		
		//When 
		Mockito.when(orderrepository.findAll()).thenReturn(orders);

		List<Order> result = service.getAllItems();
		
		//Then
		assert(result).equals(orders);
		
	}

}
