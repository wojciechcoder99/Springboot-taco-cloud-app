package tacos.controllers;

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

import tacos.model.Ingredient;
import tacos.model.Taco;
import tacos.services.ITacoService;

@RestController
@RequestMapping("/api/taco")
public class DesignTacoController {
	
	private ITacoService tacoService;
	
	@Autowired
	public DesignTacoController(ITacoService tacoService) {
		this.tacoService = tacoService;
	}
	
	@GetMapping
	public @ResponseBody ResponseEntity<Iterable<Taco>> getTacos(){
		return new ResponseEntity<Iterable<Taco>>(tacoService.getTacos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Taco> getTaco(@PathVariable long id){
		if (tacoService.isExists(id)) {
			return new ResponseEntity<Taco>(tacoService.getTaco(id), HttpStatus.OK);
		}
		else return new ResponseEntity<Taco>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public @ResponseBody ResponseEntity<Taco> createTaco(@RequestBody Taco taco) {
		if (tacoService.areIngredientsExist(taco)) {
			return new ResponseEntity<Taco>(tacoService.save(taco), HttpStatus.CREATED);
		}
		else return new ResponseEntity<Taco>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping
	public @ResponseBody ResponseEntity<Taco> updateTaco(@RequestBody Taco taco){
			if (taco != null && tacoService.areIngredientsExist(taco)) {
				return new ResponseEntity<Taco>(tacoService.update(taco), HttpStatus.OK);
			}
			else return new ResponseEntity<Taco>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Ingredient> deleteTaco(@PathVariable long id){
		if (tacoService.isExists(id)) {
			tacoService.delete(id);
			return new ResponseEntity<Ingredient>(HttpStatus.OK);
		}
		else return new ResponseEntity<Ingredient>(HttpStatus.NO_CONTENT);
	}

	
	
	 
}
