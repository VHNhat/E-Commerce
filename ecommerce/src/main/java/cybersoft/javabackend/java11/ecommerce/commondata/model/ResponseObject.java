package cybersoft.javabackend.java11.ecommerce.commondata.model;

import java.time.LocalDateTime;
import java.util.List;

import cybersoft.javabackend.java11.ecommerce.utils.DateUtils;
import cybersoft.javabackend.java11.ecommerce.utils.ListUtils;


public class ResponseObject {
	private Object content;
	private List<String> errorMessages;
	private String responseTime = DateUtils.toString(LocalDateTime.now());
	
	public ResponseObject(Object content) {
		this.content = content;
		this.errorMessages = ListUtils.emptyStringList;
	}
	
	public ResponseObject(List<String> errorMessages) {
		this.errorMessages = errorMessages;
		this.content = ListUtils.emptyStringList;
	}
	
	
	public ResponseObject content(Object content) {
		this.content = content;
		return this;
	}
	
	public ResponseObject errorMessages(List<String> messages) {
		this.errorMessages = messages;
		return this;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}
	
	
}
