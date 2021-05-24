package group.channel_pizza.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import channelpizza.model.Order;
import channelpizza.model.User;
import group.channel_pizza.repository.OrderRepository;
import group.channel_pizza.repository.UserRepository;
import group.channel_pizza.service.OrderService;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
public class OrderRepositoryTests {


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
