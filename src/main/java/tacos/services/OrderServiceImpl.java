package tacos.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tacos.model.Order;
import tacos.model.Taco;
import tacos.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private OrderRepository OrderRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Order save(Order order) {
		if (order != null) {
			return OrderRepository.save(order);
		}
		return null;
	}

	@Override
	public Order getOrder(long id) {
		return OrderRepository.findById(id).get();
	}

	@Override
	public Iterable<Order> getOrders() {
		return OrderRepository.findAll();
	}

	@Override
	@Transactional
	public Order update(Order Order) {
		if (Order != null) {
			return OrderRepository.save(Order);
		}
		return null;
	}

	@Override
	@Transactional
	public void delete(long id) {
		OrderRepository.deleteById(id);
	}
	
	@Override
	public boolean isExists(long id) {
		return OrderRepository.existsById(id);
	}
	
	@Override
	public boolean areTacosExist(Order order) {
		return order.getTacos().stream()
				.allMatch(taco -> OrderRepository.existsById(taco.getId()) == true);
	}
	

}
