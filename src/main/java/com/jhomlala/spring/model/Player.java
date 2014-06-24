package com.jhomlala.spring.model;

public class Player {
	
	private int id;
	private String steamid;
	private String lastname;
	private int totalcount;
	private int scoutcount;
	private int soldiercount;
	private int pyrocount;
	private int demomancount;
	private int heavycount;
	private int engineercount;
	private int mediccount;
	private int snipercount;
	private int spycount;
	private int totalkills;
	private int totaldeaths;
	private int totalassists;
	
	
	
	public Player(int id, String steamid, String lastname, int totalcount,
			int scoutcount, int soldiercount, int pyrocount, int demomancount,
			int heavycount, int engineercount, int mediccount, int snipercount,
			int spycount, int totalkills, int totaldeaths, int totalassists) {
		this.id = id;
		this.steamid = steamid;
		this.lastname = lastname;
		this.totalcount = totalcount;
		this.scoutcount = scoutcount;
		this.soldiercount = soldiercount;
		this.pyrocount = pyrocount;
		this.demomancount = demomancount;
		this.heavycount = heavycount;
		this.engineercount = engineercount;
		this.mediccount = mediccount;
		this.snipercount = snipercount;
		this.spycount = spycount;
		this.totalkills = totalkills;
		this.totaldeaths = totaldeaths;
		this.totalassists = totalassists;
	}
	
	public Player() {
		this.id = 0;
		this.steamid = "0";
		this.lastname = "0";
		this.totalcount = 0;
		this.scoutcount = 0;
		this.soldiercount = 0;
		this.pyrocount = 0;
		this.demomancount = 0;
		this.heavycount = 0;
		this.engineercount = 0;
		this.mediccount = 0;
		this.snipercount = 0;
		this.spycount = 0;
		this.totalkills = 0;
		this.totaldeaths = 0;
		this.totalassists = 0;
	}
	
	

/**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @return the steamid
 */
public String getSteamid() {
	return steamid;
}
/**
 * @return the lastname
 */
public String getLastname() {
	return lastname;
}
/**
 * @return the totalcount
 */
public int getTotalcount() {
	return totalcount;
}
/**
 * @return the scoutcount
 */
public int getScoutcount() {
	return scoutcount;
}
/**
 * @return the soldiercount
 */
public int getSoldiercount() {
	return soldiercount;
}
/**
 * @return the pyrocount
 */
public int getPyrocount() {
	return pyrocount;
}
/**
 * @return the demomancount
 */
public int getDemomancount() {
	return demomancount;
}
/**
 * @return the heavycount
 */
public int getHeavycount() {
	return heavycount;
}
/**
 * @return the engineercount
 */
public int getEngineercount() {
	return engineercount;
}
/**
 * @return the mediccount
 */
public int getMediccount() {
	return mediccount;
}
/**
 * @return the snipercount
 */
public int getSnipercount() {
	return snipercount;
}
/**
 * @return the spycount
 */
public int getSpycount() {
	return spycount;
}
/**
 * @return the totalkills
 */
public int getTotalkills() {
	return totalkills;
}
/**
 * @return the totaldeaths
 */
public int getTotaldeaths() {
	return totaldeaths;
}
/**
 * @return the totalassists
 */
public int getTotalassists() {
	return totalassists;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @param steamid the steamid to set
 */
public void setSteamid(String steamid) {
	this.steamid = steamid;
}
/**
 * @param lastname the lastname to set
 */
public void setLastname(String lastname) {
	this.lastname = lastname;
}
/**
 * @param totalcount the totalcount to set
 */
public void setTotalcount(int totalcount) {
	this.totalcount = totalcount;
}
/**
 * @param scoutcount the scoutcount to set
 */
public void setScoutcount(int scoutcount) {
	this.scoutcount = scoutcount;
}
/**
 * @param soldiercount the soldiercount to set
 */
public void setSoldiercount(int soldiercount) {
	this.soldiercount = soldiercount;
}
/**
 * @param pyrocount the pyrocount to set
 */
public void setPyrocount(int pyrocount) {
	this.pyrocount = pyrocount;
}
/**
 * @param demomancount the demomancount to set
 */
public void setDemomancount(int demomancount) {
	this.demomancount = demomancount;
}
/**
 * @param heavycount the heavycount to set
 */
public void setHeavycount(int heavycount) {
	this.heavycount = heavycount;
}
/**
 * @param engineercount the engineercount to set
 */
public void setEngineercount(int engineercount) {
	this.engineercount = engineercount;
}
/**
 * @param mediccount the mediccount to set
 */
public void setMediccount(int mediccount) {
	this.mediccount = mediccount;
}
/**
 * @param snipercount the snipercount to set
 */
public void setSnipercount(int snipercount) {
	this.snipercount = snipercount;
}
/**
 * @param spycount the spycount to set
 */
public void setSpycount(int spycount) {
	this.spycount = spycount;
}
/**
 * @param totalkills the totalkills to set
 */
public void setTotalkills(int totalkills) {
	this.totalkills = totalkills;
}
/**
 * @param totaldeaths the totaldeaths to set
 */
public void setTotaldeaths(int totaldeaths) {
	this.totaldeaths = totaldeaths;
}
/**
 * @param totalassists the totalassists to set
 */
public void setTotalassists(int totalassists) {
	this.totalassists = totalassists;
}

	
}
