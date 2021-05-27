package group.channel_pizza.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import org.mockito.BDDMockito;
import org.mockito.Mockito;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import group.channel_pizza.model.Item;
import group.channel_pizza.model.Order;
import group.channel_pizza.repository.OrderRepository;
/**
 * The class is for integration tests with mock MVC structure. 
 * The test ensures that the input from test layer is transferred and processed to repository layer and correct output is returned. 
 * 
 * Memory based database, container or different collection methods are not used for these tests as instructed. Mockito is used for mocking repository responses.
 * 
 * @author Enis Sinan Reyhan
 *
 */
@EnableAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
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
	
	/**
	 * 
	 * Orderrepository save method is mocked. The order is successfully returned. 
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
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
	
	/**
	 * orderrepository.findAll() method is mocked with a list of two items. the list is returned from web service. 
	 * @throws Exception
	 */

	@Test
	public void getAllItems () throws Exception {
		
		//Given
		String url = "http://localhost:8080/api/messages//findAllOrders";
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
		MvcResult mvcResult = mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		String expectedJsonResponse = objectMapper.writeValueAsString(orders);
		
		//Then
		assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);

		
	}
	
	
	
	
}
