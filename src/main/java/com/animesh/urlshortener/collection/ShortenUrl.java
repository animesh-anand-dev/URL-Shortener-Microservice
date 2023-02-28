package com.animesh.urlshortener.collection;

//*** A Simple POJO Class to return Shorten URL as a JSON object ***

public class ShortenUrl {
	
	private String shortenUrl;

	public ShortenUrl() {
		super();
	}

	public ShortenUrl(String shortenUrl) {
		super();
		this.shortenUrl = shortenUrl;
	}

	public String getShortenUrl() {
		return shortenUrl;
	}

	public void setShortenUrl(String shortenUrl) {
		this.shortenUrl = shortenUrl;
	}

	@Override
	public String toString() {
		return "ShortenUrl [shortenUrl=" + shortenUrl + "]";
	}
	

}
