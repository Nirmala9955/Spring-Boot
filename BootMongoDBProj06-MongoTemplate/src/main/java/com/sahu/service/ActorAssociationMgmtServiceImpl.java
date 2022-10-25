package com.sahu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
import com.sahu.document.Actor;

import ch.qos.logback.core.joran.action.Action;

@Service("actorService")
public class ActorAssociationMgmtServiceImpl implements IActorAssociationMgmtService {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public String registerActor(Actor actor) {
		//Actor savedActor = mongoTemplate.save(actor, "Artist"); //Creates the collection with the given name Artist
		Actor savedActor = mongoTemplate.save(actor); //Creates the collection with the given Document class name "Actor"	
		return savedActor.getActorName()+" actor has registered";
	}

	@Override
	public String registerActorsGroup(List<Actor> actorsList) {
		return actorsList.size()+" no. of actors are saved."+mongoTemplate.insertAll(actorsList);
	}

	@Override
	public List<Actor> getAllActors() {
		return mongoTemplate.findAll(Actor.class);
	}

	@Override
	public List<Actor> getAllActorsByCategory(String category) {
		Query query = new Query();
		query.addCriteria(Criteria.where("category").is(category));
		List<Actor> actorList = mongoTemplate.find(query, Actor.class);
		return actorList;
	}

	@Override
	public Actor getActorByActorId(Integer actorId) {
		return mongoTemplate.findById(actorId, Actor.class);
	}
	
	@Override
	public String updateActorByActorId(Integer id, String newAddress, Long newMobileNo) {
		//Prepare Query object
		Query query = new Query();
		query.addCriteria(Criteria.where("actorId").is(id));
		//Prepare update obejct for modifying the doc
		Update update = new Update();
		update.set("actorAddress", newAddress);
		update.set("mobileNo", newMobileNo);
		//modify
		Actor actor = mongoTemplate.findAndModify(query, update, Actor.class);
		return actor==null?"Actor not found for updation":"Actor found and updated";
	}
	
	@Override
	public String updateActorsRenumerationByCategoryAndAge(String category, Float age, Double renumeration) {
		//Prepare query object
		Query query = new Query().addCriteria(Criteria.where("category").is(category).andOperator(Criteria.where("age").gte(age)));
		//Prepare update object
		Update update = new Update().set("renumeration", renumeration);
		//Invoke updateMulti method
		UpdateResult result = mongoTemplate.updateMulti(query, update, Actor.class);
		return result.getModifiedCount()+" no. of actors are modified";
	}

	@Override
	public String saveOrUpdateActorByRenumeration(Double start, Double end, String newAddress, Float newAge, Long newMobileNo) {
		//Prepare object
		Query query = new Query().addCriteria(Criteria.where("renumeration").gte(start).andOperator(Criteria.where("renumeration").lte(end)));
		//Prepare update object
		Update update = new Update().set("actorAddress", newAddress).set("age", newAge).set("mobileNo", newMobileNo);
		//Invoke upsert method
		UpdateResult result = mongoTemplate.upsert(query, update, Actor.class);
		return result.getModifiedCount()+" has modified and inserted document is"+result.getUpsertedId();
	}
	
	@Override
	public String removeActorByAge(Float age) {
		Query query = new Query().addCriteria(Criteria.where("age").is(age));
		Actor actor = mongoTemplate.findAndRemove(query, Actor.class);
		return actor.getActorId()+" document has removed.";
	}
	
	@Override
	public String removeAllActorsByAge(Float age) {
		Query query = new Query().addCriteria(Criteria.where("age").is(age));
		List<Actor> actorList = mongoTemplate.findAllAndRemove(query, Actor.class);
		return actorList.size()+" no. of documents has removed.";
	}
}
