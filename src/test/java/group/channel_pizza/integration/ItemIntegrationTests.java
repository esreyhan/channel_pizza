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

import channelpizza.model.Item;
import channelpizza.model.User;
import channelpizza.model.UserDTO;
import group.channel_pizza.repository.ItemRepository;
import group.channel_pizza.repository.OrderRepository;
import group.channel_pizza.repository.UserRepository;
import group.channel_pizza.rest.OrderController;
import group.channel_pizza.rest.ProductController;
import group.channel_pizza.service.ItemService;


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
	
	//with value
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
		//when there is no product, null is returned 

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
