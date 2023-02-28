package com.animesh.urlshortener.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.animesh.urlshortener.collection.OriginalUrl;
import com.animesh.urlshortener.collection.ShortenUrl;
import com.animesh.urlshortener.collection.Url;
import com.animesh.urlshortener.exception.UrlInvalidException;
import com.animesh.urlshortener.exception.UrlNotFoundException;
import com.animesh.urlshortener.repository.UrlRepository;
import com.animesh.urlshortener.service.UrlService;
import com.google.common.hash.Hashing;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//CORS stands for Cross-Origin Resource Sharing, 
//and is a mechanism that allows resources on a web page to be requested from another domain outside their own domain.

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class UrlController {

	@Autowired
	private UrlService urlService;
	
	@Autowired
	private UrlRepository urlRepository;
	
	// This method accepts the POST request from client slide and save the Original URL and returns the Shorten URL
	@PostMapping("/urls")
	public ResponseEntity<Object> save(@RequestBody OriginalUrl originalUrl, HttpServletRequest request) {
		
		UrlValidator urlValidator = new UrlValidator();
	
        if (!urlValidator.isValid(originalUrl.getOriginalUrl())) {
        	throw new UrlInvalidException("Invalid Url");
        }
	    
        // Generate the hash by providing the Original Url
        String key = Hashing.murmur3_32_fixed().hashString(originalUrl.getOriginalUrl(), StandardCharsets.UTF_8).toString();
		LocalDateTime dateTime = LocalDateTime.now();
		
		Url savedUrl = urlService.save(new Url(key, originalUrl.getOriginalUrl(), 0, dateTime));
		
		// WebMvcLinkBuilder is the class that helps to built link from the methods
		// Here it will create a link with unique id i.e, Shorten URL
		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).redirectToOriginalUrl(null, savedUrl.getUrlUniqueId()));
    
    	return ResponseEntity.status(201).body(new ShortenUrl(link.toString()));
				
	}

	// This methods accepts the Unique Id as path variable and returns the details of the Shorten URL provided by the client like 
	// Unique Id, Original Url, Link Redirection Count, Link Generation Date, Shorten Link
	@GetMapping("/{id}/details")
	public EntityModel<Url> retrieveUrlDetails(@PathVariable String id) {
		Optional<Url> urlDetails = urlService.getByKey(id);
		
		if(urlDetails.isEmpty())
			throw new UrlNotFoundException("Url Does Not Exists with this id: " +id);
		
		EntityModel<Url> entityModel = EntityModel.of(urlDetails.get());
	
		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).redirectToOriginalUrl(null, id));
		
		entityModel.add(link.withRel("shortenUrl"));
		
		return entityModel;
	}
	
	
	//This method accepts the Unique Id as path variable and redirect it to the Original URL mapped with it
	@GetMapping("/{id}")
	public ResponseEntity<Object> redirectToOriginalUrl(HttpServletResponse response,@PathVariable String id){

		try {
			Optional<Url> urlNew = urlService.getByKey(id);
			Integer count = urlNew.get().getLinkRedirectionCount();
			count++;
			urlService.saveOnlyCount(count,id);
			response.sendRedirect(urlNew.get().getOriginalUrl());
		} catch (Exception e) {
			throw new UrlNotFoundException("Url not Found for Redirection");
		}
		return null;
	}
	
	// This method list all the URL present in our database
	@GetMapping("/urls")
	public List<Url> retreiveAllUrls(HttpServletRequest request){
		return urlRepository.findAll();
	}

}
