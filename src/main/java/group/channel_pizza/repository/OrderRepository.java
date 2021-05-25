package group.channel_pizza.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import group.channel_pizza.model.Order;

/**
 * Repository for item entity Order
 * 
 *  Used by class OrderService:
 *  Please see {@link group.channel_pizza.service.OrderService} class
 * 
 * @author Enis Sinan Reyhan
 *
 */

public interface OrderRepository extends MongoRepository<Order,String> {

}
