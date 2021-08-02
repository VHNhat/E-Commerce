package cybersoft.javabackend.java11.ecommerce.product.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java11.ecommerce.commondata.GenericServiceImpl;
import cybersoft.javabackend.java11.ecommerce.product.dto.CreateProductDto;
import cybersoft.javabackend.java11.ecommerce.product.dto.UpdateProductDto;
import cybersoft.javabackend.java11.ecommerce.product.model.Product;
import cybersoft.javabackend.java11.ecommerce.product.repository.ProductRepository;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, Long> implements ProductService {
	@Autowired
	private ProductRepository repo;
	@Override
	public Product save(@Valid CreateProductDto dto) {
		Product product = new Product();
		product.name(dto.getName())
				.description(dto.getDescription())
				.sku(dto.getSku())
				.unitsInStock(dto.getUnitsInStock())
				.productType(dto.getProductType());
		return repo.save(product);
	}
	@Override
	public Product update(@Valid UpdateProductDto dto, Long id) {
		if(!repo.findById(id).isPresent())
			return null;
		
		Product product = repo.getOne(id);
		product.name(dto.getName())
				.description(dto.getDescription())
				.unitsInStock(dto.getUnitsInStock())
				.sku(dto.getSku())
				.productType(dto.getProductType());
		return repo.save(product);
	}

}
