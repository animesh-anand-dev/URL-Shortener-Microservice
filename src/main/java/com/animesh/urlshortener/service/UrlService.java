package com.animesh.urlshortener.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.animesh.urlshortener.collection.Url;
import com.animesh.urlshortener.repository.UrlRepository;

// A Service class where UrlRepository and MongoTemplate are used to perform the CRUD operations and returns the respective data.

@Service
public class UrlService {

	@Autowired
	private UrlRepository urlRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public Url save(Url url) {
		return urlRepository.save(url);
	}
	
	public List<Url> getAllUrls(){
		System.out.println(urlRepository.findAll());
		return urlRepository.findAll();
	}

	public Optional<Url> getByKey(String id) {
		return urlRepository.findById(id);
	}

	public void saveOnlyCount(Integer count, String id) {
		Query queryToFind = new Query(Criteria.where("_id").is(id));
		Update updateCount = new Update();
		updateCount.set("linkRedirectionCount", count);
		mongoTemplate.updateFirst(queryToFind, updateCount, Url.class);
	}

	public Optional<Url> getByUniqueKey(String id) {
		return urlRepository.findById(id);
	}

}
