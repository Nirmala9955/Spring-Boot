package com.sahu.runner;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sahu.document.Actor;
import com.sahu.service.IActorAssociationMgmtService;

@Component
public class MongoTemplateTestRunner implements CommandLineRunner {
	
	@Autowired
	private IActorAssociationMgmtService actorAssociationMgmtService;
	
	@Override
	public void run(String... args) throws Exception {
		/*Actor actor = new Actor();
		actor.setActorId(new Random().nextInt(100000));
		actor.setActorName("Akshay Kumar");
		actor.setAge(58.0f);
		actor.setCategory("Hero");
		actor.setMobileNo(9865766754l);
		System.out.println(actorAssociationMgmtService.registerActor(actor));
		
		Actor actor1 = new Actor();
		actor1.setActorId(new Random().nextInt(100000));
		actor1.setActorName("Sonu Sood");
		actor1.setAge(45.0f);
		actor1.setCategory("Hero");
		actor1.setMobileNo(6765766754l);
		Actor actor2 = new Actor();
		actor2.setActorId(new Random().nextInt(100000));
		actor2.setActorName("Salman Khan");
		actor2.setAge(55.0f);
		actor2.setCategory("Hero");
		actor2.setMobileNo(8865908674l);
		System.out.println(actorAssociationMgmtService.registerActorsGroup(List.of(actor1, actor2)));
		
		actorAssociationMgmtService.getAllActors().forEach(System.out::println);
		
		actorAssociationMgmtService.getAllActorsByCategory("Hero").forEach(System.out::println);*/
		
		//Finder method
		/*System.out.println(actorAssociationMgmtService.getActorByActorId(31434));
		
		System.out.println(actorAssociationMgmtService.updateActorByActorId(31434, "Mumbai", 987985454l));

		System.out.println(actorAssociationMgmtService.updateActorsRenumerationByCategoryAndAge("Hero", 40.0f, 100000000.0));
		*/
		
		System.out.println(actorAssociationMgmtService.saveOrUpdateActorByRenumeration(5000000.0, 10000000.0, "Hyd", 53.0f, 9876578933l));
		
		System.out.println(actorAssociationMgmtService.removeActorByAge(40.0f));

		System.out.println(actorAssociationMgmtService.removeAllActorsByAge(40.0f));
	}

}
