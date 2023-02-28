package com.animesh.urlshortener.exception;

import java.time.LocalDateTime;

// A simple POJO class to return the Error Details as a JSON object 

public class ErrorDetails {
	
	private LocalDateTime timestamp;
	private String message;
	private String description;
	
	public ErrorDetails(LocalDateTime timestamp, String message, String description) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
