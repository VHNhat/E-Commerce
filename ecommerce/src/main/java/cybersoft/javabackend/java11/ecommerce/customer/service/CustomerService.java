package cybersoft.javabackend.java11.ecommerce.customer.service;

import javax.validation.Valid;

import cybersoft.javabackend.java11.ecommerce.commondata.GenericService;
import cybersoft.javabackend.java11.ecommerce.customer.dto.CreateCustomerDto;
import cybersoft.javabackend.java11.ecommerce.customer.dto.UpdateCustomerDto;
import cybersoft.javabackend.java11.ecommerce.customer.model.Customer;

public interface CustomerService extends GenericService<Customer, Long> {

	Customer save(@Valid CreateCustomerDto dto);

	Customer update(@Valid UpdateCustomerDto dto, Long id);

}
