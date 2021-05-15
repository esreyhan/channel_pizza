package group.channel_pizza.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import channelpizza.model.User;



public interface UserRepository  extends MongoRepository<User,Integer>{
	
	public User findByUsername(String username);
	public Boolean existsByUsername(String username);
	public Boolean existsByEmail(String email);
	

}
