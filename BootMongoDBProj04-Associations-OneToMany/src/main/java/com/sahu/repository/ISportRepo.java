package com.sahu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sahu.document.Sport;

public interface ISportRepo extends MongoRepository<Sport, Long> {

}
