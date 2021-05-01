package tacos.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tacos.model.Ingredient;
import tacos.repositories.IngredientRepository;

@Service
public class IngredientServiceImpl implements IIngriedientService {
	
	@Autowired
	private IngredientRepository ingredientRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Ingredient save(Ingredient ingredient) {
		if (ingredient != null) {
			return ingredientRepository.save(ingredient);
		}
		else return null;
	}

	@Override
	@Transactional
	public void delete(long id) {
		ingredientRepository.deleteById(id);
	}

	@Override
	@Transactional
	public Ingredient update(Ingredient ingredient) {
		if (ingredient != null) {
			return ingredientRepository.save(ingredient);
		}
		else return null;
	}

	@Override
	public Ingredient getIngredient(long id) {
		if (ingredientRepository.existsById(id)) {
			return ingredientRepository.findById(id).get();
		} 
		return null;
	}

	@Override
	public Iterable<Ingredient> getIngredients() {
		return ingredientRepository.findAll();
	}
	
	@Override
	public boolean existsById(long id) {
		return ingredientRepository.existsById(id);
	}

}
