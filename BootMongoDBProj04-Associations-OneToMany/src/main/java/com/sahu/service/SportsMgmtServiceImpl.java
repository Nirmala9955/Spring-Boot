package com.sahu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.document.Player;
import com.sahu.repository.IPlayerRepo;

@Service("sportsService")
public class SportsMgmtServiceImpl implements ISportsMgmtService {
	
	@Autowired
	private IPlayerRepo playerRepo;
	
	@Override
	public String registerPlayer(Player player) {
		return "Player "+playerRepo.save(player).getPName()+" has registered successfully.";
	}

	@Override
	public List<Player> getAllPlayers() {
		return playerRepo.findAll();
	}

}
