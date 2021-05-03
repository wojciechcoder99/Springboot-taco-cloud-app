package tacos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import tacos.model.Ingredient;
import tacos.model.Order;
import tacos.services.IOrderService;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {
	
	private IOrderService orderService;
	
	@Autowired
	public OrderController(IOrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping
	public @ResponseBody ResponseEntity<Iterable<Order>> getOrders(){
		return new ResponseEntity<Iterable<Order>>(orderService.getOrders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Order> getOrder(@PathVariable long id){
		if (orderService.isExists(id)) {
			return new ResponseEntity<Order>(orderService.getOrder(id), HttpStatus.OK);
		}
		else return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public @ResponseBody ResponseEntity<Order> createOrder(@RequestBody Order Order) {
		if (orderService.areTacosExist(Order)) {
			return new ResponseEntity<Order>(orderService.save(Order), HttpStatus.CREATED);
		}
		else return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping
	public @ResponseBody ResponseEntity<Order> updateOrder(@RequestBody Order Order){
			if (Order != null && orderService.areTacosExist(Order)) {
				return new ResponseEntity<Order>(orderService.update(Order), HttpStatus.OK);
			}
			else return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Ingredient> deleteOrder(@PathVariable long id){
		if (orderService.isExists(id)) {
			orderService.delete(id);
			return new ResponseEntity<Ingredient>(HttpStatus.OK);
		}
		else return new ResponseEntity<Ingredient>(HttpStatus.NO_CONTENT);
	}
}
