package cybersoft.javabackend.java11.ecommerce.product.dto;

import javax.validation.constraints.Size;


import cybersoft.javabackend.java11.ecommerce.product.model.ProductType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductDto {
	
	@Size(min=3,max=100,message = "{product.name.size}")
	private String name;

	private String description;
	
	private long price;

	private int unitsInStock;

	private String sku;

	private Long productTypeId;
}
