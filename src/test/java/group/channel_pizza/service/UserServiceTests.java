package group.channel_pizza.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import channelpizza.model.User;
import channelpizza.model.UserDTO;
import group.channel_pizza.repository.UserRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class UserServiceTests {
	
	@MockBean
	private UserRepository userrepository;
	
	@InjectMocks
	private UserService service;
	
	//Username information is true
	
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
