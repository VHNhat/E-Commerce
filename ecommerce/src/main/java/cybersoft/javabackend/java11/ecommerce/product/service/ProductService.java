package cybersoft.javabackend.java11.ecommerce.product.service;

import java.util.List;

import javax.validation.Valid;

import cybersoft.javabackend.java11.ecommerce.commondata.GenericService;
import cybersoft.javabackend.java11.ecommerce.product.dto.CreateProductDto;
import cybersoft.javabackend.java11.ecommerce.product.dto.UpdateProductDto;
import cybersoft.javabackend.java11.ecommerce.product.model.Product;

public interface ProductService extends GenericService<Product, Long> {

	Product save(@Valid CreateProductDto dto);

	Product update(@Valid UpdateProductDto dto, Long id);

	List<Product> findByNameContaining(String name);

}
