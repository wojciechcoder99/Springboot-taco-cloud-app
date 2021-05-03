package tacos.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tacos.model.Taco;
import tacos.repositories.TacoRepository;

@Service
public class TacoSerivceImpl implements ITacoService {
	
	@Autowired
	private TacoRepository tacoRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Taco save(Taco taco) {
		if (taco != null) {
			return tacoRepository.save(taco);
		}
		return null;
	}

	@Override
	public Taco getTaco(long id) {
		return tacoRepository.findById(id).get();
	}

	@Override
	public Iterable<Taco> getTacos() {
		return tacoRepository.findAll();
	}

	@Override
	@Transactional
	public Taco update(Taco taco) {
		if (taco != null) {
			return tacoRepository.save(taco);
		}
		return null;
	}

	@Override
	@Transactional
	public void delete(long id) {
		tacoRepository.deleteById(id);
	}
	
	@Override
	public boolean isExists(long id) {
		return tacoRepository.existsById(id);
	}

}
