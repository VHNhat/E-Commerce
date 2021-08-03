package cybersoft.javabackend.java11.ecommerce.product.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.java11.ecommerce.commondata.GenericServiceImpl;
import cybersoft.javabackend.java11.ecommerce.product.dto.CreateProductDto;
import cybersoft.javabackend.java11.ecommerce.product.dto.UpdateProductDto;
import cybersoft.javabackend.java11.ecommerce.product.model.Product;
import cybersoft.javabackend.java11.ecommerce.product.model.ProductType;
import cybersoft.javabackend.java11.ecommerce.product.repository.ProductRepository;
import cybersoft.javabackend.java11.ecommerce.product.repository.ProductTypeRepository;
import cybersoft.javabackend.java11.ecommerce.utils.MapDtoToModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, Long> implements ProductService {
	private ProductRepository repo;
	private MapDtoToModel<Object, Product> mapper;
	private ProductTypeRepository productTypeRepo;
	
	
	@Override
	public Product save(@Valid CreateProductDto dto) {
		Product product = new Product();
		
		product = mapper.map(dto, product);
		
		ProductType type = productTypeRepo.getOne(dto.getProductTypeId());
		product.setProductType(type);
		
		return repo.save(product);
	}
	@Override
	public Product update(@Valid UpdateProductDto dto, Long id) {
		Product product = repo.getOne(id);
		product = mapper.map(dto, product);
		
		ProductType type = productTypeRepo.getOne(dto.getProductTypeId());
		product.setProductType(type);
		
		return repo.save(product);
	}

}
