package tacos.services;

import org.springframework.stereotype.Service;

import tacos.model.Taco;

@Service
public interface ITacoService {
	 Taco save(Taco taco);
	 Taco getTaco(long id);
	 Iterable<Taco> getTacos();
	 Taco update(Taco taco);
	 void delete(long id);
	 boolean isExists(long id);
	 boolean areIngredientsExist(Taco taco);
	

}
