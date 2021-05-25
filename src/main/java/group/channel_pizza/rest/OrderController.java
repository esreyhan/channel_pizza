package group.channel_pizza.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group.channel_pizza.model.Order;
import group.channel_pizza.service.OrderService;
/**
 * 
 * The rest service class for entity Order
 * 
 * Please see: {@link group.channel_pizza.model.Order} class 
 * 
 * @author Enis Sinan Reyhan 
 *
 */


@RestController
@RequestMapping("/api/messages")
@CrossOrigin
public class OrderController {
	
	@Autowired
	private OrderService orderservice;
/**
 * 	<p> the web service is used for registering user from client side </p>
 * @param order: the parameter is get from post rest service parsed from JSON
 * @return order entity is returned to the client, as JSON, upon successful Mongodb query
 */
	@PostMapping("/addOrder")
	public Order saveOrder(@RequestBody  Order order) {	
		return orderservice.saveOrder(order);
	}
	

}
