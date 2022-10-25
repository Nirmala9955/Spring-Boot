package com.sahu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sahu.document.Player;

public interface IPlayerRepo extends MongoRepository<Player, Integer> {

}
