package tacos.services;

import org.springframework.stereotype.Service;

import tacos.model.Taco;

@Service
public interface ITacoService {
	public Taco save(Taco taco);
	public Taco getTaco(long id);
	public Iterable<Taco> getTacos();
	public Taco update(Taco taco);
	public void delete(long id);

}
