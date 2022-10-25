package com.sahu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sahu.document.PersonDetails;

public interface IPersonDetailsRepo extends MongoRepository<PersonDetails, Integer> {

}
