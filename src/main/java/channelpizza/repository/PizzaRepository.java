package channelpizza.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import channelpizza.model.Pizza;

public interface PizzaRepository extends MongoRepository<Pizza, Integer>{

}
