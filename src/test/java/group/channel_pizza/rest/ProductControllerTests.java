package group.channel_pizza.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import channelpizza.model.Item;
import group.channel_pizza.repository.ItemRepository;
import group.channel_pizza.service.ItemService;

@WebMvcTest(ProductController.class)
public class ProductControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemService itemservice;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Test
	public void findAllItemsTest() throws Exception {
		//Given
		
		
		//When
		String url = "http://localhost:8080/api/messages/findAllItems";
		List<Item> items = new ArrayList<>();
		items.add(new Item("1","CokeLight","Coca Cola Light", "cokelight.jpg", 2.0,"beverage","2020-10-02"));
		items.add(new Item("2","Coke","Coca Cola", "coke.jpg", 2.0,"beverage","2020-10-01"));
		
		Mockito.when(itemservice.getAllItems()).thenReturn(items);
		
		
		//Then 
		
		MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
		
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		
		
		String expectedJsonResponse = objectMapper.writeValueAsString(items);
		
		assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
		
		
	}
	
	@Test
	public void saveProductTest () throws JsonProcessingException, Exception {
		//Given
		Item savedItem = new Item(null,"CokeLight","Coca Cola Light", "cokelight.jpg", 2.0,"beverage","2020-10-02");
		Item newItem = new Item("1","CokeLight","Coca Cola Light", "cokelight.jpg", 2.0,"beverage","2020-10-02");
		
		//When 
		
		Mockito.when(itemservice.saveItem(savedItem)).thenReturn(newItem);
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
	
		Mockito.when(itemservice.getItem("1")).thenReturn(item);
		
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
		Mockito.when(itemservice.getItem("1")).thenReturn(null);
		String url = "http://localhost:8080/api/messages//findItemById/1";
		MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		
		//Then 
		assertThat(actualJsonResponse).isEmpty();
		
	}
	
}
