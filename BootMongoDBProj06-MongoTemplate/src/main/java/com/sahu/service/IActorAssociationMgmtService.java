package com.sahu.service;

import java.util.List;

import com.sahu.document.Actor;

public interface IActorAssociationMgmtService {
	public String registerActor(Actor actor);
	public String registerActorsGroup(List<Actor> actorsList);
	public List<Actor> getAllActors();
	public List<Actor> getAllActorsByCategory(String category);
	
	public Actor getActorByActorId(Integer actorId);
	public String updateActorByActorId(Integer id, String newAddress, Long newMobileNo);
	public String updateActorsRenumerationByCategoryAndAge(String category, Float age, Double renumeration);
	
	public String saveOrUpdateActorByRenumeration(Double start, Double end, String newAddress, Float newAge, Long newMobileNo);
	
	public String removeActorByAge(Float age);
	public String removeAllActorsByAge(Float age);
}
