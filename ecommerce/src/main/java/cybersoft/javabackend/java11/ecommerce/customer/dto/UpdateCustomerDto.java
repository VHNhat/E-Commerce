package cybersoft.javabackend.java11.ecommerce.customer.dto;



import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCustomerDto {

	@JsonIgnore
	private String username;
	
	private String currentPassword;
	
	private String newPassword;
	
	private String email;
	
	private String fullName;
	
	private String displayName;
	
	private int gender;
	
	private String phone;
	
	private String address;
}
