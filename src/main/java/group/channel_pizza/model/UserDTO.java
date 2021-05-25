package group.channel_pizza.model;
/**
 * 
 * Entity is used only for the login method in UserController
 * Please see the {@link group.channel_pizza.rest.UserController} class for reference
 * 
 * @author Enis Sinan Reyhan
 *
 */
public class UserDTO {
	//fields 
	private String username;
	private String password;
	
	//getters and setters 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
