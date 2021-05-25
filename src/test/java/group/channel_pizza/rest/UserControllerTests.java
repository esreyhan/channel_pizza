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

import group.channel_pizza.model.Order;
import group.channel_pizza.model.User;
import group.channel_pizza.model.UserDTO;
import group.channel_pizza.repository.UserRepository;
import group.channel_pizza.service.UserService;

/**
 * 
 * The class is for unit tests for UserController classs. The service layer is mocked and verified whether the rest service responses are accurate. 
 * 
 * Mockito and junit are used for test and test environment. 
 * 
 * @author Enis Sinan Reyhan
 *
 */
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
	

	/**
	 * UserService saveUser method is mocked as to return a user. The user is successfully returned by web service.
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	
	@Test
	public void saveUserTest () throws JsonProcessingException, Exception {
		
		//Given
		User savedUser = new User(null,"test-username","test-password","test-fullname","test-email","test-address");
		
		//When
		User newUser = new User("1","test-username","test-password","test-fullname","test-email","test-address");
	
		Mockito.when(userservice.saveUser(Mockito.any(User.class))).thenReturn(newUser);
		String url = "http://localhost:8080/api/messages/addUser";
		
		String jsonrequest = objectMapper.writeValueAsString(savedUser);
		
		MvcResult mvcResult = mockMvc.perform(
				post(url)
				.content(jsonrequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		
		
		String expectedJsonResponse = objectMapper.writeValueAsString(newUser);
		
		//Then
		assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);

	}
	
/**
 * The UserService getUserByUsername method is mocked to return a user, on the assumption that the user exists. The user succesfully returns from web service.
 * 
 * @throws Exception
 */
	
	//User is found
	@Test
	public void getUserByUsernameTest () throws Exception {
		
		//Given
		String username = "test-username";
		User newUser = new User("1","test-username","test-password","test-fullname","test-email","test-address");
		
		//When
		Mockito.when(userservice.getUserByUsername(Mockito.any(String.class))).thenReturn(newUser);
		String url = "http://localhost:8080/api/messages/findUserByUsername/"+ username;
		MvcResult mvcResult = mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		String expectedJsonResponse = objectMapper.writeValueAsString(newUser);
		
		//Then
		assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);

/**
 *  The UserService getUserByUsername method is mocked to return null, on the assumption that the user does not exist. The response is successfully empty. 
 */
	}
	
	//User not found - Expect to return empyty
	@Test
	public void getUserByUsernameTestNull () throws Exception {
		
		//Given
		String username = "test-username";
		
		//When
		Mockito.when(userservice.getUserByUsername(Mockito.any(String.class))).thenReturn(null);
		String url = "http://localhost:8080/api/messages/findUserByUsername/"+ username;
		MvcResult mvcResult = mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		
		//Then
		assertThat(actualJsonResponse).isEmpty();
		
		

		
	}
	/**
	 * 
	 * The method checks whether login information is successful or not. The userservice login method is mockked to return a user. The web service succesfully returns the user. 
	 * 
	 * @throws Exception
	 */
	
	
	//Where login information is successful
	@Test
	public void login () throws Exception {
		//Given 
		UserDTO sentUser = new UserDTO();
		sentUser.setUsername("test-username");
		sentUser.setPassword("test-password");
		
		//When 
		User existingUser = new User("1","test-username","test-password","test-fullname","test-email","test-address");
		Mockito.when(userservice.login(Mockito.any(UserDTO.class))).thenReturn(existingUser);
		String url= "http://localhost:8080/api/messages/user";
		MvcResult mvcResult= mockMvc.perform(
				post(url).contentType("application/json")
				.content(objectMapper.writeValueAsString(sentUser))).andExpect(status().isOk()).andReturn();
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		
		
		String expectedJsonResponse = objectMapper.writeValueAsString(existingUser);
		
		//Then
		
		assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
		
		
		
	}
	/*
	 * The UserService login method is mocked as to return null, on the assunmption that user does not exist or password is wrong. Empty response is returned by web service. 
	 */
	//When user information is not successfull (user not found or password does not match)
	@Test
	public void loginNull () throws Exception {
		//Given 
		UserDTO sentUser = new UserDTO();
		sentUser.setUsername("test-username");
		sentUser.setPassword("test-password");
		
		//When
		Mockito.when(userservice.login(Mockito.any(UserDTO.class))).thenReturn(null);
		String url= "http://localhost:8080/api/messages/user";
		MvcResult mvcResult= mockMvc.perform(
				post(url).contentType("application/json")
				.content(objectMapper.writeValueAsString(sentUser))).andExpect(status().isOk()).andReturn();
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		
		//Then
		assertThat(actualJsonResponse).isEmpty();
		
		
		
		
	}
	

}
