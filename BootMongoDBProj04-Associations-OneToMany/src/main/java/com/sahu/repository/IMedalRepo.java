package com.sahu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sahu.document.Medal;

public interface IMedalRepo extends MongoRepository<Medal, String> {

}
