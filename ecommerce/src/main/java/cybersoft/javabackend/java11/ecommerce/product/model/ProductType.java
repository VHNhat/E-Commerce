package cybersoft.javabackend.java11.ecommerce.product.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.javabackend.java11.ecommerce.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ecommerce_product_type")
public class ProductType extends AbstractEntity {
	@NotBlank(message = "{product-type.name.not-blank}")
	@Size(min=3,max=100,message="{product-type.name.size}")
	@Column(unique = true)
	private String name;
	@NotBlank(message = "{product-type.code.not-blank}")
	@Size(min=3,max=100,message = "{product-type.code.size}")
	@Column(unique = true)
	private String code;
	@NotBlank(message = "{product-type.description.not-blank}")
	private String description;
	
	@OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Product> procducts = new HashSet<>();
}
