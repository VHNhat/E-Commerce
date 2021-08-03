package cybersoft.javabackend.java11.ecommerce.customer.service;


import javax.validation.Valid;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.java11.ecommerce.commondata.GenericServiceImpl;
import cybersoft.javabackend.java11.ecommerce.customer.dto.CreateCustomerDto;
import cybersoft.javabackend.java11.ecommerce.customer.dto.UpdateCustomerDto;
import cybersoft.javabackend.java11.ecommerce.customer.model.Customer;
import cybersoft.javabackend.java11.ecommerce.customer.repository.CustomerRepository;
import cybersoft.javabackend.java11.ecommerce.utils.MapDtoToModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerServiceImpl extends GenericServiceImpl<Customer, Long> implements CustomerService {
	private CustomerRepository repository;
	private MapDtoToModel<Object, Customer> mapper;
	
	
	@Override
	public Customer save(@Valid CreateCustomerDto dto) {
		Customer customer = new Customer();
		customer = mapper.map(dto, customer);
		
		return repository.save(customer);
	}

	@Override
	public Customer update(@Valid UpdateCustomerDto dto, Long id) {	
		Customer customer = repository.getOne(id);
		customer = mapper.map(dto, customer);
		
		return repository.save(customer);
	}

}
