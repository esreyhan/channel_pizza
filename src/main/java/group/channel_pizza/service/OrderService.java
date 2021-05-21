package group.channel_pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import channelpizza.model.Order;
import group.channel_pizza.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderrepository;
	
	public Order saveOrder(Order order) {	
		return orderrepository.save(order);
	}
	
}
