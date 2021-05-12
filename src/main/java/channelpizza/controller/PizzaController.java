package channelpizza.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import channelpizza.model.Pizza;
import channelpizza.repository.PizzaRepository;
/*
@RestController
public class PizzaController {
	/*
	@Autowired
	private  PizzaRepository pizzarepository;
	
	@PostMapping("/addPizza")
	public String savePizza(@RequestBody Pizza pizza) {
		pizzarepository.save(pizza);
		return "Added pizza with id : " + pizza.getId();
	}
	
	@GetMapping("/findAllPizzas") 
	public List<Pizza> getPizzas (Pizza pizza) {
		
		return pizzarepository.findAll();
		
	}
	
	@GetMapping("/findPizzaById/{id}")
	public Optional<Pizza> getPizza (@PathVariable int id) {
		
		return pizzarepository.findById(id);
		
	}

	
	
	
	
	
	
}*/
