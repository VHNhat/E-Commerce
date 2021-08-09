package cybersoft.javabackend.java11.ecommerce.product.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import cybersoft.javabackend.java11.ecommerce.product.model.ProductType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDto {
	@NotBlank(message = "{product.name.not-blank}")
	@Size(min=3,max=100,message = "{product.name.size}")
	private String name;
	@NotBlank
	private String description;
	
	@NotBlank
	private String image;
	
	@NotNull
	private int price;
	
	@NotNull
	private int unitsInStock;
	
	private String sku;
	@NotNull
	private Long productTypeId;
}
