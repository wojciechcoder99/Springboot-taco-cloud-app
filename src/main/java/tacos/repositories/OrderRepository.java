package tacos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tacos.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
//	Order save(Order order);
}
