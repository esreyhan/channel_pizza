package group.channel_pizza.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import channelpizza.model.User;



public interface UserRepository  extends MongoRepository<User,Integer>{

}
