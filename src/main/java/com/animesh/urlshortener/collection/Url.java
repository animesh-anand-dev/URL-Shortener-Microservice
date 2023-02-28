package com.animesh.urlshortener.collection;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

// *** A Simple POJO Class for mapping object to the MongoDB database ***

@Document(collection="url")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Url {

	@Id
	private String urlUniqueId;
	private String originalUrl;
	private Integer linkRedirectionCount;
	private LocalDateTime generationDate;
	
	public Url() {
		super();
	}
	
	public Url(String urlUniqueId, String originalUrl, Integer linkRedirectionCount, LocalDateTime generationDate) {
		super();
		this.urlUniqueId = urlUniqueId;
		this.originalUrl = originalUrl;
		this.linkRedirectionCount = linkRedirectionCount;
		this.generationDate = generationDate;
	}
	
	public String getUrlUniqueId() {
		return urlUniqueId;
	}
	public void setUrlUniqueId(String urlUniqueId) {
		this.urlUniqueId = urlUniqueId;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public Integer getLinkRedirectionCount() {
		return linkRedirectionCount;
	}
	public void setLinkRedirectionCount(Integer linkRedirectionCount) {
		this.linkRedirectionCount = linkRedirectionCount;
	}
	public LocalDateTime getGenerationDate() {
		return generationDate;
	}
	public void setGenerationDate(LocalDateTime generationDate) {
		this.generationDate = generationDate;
	}
	@Override
	public String toString() {
		return "Url [urlUniqueId=" + urlUniqueId + ", originalUrl=" + originalUrl + ", linkRedirectionCount="
				+ linkRedirectionCount + ", generationDate=" + generationDate + "]";
	}

}
