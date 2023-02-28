package com.animesh.urlshortener.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.animesh.urlshortener.collection.Url;

// An interface which extends the MongoRepository to perform the CRUD operations with MongoDB database
public interface UrlRepository extends MongoRepository<Url, String> {


}
