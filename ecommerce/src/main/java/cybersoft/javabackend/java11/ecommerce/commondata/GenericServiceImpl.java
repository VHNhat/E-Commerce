package cybersoft.javabackend.java11.ecommerce.commondata;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java11.ecommerce.commondata.model.AbstractEntity;

@Service
public class GenericServiceImpl<T extends AbstractEntity, ID> implements GenericService<T, ID> {
	@Autowired
	private JpaRepository<T, ID> repository;
	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<T> findbyId(ID id) {
		return repository.findById(id);
	}

	@Override
	public T save(T entity) {
		return repository.save(entity);
	}

	@Override
	public T update(T entity) {
		return repository.save(entity);
	}

	@Override
	public void deleteById(ID id) {
		repository.deleteById(id);
	}

}
