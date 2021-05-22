package channelpizza.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User {
	
	@Id
	private String id;
	
	@Indexed(unique=true)
	private String username;
	private String password;
	private String fullname;
	private String email;
	private String address;
	
	public User(String id, String username, String password, String fullname, String email, String address) {

		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.address = address;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
		
		


}
