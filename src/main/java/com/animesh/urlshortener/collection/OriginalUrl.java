package com.animesh.urlshortener.collection;

//*** A Simple POJO Class to accept Original Url as a JSON object ***

public class OriginalUrl {
	
	private String originalUrl;

	public OriginalUrl() {
		super();
	}

	public OriginalUrl(String originalUrl) {
		super();
		this.originalUrl = originalUrl;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	@Override
	public String toString() {
		return "OriginalUrl [originalUrl=" + originalUrl + "]";
	}
	
}
