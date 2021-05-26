package group.channel_pizza.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import org.mockito.BDDMockito;
import org.mockito.Mockito;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import group.channel_pizza.model.Item;
import group.channel_pizza.model.User;
import group.channel_pizza.model.UserDTO;
import group.channel_pizza.repository.ItemRepository;
import group.channel_pizza.repository.OrderRepository;
import group.channel_pizza.repository.UserRepository;
import group.channel_pizza.rest.OrderController;
import group.channel_pizza.rest.ProductController;
import group.channel_pizza.service.ItemService;

/**
 * 
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
public class ItemIntegrationTests {


	
	@MockBean
	private ItemRepository itemrepository;
	
	
	 @Autowired
	 private JacksonTester<Item> jsonPizza;

	@Autowired
	private  MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	/**
	 * itemrepository.findAll() method is mocked with a list of two items. the list is returned from web service. 
	 * @throws Exception
	 */

	@Test
	public void getAllItems () throws Exception {
		
		//Given
		String url = "http://localhost:8080/api/messages/findAllItems";
		List<Item> items = new ArrayList<>();
		items.add(new Item("1","CokeLight","Coca Cola Light", "cokelight.jpg", 2.0,"beverage","2020-10-02"));
		items.add(new Item("2","Coke","Coca Cola", "coke.jpg", 2.0,"beverage","2020-10-01"));
		//When
		Mockito.when(itemrepository.findAll()).thenReturn(items);
		MvcResult mvcResult = mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		String expectedJsonResponse = objectMapper.writeValueAsString(items);
		
		//Then
		assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);

		
	}
	/**
	 * The itemrepository save method is mocked. The id of the newitem (mocked as to be generated from database) is returned.
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void saveProductTest () throws JsonProcessingException, Exception {
		//Given
		Item savedItem = new Item(null,"CokeLight","Coca Cola Light", "cokelight.jpg", 2.0,"beverage","2020-10-02");
		Item newItem = new Item("1","CokeLight","Coca Cola Light", "cokelight.jpg", 2.0,"beverage","2020-10-02");
		
		//When 
		
		Mockito.when(itemrepository.save(savedItem)).thenReturn(newItem);
		String url = "http://localhost:8080/api/messages/addProduct";
		mockMvc.perform(
				post(url).contentType("application/json")
				.content(objectMapper.writeValueAsString(newItem)))
		
		//Then
		.andExpect(status().isOk())
		.andExpect(content().string("Product id is :1"));
		
		
	
	}
	/**
	 * The itemrepository's findById is mocked to return an item on the assumption that the item exists in the database. The item is returned by web service. 
	 * @throws Exception
	 */
		@Test
		public void getItemTest() throws Exception {
			
			//Given
			
			Optional<Item> item  = Optional.of(new Item("1","CokeLight","Coca Cola Light", "cokelight.jpg", 2.0,"beverage","2020-10-02"));
			
			//When
		
			Mockito.when(itemrepository.findById("1")).thenReturn(item);
			
			String url = "http://localhost:8080/api/messages//findItemById/1";
			
			MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
			
			String actualJsonResponse = mvcResult.getResponse().getContentAsString();
			
			
			String expectedJsonResponse = objectMapper.writeValueAsString(item);
			
			//Then
			
			assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
			
			
	}
		/**
		 * 
		 * The itemrepository's findById is mocked as not to return any item (null). The empty response is returned by web service. 
		 * 
		 * @throws Exception
		 */

		@Test 
		public void getItemTest2() throws Exception {
			
			//When
			Mockito.when(itemrepository.findById("1")).thenReturn(null);
			String url = "http://localhost:8080/api/messages//findItemById/1";
			MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
			String actualJsonResponse = mvcResult.getResponse().getContentAsString();
			
			//Then 
			assertThat(actualJsonResponse).isEmpty();
			
		}
}
