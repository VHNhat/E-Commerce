package cybersoft.javabackend.java11.ecommerce.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java11.ecommerce.commondata.model.ResponseHandler;
import cybersoft.javabackend.java11.ecommerce.product.dto.CreateProductDto;
import cybersoft.javabackend.java11.ecommerce.product.dto.UpdateProductDto;
import cybersoft.javabackend.java11.ecommerce.product.model.Product;
import cybersoft.javabackend.java11.ecommerce.product.service.ProductService;

@Controller
//@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService service;
	
	@GetMapping("")
	public ResponseEntity<Object> findAllProducts(){
		List<Product> products = service.findAll();
		
		if(products.isEmpty())
			return ResponseHandler.getResponse("there is no data", HttpStatus.OK);
		return ResponseHandler.getResponse(products, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> addProduct(@Valid @RequestBody CreateProductDto dto, BindingResult error){
		if(error.hasErrors())
			return ResponseHandler.getResponse(error, HttpStatus.BAD_REQUEST);
		
		Product product = service.save(dto);
		return ResponseHandler.getResponse(product, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{product-id}")
	public ResponseEntity<Object> updateProduct(@PathVariable("product-id") Long id,@Valid @RequestBody UpdateProductDto dto, BindingResult error){
		if(id == null)
			return ResponseHandler.getResponse("id is null!", HttpStatus.BAD_REQUEST);
		if(error.hasErrors())
			return ResponseHandler.getResponse(error, HttpStatus.BAD_REQUEST);
		
		Product product = service.update(dto, id);
		return ResponseHandler.getResponse(product, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{product-id}")
	public ResponseEntity<Object> removeProduct(@PathVariable("product-id") Long id){
		if(id==null)
			return ResponseHandler.getResponse("Id is null!", HttpStatus.BAD_REQUEST);
		service.deleteById(id);
		return ResponseHandler.getResponse("Product has been deleted!", HttpStatus.OK);
	}
	
	
//	@GetMapping("")
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String showProductPage(Model model) {
		List<Product> products = service.findAll();
		model.addAttribute("products", products);
		
		return "home";
	}
	
}
