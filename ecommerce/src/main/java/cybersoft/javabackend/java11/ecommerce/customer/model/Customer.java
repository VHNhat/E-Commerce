package cybersoft.javabackend.java11.ecommerce.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.javabackend.java11.ecommerce.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ecommerce_customer")
public class Customer extends AbstractEntity {
	@NotBlank(message = "{customer.password.not-blank}")
	@Size(min = 8, max = 100, message = "{customer.password.size}")
	private String password;
	
	@NotBlank(message = "{customer.email.not-blank}")
	@Email
	@Column(unique = true)
	private String email;
	
	@NotBlank
	private String displayName;
	
	private int gender;
	
	@NotBlank
	private String phone;
	
	@NotBlank
	private String address;
	
	private String avatar;
	private String facebookUrl;

	public Customer password(String password) {
		this.password = password;
		return this;
	}
	public Customer email(String email) {
		this.email = email;
		return this;
	}

	public Customer displayName(String displayName) {
		this.displayName = displayName;
		return this;
	}
	public Customer gender(int gender) {
		this.gender = gender;
		return this;
	}
	public Customer phone(String phone) {
		this.phone = phone;
		return this;
	}
	public Customer address(String address) {
		this.address = address;
		return this;
	}
}
