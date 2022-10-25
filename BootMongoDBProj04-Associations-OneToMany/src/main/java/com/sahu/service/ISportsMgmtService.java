package com.sahu.service;

import java.util.List;

import com.sahu.document.Player;

public interface ISportsMgmtService {
	public String registerPlayer(Player player);
	public List<Player> getAllPlayers();
}
