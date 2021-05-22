package group.channel_pizza.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import channelpizza.model.Order;
import group.channel_pizza.service.OrderService;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin
public class OrderController {
	
	@Autowired
	private OrderService orderservice;
	
	@PostMapping("/addOrder")
	public Order saveOrder(@RequestBody  Order order) {	
		System.out.println(order.getDate());
		return orderservice.saveOrder(order);
	}
	

}
