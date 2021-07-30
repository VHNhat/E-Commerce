package cybersoft.javabackend.java11.ecommerce.commondata;

import java.util.List;
import java.util.Optional;

import cybersoft.javabackend.java11.ecommerce.commondata.model.AbstractEntity;

public interface GenericService<T extends AbstractEntity, ID> {
	List<T> findAll();
	Optional<T> findbyId(ID id);
	T save(T entity);
	T update(T entity);
	void deleteById(ID id);
}
