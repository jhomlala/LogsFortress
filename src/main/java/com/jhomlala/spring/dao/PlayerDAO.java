package com.jhomlala.spring.dao;

import java.util.List;

import com.jhomlala.spring.model.Player;

public interface PlayerDAO {
	public void saveOrUpdate(Player player);
	
	public void delete(int playerid);
	
	public Player get(String steamid);
	
	public List<Player> list();
	
	public int getPlayersNumber();
	
}
