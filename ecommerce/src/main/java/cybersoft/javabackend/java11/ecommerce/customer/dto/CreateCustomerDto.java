package cybersoft.javabackend.java11.ecommerce.customer.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerDto {
	@NotBlank(message = "{customer.username.not-blank}")
	@Size(min = 3, max = 50, message = "{customer.username.size}")
	@Column(unique = true, name = "username")
	private String username;
	
	@NotBlank(message = "{customer.password.not-blank}")
	@Size(min = 8, max = 100, message = "{customer.password.size}")
	private String password;
	
	@NotBlank
	@Email
	@Column(unique = true)
	private String email;
	
	@NotBlank
	private String fullName;
	
	@NotBlank
	private String displayName;
	
	private int gender;
	
	@NotBlank
	private String phone;
	
	@NotBlank
	private String address;

}
