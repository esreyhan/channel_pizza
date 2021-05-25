package group.channel_pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import group.channel_pizza.model.Order;
import group.channel_pizza.repository.OrderRepository;
/**
 * Service layer for the Entity Order
 * 
 *  Please see: {@link group.channel_pizza.model.Order} class 
 * 
 * @author Enis Sinan Reyhan
 *
 */
@Service
public class OrderService {
	@Autowired
	private OrderRepository orderrepository;
	
	/**
	 * <p> Saves the item </p>
	 * @param order input from Controller class:
	 * Please see:  {@link group.channel_pizza.rest.OrderController}
	 * @return returns Order entity to the Controller class
	 * Please see: {@link group.channel_pizza.rest.OrderController}
	 */
	
	public Order saveOrder(Order order) {	
		
		return orderrepository.save(order);
	}
	
}
