package tacos.services;

import tacos.model.Order;

public interface IOrderService {
	Order save(Order order);
	Order getOrder(long id);
	Iterable<Order> getOrders();
	Order update(Order order);
	void delete(long id);
	boolean isExists(long id);
	boolean areTacosExist(Order order);
}
