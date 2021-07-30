package cybersoft.javabackend.java11.ecommerce.customer.service;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java11.ecommerce.commondata.GenericServiceImpl;
import cybersoft.javabackend.java11.ecommerce.customer.dto.CreateCustomerDto;
import cybersoft.javabackend.java11.ecommerce.customer.dto.UpdateCustomerDto;
import cybersoft.javabackend.java11.ecommerce.customer.model.Customer;
import cybersoft.javabackend.java11.ecommerce.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl extends GenericServiceImpl<Customer, Long> implements CustomerService {
	@Autowired
	private CustomerRepository repository;
	@Override
	public Customer save(@Valid CreateCustomerDto dto) {
		Customer customer = new Customer();
		customer.username(dto.getUsername())
				.password(dto.getPassword())
				.email(dto.getEmail())
				.fullname(dto.getFullName())
				.displayName(dto.getDisplayName())
				.phone(dto.getPhone())
				.gender(dto.getGender())
				.address(dto.getAddress());
		return repository.save(customer);
	}

	@Override
	public Customer update(@Valid UpdateCustomerDto dto, Long id) {	
		if(!repository.findById(id).isPresent())
			return null;
		
		Customer updatedCustomer = new Customer();
		String currentUsername = repository.getOne(id).getUsername();
		repository.deleteById(id);
		updatedCustomer.setId(id);
		updatedCustomer	.username(currentUsername)
						.password(dto.getNewPassword())
						.email(dto.getEmail())
						.fullname(dto.getFullName())
						.displayName(dto.getDisplayName())
						.phone(dto.getPhone())
						.gender(dto.getGender())
						.address(dto.getAddress());
		return repository.save(updatedCustomer);
	}

}
