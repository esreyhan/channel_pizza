package group.channel_pizza.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import channelpizza.model.Order;

@RunWith(SpringRunner.class)
@DataMongoTest
public class OrderRepositoryTests2 {

	OrderRepository orderrepository;
	@Test
	public void OrderRepositoryTest () {
		
		
		Order returnedOrder= new Order();
		returnedOrder.setId("1");
		List<String> items2 = new ArrayList<>();
		items2.add("id 1");
		items2.add("id 2");
		returnedOrder.setOrderitems(items2);
		returnedOrder.setTotal(5.0);
		returnedOrder.setUserid("user12");
		
		Optional<Order> result = orderrepository.findById("1");
		System.out.println(result.get().getDate());
		
		assertThat(result).isNotNull();
		
	}
	
}
