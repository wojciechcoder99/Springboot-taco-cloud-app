package tacos.controllers;

import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.el.stream.Stream;

import tacos.CommonProperties;
import tacos.model.Ingredient;
import tacos.services.IIngriedientService;

@RestController
@RequestMapping("api/ingredients")
public class IngredientController {
	
	private IIngriedientService ingriedientService;
	
	@Autowired
	public IngredientController(IIngriedientService ingriedientService) {
		this.ingriedientService = ingriedientService;
	}
	
	@GetMapping
	public @ResponseBody ResponseEntity<Iterable<Ingredient>> getIngredients(){
		return new ResponseEntity<Iterable<Ingredient>>(ingriedientService.getIngredients(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Ingredient> getIngredient(@PathVariable long id){
		Ingredient ingredient = ingriedientService.getIngredient(id);
		if (ingredient != null) {
			return new ResponseEntity<Ingredient>(ingredient, HttpStatus.OK);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public @ResponseBody ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient){
		if (ingredient != null) {
			return new ResponseEntity<Ingredient>(ingriedientService.save(ingredient),
					CommonProperties.buildHeaderLocation(ingredient.getId(),CommonProperties.POST_ENDPOINT_HEADER),HttpStatus.CREATED);
		}
		else return new ResponseEntity<Ingredient>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping
	public @ResponseBody ResponseEntity<Ingredient> updateIngredient( 
			@RequestBody Ingredient ingredient){
			if (ingredient != null) {
				return new ResponseEntity<Ingredient>(ingriedientService.update(ingredient), HttpStatus.OK);
			}
			else return new ResponseEntity<Ingredient>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Ingredient> deleteIngredient(@PathVariable long id){
		Ingredient ingredient = ingriedientService.getIngredient(id);
		if (ingredient != null) {
			ingriedientService.delete(id);
			return new ResponseEntity<Ingredient>(HttpStatus.OK);
		}
		else return new ResponseEntity<Ingredient>(HttpStatus.NOT_FOUND);
	}

}
