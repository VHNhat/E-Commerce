package cybersoft.javabackend.java11.ecommerce.product.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import cybersoft.javabackend.java11.ecommerce.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ecommerce_product")
public class Product extends AbstractEntity {
	@NotBlank(message = "{product.name.not-blank}")
	@Size(min=3,max=100,message = "{product.name.size}")
	private String name;
	@NotBlank
	private String description;
	
	private String imageUrl;
	@NotBlank
	private int unitsInStock;
	@NotBlank
	private String sku;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	private ProductType productType;
	
	public Product name(String name) {
		this.name = name;
		return this;
	}
	public Product description(String description) {
		this.description = description;
		return this;
	}
	public Product sku(String sku) {
		this.sku = sku;
		return this;
	}
	public Product unitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
		return this;
	}
	public Product productType(ProductType type) {
		this.productType = type;
		return this;
	}
}
