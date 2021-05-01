package tacos.services;

import org.springframework.stereotype.Service;

import tacos.model.Ingredient;

@Service
public interface IIngriedientService {
	 Ingredient save(Ingredient ingredient);
	 void delete(long id);
	 Ingredient update(Ingredient ingredient);
	 Ingredient getIngredient(long id);
	 Iterable<Ingredient> getIngredients();
	 boolean existsById(long id);
	

}
