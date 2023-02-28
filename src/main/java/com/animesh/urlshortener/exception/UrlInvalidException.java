package com.animesh.urlshortener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class UrlInvalidException extends RuntimeException{
	
	public UrlInvalidException(String message) {
		super(message);
	}
}
