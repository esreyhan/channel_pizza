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

import channelpizza.model.Order;
import group.channel_pizza.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class OrderServiceTests {
	
	@MockBean
	private OrderRepository orderrepository;
	
	@InjectMocks
	private OrderService service;
	
	@Test
	public void testSaveOrder() {
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
		
		
		Mockito.when(orderrepository.save(Mockito.any(Order.class))).thenReturn(savedOrder);
		
		Order result = service.saveOrder(savedOrder);
		assert(result).equals(savedOrder);
	}

}
