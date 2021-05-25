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

import group.channel_pizza.model.User;
import group.channel_pizza.model.UserDTO;
import group.channel_pizza.repository.UserRepository;

/**
 * The class is for integration tests with mock MVC structure. 
 * The test ensures that the input from test layer is transferred and processed to repository layer and correct output is returned. 
 * 
 * Memory based database, container or different collection methods are not used for these tests as instructed. Mockito is used for mocking repository responses.
 * 
 * @author Enis Sinan Reyhan
 *
 */

@AutoConfigureJsonTesters
@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTests {


	
	@MockBean
	private UserRepository userrepository;
	
	 @Autowired
private JacksonTester<User> jsonPizza;

	@Autowired
	private  MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	/**
	 * Userrepository save method is mocked. The response is successfully returned from database. 
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */

	@Test
	public void UserRepositoryTest () throws JsonProcessingException, Exception {
		
	
		
		User savedUser = new User("1","test-username","test-password","test-fullname","test-email","test-address");
		
		//When
		User newUser = new User(null,"test-username","test-password","test-fullname","test-email","test-address");
		
		when(userrepository.save(Mockito.any(User.class)))
        .thenReturn(savedUser);
		
		String url = "http://localhost:8080/api/messages/addUser";
		MvcResult mvcResult = mockMvc.perform(post(url).contentType("application/json").content(objectMapper.writeValueAsString(newUser))).andExpect(status().isOk()).andReturn();
		String actualJsonRespont = mvcResult.getResponse().getContentAsString();
		String expectedJsonResponse = objectMapper.writeValueAsString(savedUser);
		System.out.println(actualJsonRespont);
		assertThat(actualJsonRespont).isEqualToIgnoringWhitespace(expectedJsonResponse);	
	
	
	}
	/**
	 * The userrepository findByUsername method is mocked to return a user, on the assumption that the user exists. The user succesfully returns from web service. 
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
		Mockito.when(userrepository.findByUsername(Mockito.any(String.class))).thenReturn(newUser);
		String url = "http://localhost:8080/api/messages/findUserByUsername/"+ username;
		MvcResult mvcResult = mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		String expectedJsonResponse = objectMapper.writeValueAsString(newUser);
		
		//Then
		assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);

		
	}
	/**
	 * The userrepository findByUsername method is mocked to return null, on the assumption that the user does not exist. The response is successfully empty. 
	 * 
	 * @throws Exception
	 */
	//User not found - Expect to return empyty
	@Test
	public void getUserByUsernameTestNull () throws Exception {
		
		//Given
		String username = "test-username";
		
		//When
		Mockito.when(userrepository.findByUsername(Mockito.any(String.class))).thenReturn(null);
		String url = "http://localhost:8080/api/messages/findUserByUsername/"+ username;
		MvcResult mvcResult = mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		
		//Then
		assertThat(actualJsonResponse).isEmpty();
		
		

		
	}
	/**
	 * The method checks whether login information is successful or not. The userrepository existsByUsername and findByUSername methods are mocked as to return a user on the assumnption
	 * that such user exists with the same username and password, passed by rest web service. 
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
		Mockito.when(userrepository.existsByUsername(Mockito.any(String.class))).thenReturn(true);
		Mockito.when(userrepository.findByUsername(Mockito.any(String.class))).thenReturn(existingUser);
		
		String url= "http://localhost:8080/api/messages/user";
		MvcResult mvcResult= mockMvc.perform(
				post(url).contentType("application/json")
				.content(objectMapper.writeValueAsString(sentUser))).andExpect(status().isOk()).andReturn();
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		
		
		String expectedJsonResponse = objectMapper.writeValueAsString(existingUser);
		
		//Then
		
		assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
		
		
		
		
	}
	/**
	*The method checks whether login information is successful or not. The userrepository existsByUsername method is mocked as to return a user on the assumnption
	* that such user does not exist.  
	* 
	*/
	//When user information is not successfull (user not found)
	@Test
	public void loginNull () throws Exception {
		//Given 
		UserDTO sentUser = new UserDTO();
		sentUser.setUsername("test-username");
		sentUser.setPassword("test-password");
		
		//When
		Mockito.when(userrepository.existsByUsername(Mockito.any(String.class))).thenReturn(false);
		String url= "http://localhost:8080/api/messages/user";
		MvcResult mvcResult= mockMvc.perform(
				post(url).contentType("application/json")
				.content(objectMapper.writeValueAsString(sentUser))).andExpect(status().isOk()).andReturn();
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		
		//Then
		assertThat(actualJsonResponse).isEmpty();
		
		
		
		
	}
	/**
	 * The userrepository existsByUsername method is mocked as to return true, however, user with different password is returned by mocked findByUsername method. 
	 * The rest api response is in line with the userrepository method's output. 
	 * 
	 * @throws Exception
	 */
	//Where password does not match
	@Test
	public void loginIncorrect () throws Exception {
		//Given 
		UserDTO sentUser = new UserDTO();
		sentUser.setUsername("test-username");
		sentUser.setPassword("test-pass");
		
		//When 
		User existingUser = new User("1","test-username","test-password","test-fullname","test-email","test-address");
		Mockito.when(userrepository.existsByUsername(Mockito.any(String.class))).thenReturn(true);
		Mockito.when(userrepository.findByUsername(Mockito.any(String.class))).thenReturn(existingUser);
		
		String url= "http://localhost:8080/api/messages/user";
		MvcResult mvcResult= mockMvc.perform(
				post(url).contentType("application/json")
				.content(objectMapper.writeValueAsString(sentUser))).andExpect(status().isOk()).andReturn();
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		
		
		String expectedJsonResponse = objectMapper.writeValueAsString(existingUser);
		
		//Then
		
		assertThat(actualJsonResponse).isEmpty();
		
		
		
	}
}
