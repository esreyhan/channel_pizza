package group.channel_pizza.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import group.channel_pizza.model.User;
import group.channel_pizza.model.UserDTO;
import group.channel_pizza.repository.UserRepository;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.mockito.junit.jupiter.MockitoExtension;
/**
 *  The class is for the unit tests of UserService class. UserRepository methods are mocked and UserService methods outputs are checked. 
 * 
 * Mockito and junit are used for testing and testing environment. 
 * 
 * @author Enis Sinan Reyhan
 */

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class UserServiceTests {
	
	@MockBean
	private UserRepository userrepository;
	
	@InjectMocks
	private UserService service;
	
	//Username information is true
	/**
	 * UserRepository existsByUsername method is mocked as to return true and findByUsername is mockked as to return User object. 
	 * The test method assumes that user exists. 
	 */
	@Test
	public void testLogin() {
		//Given 
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername("test-username");
		userDTO.setPassword("test-password");
		
		//When
		User user = new User("1","test-username","test-password","test-fullname","test-email","test-address");
		Mockito.when(userrepository.existsByUsername(Mockito.any(String.class))).thenReturn(true);
		Mockito.when(userrepository.findByUsername(Mockito.any(String.class))).thenReturn(user);
		
		User result = service.login(userDTO);
		
		//Then 
		assert(result).equals(user); 
		
		
	}
	/**
	 * The test method is based on the assumption that the user does not exist. Thıs, UserRepository existByUsername method returns false. 
	 */
	
	//Username does not exist
	@Test
	public void testLoginUserFail() {
		//Given 
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername("test-username");
		userDTO.setPassword("test-password--2");
		User user = new User("1","test-username","test-password","test-fullname","test-email","test-address");
		
		//When 
		Mockito.when(userrepository.existsByUsername(Mockito.any(String.class))).thenReturn(false);
		Mockito.when(userrepository.findByUsername(Mockito.any(String.class))).thenReturn(null);
		
		User result = service.login(userDTO);
		
		
		//Then
		assertThat(result).isEqualTo(null); 
		
		
	}
	
	/**
	 * The tset method is based on the assumption that user exists but password does not match. 
	 * Thus, UserRepository existByUsername returns User object with different password. 
	 */
	
	//Username exists but password does not match
	@Test
	public void testLoginPassFail() {
		//Given 
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername("test-username");
		userDTO.setPassword("test-password---");
		User user = new User("1","test-username","test-password","test-fullname","test-email","test-address");
		
		//When
		Mockito.when(userrepository.existsByUsername(Mockito.any(String.class))).thenReturn(true);
		Mockito.when(userrepository.findByUsername(Mockito.any(String.class))).thenReturn(user);
		
		User result = service.login(userDTO);
		
		
		//Then 
		
		assertThat(result).isEqualTo(null); 
		
		
	}
	/**
	 * The  Userrepository save method is mocked as to return User Object. The sercice method returns the user object. 
	 */
	@Test
	public void testSaveUser() {
		//Given
		User savedUser = new User("1","test-username","test-password","test-fullname","test-email","test-address");
		User newUser = new User(null,"test-username","test-password","test-fullname","test-email","test-address");
		
		//When 
		Mockito.when(userrepository.save(Mockito.any(User.class))).thenReturn(savedUser);
		User result = service.saveUser(newUser);
		
		
		//Then
		assert(result).equals(savedUser);
		
	}
	
	/**
	 * The user with the checked username is found. The UserRepository findByUsername object is mocked as to return User Object.  
	 * The method successfully returns the User object. 
	 */
	
	//User is found
	@Test
	public void testGetUserByUsername() {
		//Given 
		User savedUser = new User("1","test-username","test-password","test-fullname","test-email","test-address");
		String username = "test-username";
		
		//When
		Mockito.when(userrepository.findByUsername(Mockito.any(String.class))).thenReturn(savedUser);
		User result = service.getUserByUsername(username);
		
		//Then 
		
		assert(result).equals(savedUser);
	}
	
	/**
	 * The test case is user not found in ther database. the UserRepository findByUsername method returns null, thus the service method also returns null. 
	 */
	
	//User is not found
	@Test
	public void testGetUserByUsernameNull() {
		//Given 
		String username = "test-username";
		
		//When 
		Mockito.when(userrepository.findByUsername(Mockito.any(String.class))).thenReturn(null);
		User result = service.getUserByUsername(username);
		
		//Then 
		
		assertThat(result).isNull();
	}
	

}
