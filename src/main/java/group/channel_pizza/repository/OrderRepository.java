package group.channel_pizza.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import channelpizza.model.Order;



public interface OrderRepository extends MongoRepository<Order,String> {

}
