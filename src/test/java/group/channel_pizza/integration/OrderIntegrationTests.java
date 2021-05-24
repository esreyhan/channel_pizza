package group.channel_pizza.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import org.mockito.BDDMockito;
import org.mockito.Mockito;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import channelpizza.model.Item;
import channelpizza.model.Order;
import group.channel_pizza.repository.OrderRepository;

@AutoConfigureJsonTesters
@SpringBootTest
@AutoConfigureMockMvc
public class OrderIntegrationTests {


	
	@MockBean
	private OrderRepository orderrepository;
	
	 @Autowired
private JacksonTester<Order> jsonPizza;

	@Autowired
	private  MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Test
	public void Test () throws JsonProcessingException, Exception {
		
		
		
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
		
		returnedOrder.setQuantity(itemsquantity);
		returnedOrder.setTotal(5.0);
		returnedOrder.setUserid("user12");
		
		when(orderrepository.save(Mockito.any(Order.class)))
        .thenReturn(returnedOrder);
		
		String url = "http://localhost:8080/api/messages/addOrder";
		MvcResult mvcResult = mockMvc.perform(post(url).contentType("application/json").content(objectMapper.writeValueAsString(newOrder))).andExpect(status().isOk()).andReturn();
		String actualJsonRespont = mvcResult.getResponse().getContentAsString();
		String expectedJsonResponse = objectMapper.writeValueAsString(returnedOrder);
		System.out.println(actualJsonRespont);
		assertThat(actualJsonRespont).isEqualToIgnoringWhitespace(expectedJsonResponse);	

	
	}
	
	
	
	
}
