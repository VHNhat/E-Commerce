package cybersoft.javabackend.java11.ecommerce.customer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java11.ecommerce.commondata.model.ResponseHandler;
import cybersoft.javabackend.java11.ecommerce.customer.dto.CreateCustomerDto;
import cybersoft.javabackend.java11.ecommerce.customer.dto.UpdateCustomerDto;
import cybersoft.javabackend.java11.ecommerce.customer.model.Customer;
import cybersoft.javabackend.java11.ecommerce.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService service;
	
	@GetMapping("")
	public ResponseEntity<Object> findAllCustomer(){
		List<Customer> customers = service.findAll();
		
		if(customers.isEmpty())
			return ResponseHandler.getResponse("There is no data.", HttpStatus.OK);
		return ResponseHandler.getResponse(customers, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> addCustomer(@Valid @RequestBody CreateCustomerDto dto, BindingResult error){
		if(error.hasErrors())
			return ResponseHandler.getResponse(error, HttpStatus.BAD_REQUEST);
		
		Customer newCustomer = service.save(dto);
		
		return ResponseHandler.getResponse(newCustomer, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{customer-id}")
	public ResponseEntity<Object> updateCustomer(@PathVariable("customer-id") Long id, @Valid @RequestBody UpdateCustomerDto dto, BindingResult error){
		if(error.hasErrors())
			return ResponseHandler.getResponse(error, HttpStatus.BAD_REQUEST);
		
		if(id == null)
			return ResponseHandler.getResponse("id is null", HttpStatus.BAD_REQUEST);
		
		Customer customer = service.update(dto, id);
		
		return ResponseHandler.getResponse(customer, HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{customer-id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable("customer-id") Long id){
		if(id == null)
			return ResponseHandler.getResponse("id is null", HttpStatus.BAD_REQUEST);
		
		service.deleteById(id);
		
		return ResponseHandler.getResponse("Customer has been deleted!", HttpStatus.OK);
	}
}
