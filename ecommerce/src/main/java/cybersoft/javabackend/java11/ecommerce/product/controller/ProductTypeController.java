package cybersoft.javabackend.java11.ecommerce.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java11.ecommerce.commondata.model.ResponseHandler;
import cybersoft.javabackend.java11.ecommerce.product.model.ProductType;
import cybersoft.javabackend.java11.ecommerce.product.service.ProductTypeService;

@RestController
@RequestMapping("/product/type")
public class ProductTypeController {
	@Autowired
	private ProductTypeService service;
	
	@GetMapping("")
	public ResponseEntity<Object> findAllProductType(){
		List<ProductType> types = service.findAll();
		
		if (types.isEmpty())
			return ResponseHandler.getResponse("There is no data", HttpStatus.OK);
		
		return ResponseHandler.getResponse(types, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> addProductType(@Valid @RequestBody ProductType type, BindingResult error){
		if(error.hasErrors())
			return ResponseHandler.getResponse(error, HttpStatus.BAD_REQUEST);
		
		ProductType productType = service.save(type);
		return ResponseHandler.getResponse(productType, HttpStatus.OK);
		
	}
	
}
