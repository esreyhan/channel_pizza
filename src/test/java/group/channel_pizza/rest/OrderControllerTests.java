package group.channel_pizza.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
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

@WebMvcTest(OrderController.class)
public class OrderControllerTests {

	@Autowired
	private  MockMvc mockMvc;
	
	@MockBean
	private OrderService orderservice;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	




	@Test
	public void saveOrder () throws Exception {
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
		
		Order returnedOrder= new Order();
		returnedOrder.setId("1");
		List<String> items2 = new ArrayList<>();
		items2.add("id 1");
		items2.add("id 2");
		newOrder.setOrderitems(items2);
		List<Integer> itemsquantity2 = new ArrayList<>();
		itemsquantity2.add(2);
		itemsquantity2.add(3);
		newOrder.setQuantity(itemsquantity2);
		newOrder.setTotal(5.0);
		newOrder.setUserid("user12");
		
		//When 
		String url = "http://localhost:8080/api/messages/addOrder";
		Mockito.when(orderservice.saveOrder(Mockito.any(Order.class))).thenReturn(returnedOrder);
		
		//Then  
		MvcResult mvcResult = mockMvc.perform(post(url).contentType("application/json").content(objectMapper.writeValueAsString(newOrder))).andExpect(status().isOk()).andReturn();
		String actualJsonRespont = mvcResult.getResponse().getContentAsString();
		String expectedJsonResponse = objectMapper.writeValueAsString(returnedOrder);
		
		assertThat(actualJsonRespont).isEqualToIgnoringWhitespace(expectedJsonResponse);
		
		
	}
	
	
	
	
}
