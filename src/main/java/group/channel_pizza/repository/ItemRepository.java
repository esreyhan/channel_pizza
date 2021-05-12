package group.channel_pizza.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import channelpizza.model.Item;


public interface ItemRepository extends MongoRepository<Item, String> {

}
