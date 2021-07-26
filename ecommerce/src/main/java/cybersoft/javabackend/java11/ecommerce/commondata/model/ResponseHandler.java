package cybersoft.javabackend.java11.ecommerce.commondata.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import cybersoft.javabackend.java11.ecommerce.utils.ErrorUtils;
import cybersoft.javabackend.java11.ecommerce.utils.ListUtils;

public class ResponseHandler {
	public static ResponseEntity<Object> getResponse(Object content, HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		map.put("content", content);
		map.put("message", ListUtils.emptyStringList);
		map.put("status", status.value());
		
		return new ResponseEntity<>(map, status);
	}
	
	public static ResponseEntity<Object> getResponse(BindingResult bindingResult, HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		map.put("content", ListUtils.emptyStringList);
		map.put("message", ErrorUtils.getErrorMessages(bindingResult));
		map.put("status", status.value());
		
		return new ResponseEntity<>(map, status);
	}
	
	public static ResponseEntity<Object> getResponse(String error, HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		map.put("content", ListUtils.emptyStringList);
		map.put("message", ErrorUtils.errorOf(error));
		map.put("status", status.value());
		
		return new ResponseEntity<>(map, status);
	}
	
	public static ResponseEntity<Object> getResponse(HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		map.put("content", ListUtils.emptyStringList);
		map.put("message", ListUtils.emptyStringList);
		map.put("status", status.value());
		
		return new ResponseEntity<>(map, status);
	}
}
