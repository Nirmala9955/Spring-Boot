package com.sahu.runner;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sahu.document.Medal;
import com.sahu.document.MedalType;
import com.sahu.document.Player;
import com.sahu.document.Sport;
import com.sahu.service.ISportsMgmtService;

@Component
public class AssociationsTestRunner implements CommandLineRunner {
	
	@Autowired
	private ISportsMgmtService sportsMgmtService;
	
	@Override
	public void run(String... args) throws Exception {
		//Prepare player object
		Player player = new Player();
		player.setPId(new Random().nextInt(100000));
		player.setPName("P. V. Sindhu");
		player.setPAddress("Hyd");
		player.setCountry("India");
		
		//Child objects - 1
		Sport sport1 = new Sport();
		sport1.setId(Long.valueOf(new Random().nextInt(100000)));
		sport1.setName("batminton");
		sport1.setIsOlympicSport(true);
		sport1.setTeamSport(false);
		Sport sport2 = new Sport();
		sport2.setId(Long.valueOf(new Random().nextInt(100000)));
		sport2.setName("cricket");
		sport2.setIsOlympicSport(false);
		sport2.setTeamSport(true);
		
		//Child objects - 2
		Medal medal1 = new Medal();
		medal1.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 10));
		medal1.setType(MedalType.BRONZ);
		medal1.setPriceMoney(100000000.0);
		medal1.setSportName("Batminton");
		medal1.setEventName("Tokyp-Olympics-2021");
		Medal medal2 = new Medal();
		medal2.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 10));
		medal2.setType(MedalType.SILVER);
		medal2.setPriceMoney(50000000.0);
		medal2.setSportName("Batminton");
		medal2.setEventName("RIO-Olympics-2016");

		player.setSports(Set.of(sport1, sport2));
		player.setMedals(Map.of("Tokyo-Bronze", medal1, "RIO-Silver", medal2));
		//System.out.println(sportsMgmtService.registerPlayer(player));
		
		sportsMgmtService.getAllPlayers().forEach(playerDetails->{
			System.out.println("Parent : "+playerDetails);
			playerDetails.getSports().forEach(sport->{
				System.out.println("Child-1 : "+sport);
			});
			playerDetails.getMedals().forEach((name, medal)->{
				System.out.println("Child-2 : "+name+" : "+medal);
			});
		});
	}

}
