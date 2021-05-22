package group.channel_pizza.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DuplicateKeyException;

import channelpizza.model.Order;
import channelpizza.model.User;
import channelpizza.model.UserDTO;
import group.channel_pizza.repository.UserRepository;
import group.channel_pizza.service.UserService;


@WebMvcTest(UserController.class)
public class UserControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	
	@Autowired
	private WebApplicationContext context;
	
	@MockBean
	private UserService userservice;
	
	@MockBean
	private UserRepository userrepository;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	

	
	
	//When there is not existing user and user registration is successful
	@Test
	public void saveUserTest () throws JsonProcessingException, Exception {
		
		
		User newUser = new User("1","test-username","test-password","test-fullname","test-email","test-address");
		
		User savedUser = new User("1","test-username","test-password","test-fullname","test-email","test-address");
		
		savedUser.setId(null);
	
		Mockito.when(userservice.saveUser(Mockito.any(User.class))).thenReturn(newUser);
		String url = "http://localhost:8080/api/messages/addUser";
		
		String jsonrequest = objectMapper.writeValueAsString(savedUser);
		
		MvcResult mvcResult = mockMvc.perform(
				post(url)
				.content(jsonrequest).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		
		
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		
		
		String expectedJsonResponse = objectMapper.writeValueAsString(newUser);
		
		assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);

	}
	
	//When there is existing user and user registration is not successful
		@Test
		public void saveUserTestNotSuccessful () throws JsonProcessingException, Exception {
			
						
			User savedUser = new User("1","test-username","test-password","test-fullname","test-email","test-address");
			
			savedUser.setId(null);
		
			Mockito.when(userservice.saveUser(Mockito.any(User.class))).thenThrow(DuplicateKeyException.class);;
			String url = "http://localhost:8080/api/messages/addUser";
			
			String jsonrequest = objectMapper.writeValueAsString(savedUser);
			
			mockMvc.perform(
					post(url)
					.content(jsonrequest).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().is5xxServerError());
			

		}
	
	//User is found
	@Test
	public void getUserByUsernameTest () throws Exception {
		
		
		String username = "test-username";
		User newUser = new User("1","test-username","test-password","test-fullname","test-email","test-address");
		Mockito.when(userservice.getUserByUsername(Mockito.any(String.class))).thenReturn(newUser);
		String url = "http://localhost:8080/api/messages/findUserByUsername/"+ username;
		MvcResult mvcResult = mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		String expectedJsonResponse = objectMapper.writeValueAsString(newUser);
		assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);

		
	}
	
	//User not found - Expect to return empyty
	@Test
	public void getUserByUsernameTestNull () throws Exception {
		
		//User is found
		String username = "test-username";
		Mockito.when(userservice.getUserByUsername(Mockito.any(String.class))).thenReturn(null);
		String url = "http://localhost:8080/api/messages/findUserByUsername/"+ username;
		MvcResult mvcResult = mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		assertThat(actualJsonResponse).isEmpty();
		
		

		
	}
	
	
	
	//Where login information is successful
	@Test
	public void login () throws Exception {
		UserDTO sentUser = new UserDTO();
		sentUser.setUsername("test-username");
		sentUser.setPassword("test-password");
		User existingUser = new User("1","test-username","test-password","test-fullname","test-email","test-address");
		Mockito.when(userservice.login(Mockito.any(UserDTO.class))).thenReturn(existingUser);
		String url= "http://localhost:8080/api/messages/user";
		MvcResult mvcResult= mockMvc.perform(
				post(url).contentType("application/json")
				.content(objectMapper.writeValueAsString(sentUser))).andExpect(status().isOk()).andReturn();
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		
		
		String expectedJsonResponse = objectMapper.writeValueAsString(existingUser);
		
		assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
		
		
		
	}
	
	//When user information is not successfull
	@Test
	public void loginNull () throws Exception {
		UserDTO sentUser = new UserDTO();
		sentUser.setUsername("test-username");
		sentUser.setPassword("test-password");
		Mockito.when(userservice.login(Mockito.any(UserDTO.class))).thenReturn(null);
		String url= "http://localhost:8080/api/messages/user";
		MvcResult mvcResult= mockMvc.perform(
				post(url).contentType("application/json")
				.content(objectMapper.writeValueAsString(sentUser))).andExpect(status().isOk()).andReturn();
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		assertThat(actualJsonResponse).isEmpty();
		
		
		
		
	}
	

}
