package tacos.controllers;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mysql.cj.log.Log;

import lombok.extern.slf4j.Slf4j;
import tacos.model.Ingredient;
import tacos.model.Order;
import tacos.model.Taco;
import tacos.model.Ingredient.Type;
import tacos.repositories.IngredientRepository;
import tacos.repositories.TacoRepository;
import tacos.services.IIngriedientService;
import tacos.services.ITacoService;

@RestController
@RequestMapping("/api/taco")
public class DesignTacoController {
	
	private ITacoService iTacoService;
	private IIngriedientService ingredientService;
	
	@Autowired
	public DesignTacoController(ITacoService iTacoService, IIngriedientService ingredientService) {
		this.iTacoService = iTacoService;
		this.ingredientService = ingredientService;
	}
	
	@GetMapping
	public @ResponseBody ResponseEntity<Iterable<Taco>> getTacos(){
		return new ResponseEntity<Iterable<Taco>>(iTacoService.getTacos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Taco> getTaco(@PathVariable long id){
		if (iTacoService.isExists(id)) {
			return new ResponseEntity<Taco>(iTacoService.getTaco(id), HttpStatus.OK);
		}
		else return new ResponseEntity<Taco>(HttpStatus.NOT_FOUND);
	}
	
//	@PostMapping
//	public @ResponseBody ResponseEntity<Ingredient> getTaco(@RequestBody String name){
//		
//	}
	
	
	 
}
