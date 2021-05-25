package group.channel_pizza.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import group.channel_pizza.model.Item;
/**
 * Repository for item entity item
 * 
 *  Used by class ItemService
 *  Please see {@link group.channel_pizza.service.ItemService} class
 * 
 * @author Enis Sinan Reyhan
 *
 */

public interface ItemRepository extends MongoRepository<Item, String> {

}
