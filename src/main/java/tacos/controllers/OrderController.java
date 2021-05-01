package tacos.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.Errors;
import lombok.extern.slf4j.Slf4j;
import tacos.model.Order;
import tacos.repositories.OrderRepository;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {
	private OrderRepository orderRepo;
	
	@Autowired
	public OrderController(OrderRepository repo) {
		// TODO Auto-generated constructor stub
		orderRepo = repo;
	}

//	@GetMapping("/current")
//	public String orderForm(@AuthenticationPrincipal User user, 
//		      @ModelAttribute Order order) {
//		if (order.getName() == null) {
//		      order.setName(user.getFullname());
//	    }
//	    if (order.getStreet() == null) {
//	      order.setStreet(user.getStreet());
//	    }
//	    if (order.getCity() == null) {
//	      order.setCity(user.getCity());
//	    }
//	    if (order.getZip() == null) {
//	      order.setZip(user.getZip());
//	    }
//		return "orderForm";
//	}
//	
//	@PostMapping
//	public String proccessOrder(@Validated Order order, Errors errors, SessionStatus sessionStatus,
//			@AuthenticationPrincipal User user) {
//		if (errors.hasErrors()) {
//			return "orderForm";
//		}
//		order.setUser(user);
//		orderRepo.save(order);
//		sessionStatus.setComplete();
//		return "redirect:/";
//	}
	
	@GetMapping("/readyOrder")
	public String getOrder(Model model) {
	    log.info("Processing design: " + orderRepo.count());
		model.addAttribute("orders",orderRepo.findAll());
		return "info";
	}
	@GetMapping("/all")
	public Iterable<Order> getOrders() {
	    return orderRepo.findAll();
	}
}
