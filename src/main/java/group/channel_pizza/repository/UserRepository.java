package group.channel_pizza.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import group.channel_pizza.model.User;

/**
 * Repository for item entity User
 * 
 *  Used by class UserService
 *  Please see {@link group.channel_pizza.service.UserService} class
 * 
 * @author Enis Sinan Reyhan
 *
 */

public interface UserRepository  extends MongoRepository<User,String>{
	//methods 
	
	/**
	 * <p> The method returns the  User entity </p>
	 * @param username
	 * @return User
	 */
	public User findByUsername(String username);
	
	/**
	 * <p> The method is used to verify whether the user is registered or not  </p>
	 * @param username
	 * @return whether the user is recorded in the collection or not
	 */
	public Boolean existsByUsername(String username);

}
