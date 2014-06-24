package com.jhomlala.spring.controller;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.jhomlala.spring.config.MvcConfiguration;
import com.jhomlala.spring.dao.PlayerDAO;
import com.jhomlala.spring.dao.PlayerDAOImpl;
import com.jhomlala.spring.model.Player;


@Component
public class UpdateDatabase implements ApplicationListener<ContextRefreshedEvent>
{

	
  @Override
  public void onApplicationEvent(final ContextRefreshedEvent event)
  {
	  startUpdateProcess();
  }

private void startUpdateProcess() 
{
	Timer timer = new Timer();
	TimerTask tt = new TimerTask(){
		public void run(){
			/*try {
				checkIsUpToDate();
			} catch (NumberFormatException e) {

				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			} */
		}
	};
	timer.schedule(tt, 1000, 600000);

}


private void checkIsUpToDate() throws NumberFormatException, IOException 
{
	int CurrentLogID = 0;
	int Failures = 0;
	boolean LoopFlag = true;
	boolean CurrentFlag = true;
	FileInterface FI = new FileInterface();
	try
	{
		CurrentLogID = FI.LoadLastLogID();
	}
	catch (IOException exception)
	{
		System.out.println("Exception:" + exception);
		LoopFlag = false; //cant start due we have already data , better just wait.
	}
		

	while (LoopFlag)
	{
		System.out.println(CurrentLogID + "(FAILURES: "+Failures+")");
		CurrentFlag = checkDoesLogIsReachable(CurrentLogID);
		if (CurrentFlag==false)
			Failures++;
		else
		{
			Failures=0;
			LoadDataFromLog(CurrentLogID);
			FI.SaveLastLogID(String.valueOf(CurrentLogID));
		}
		if (Failures>500)
			LoopFlag=false;
		CurrentLogID++;
		
		
	}
	
	
}

private void LoadDataFromLog(int currentLogID) 
{
	System.out.println("Getting data from "+ currentLogID);
	try {
		JSONObject JSONWithLogs = JsonReader.readJsonFromUrl("http://logs.tf/json/"+currentLogID);
		JSONObject JSONWithPlayers =  JSONWithLogs.getJSONObject("players"); 
		Iterator <String> it;
		it = JSONWithPlayers.keys();
		
		while (it.hasNext())
		{
			Object CurrentPlayer = it.next();
			JSONObject PlayerData =  JSONWithPlayers.getJSONObject(CurrentPlayer.toString());

			
			int kills = PlayerData.getInt("kills");
			int deaths = PlayerData.getInt("deaths");
			int assists = PlayerData.getInt("assists");
			JSONArray classes = PlayerData.getJSONArray("class_stats");
			executeUpdate(CurrentPlayer.toString(),kills,deaths,assists,classes);
		} 
		 
	} catch (JSONException e) { 
		e.printStackTrace(); 
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}

 




private void executeUpdate(String steamid, int kills, int deaths, int assists,JSONArray classes) 
{

	MvcConfiguration config = new MvcConfiguration();
	DataSource dataForDAO = config.getDataSource();
	PlayerDAOImpl PlayerDBInterface = new PlayerDAOImpl(dataForDAO);
	Player updatingPlayer =	PlayerDBInterface.get(steamid);
	if (updatingPlayer==null)
	{
		updatingPlayer = new Player();
		updatingPlayer.setLastname("unknown");
		updatingPlayer.setSteamid(steamid);
		updatingPlayer.setTotalkills(kills);
		updatingPlayer.setTotaldeaths(deaths);
		updatingPlayer.setTotalassists(assists);
		updatingPlayer.setScoutcount(0);
		updatingPlayer.setSoldiercount(0);
		updatingPlayer.setPyrocount(0);
		updatingPlayer.setDemomancount(0);
		updatingPlayer.setEngineercount(0);
		updatingPlayer.setHeavycount(0);
		updatingPlayer.setMediccount(0);
		updatingPlayer.setSnipercount(0);
		updatingPlayer.setSpycount(0);
		updatingPlayer.setTotalcount(1);
		PlayerDBInterface.saveOrUpdate(updatingPlayer);
	}
	else
	{
		int storedKills = updatingPlayer.getTotalkills();
		int storedDeaths = updatingPlayer.getTotaldeaths(); 
		int storedAssists = updatingPlayer.getTotaldeaths();
		int storedTotalcount = updatingPlayer.getTotalcount();
		int storedScoutCount = updatingPlayer.getScoutcount();
		int storedSoldierCount = updatingPlayer.getSoldiercount();
		int storedPyroCount = updatingPlayer.getSoldiercount();
		int storedDemomanCount = updatingPlayer.getSoldiercount();
		int storedHeavyCount = updatingPlayer.getSoldiercount();
		int storedEngineerCount = updatingPlayer.getSoldiercount();
		int storedMedicCount = updatingPlayer.getSoldiercount();
		int storedSniperCount = updatingPlayer.getSoldiercount();
		int storedSpyCount = updatingPlayer.getSoldiercount();

		updatingPlayer.setTotalkills(storedKills+kills);
		updatingPlayer.setTotaldeaths(storedDeaths+deaths);
		updatingPlayer.setTotalassists(storedAssists+assists);
		updatingPlayer.setTotalcount(storedTotalcount+1);
		
		
		for (int i=0;i<classes.length();i++)
		{
			JSONObject obj = classes.getJSONObject(i);
			
		}
		
		
		for (int i=0;i<classes.length();i++)
		{
			JSONObject ClassObject = classes.getJSONObject(i);
			switch (ClassObject.get("type").toString())
			{
			case "scout":
			{
				updatingPlayer.setScoutcount(storedScoutCount+1);
				System.out.println("scout");
				break;
			}
			case "soldier":
			{
				updatingPlayer.setSoldiercount(storedSoldierCount+1);
				System.out.println("soldier");
				break;
			}
			case "pyro":
			{
				updatingPlayer.setPyrocount(storedPyroCount+1);
				System.out.println("pyro");
				break;
			}
			case "demoman":
			{
				updatingPlayer.setDemomancount(storedDemomanCount+1);
				System.out.println("demo");
				break;
			}
			case "heavyweapons":
			{
				updatingPlayer.setHeavycount(storedHeavyCount+1);
				System.out.println("hvy");
				break;
			}
			case "engineer":
			{
				updatingPlayer.setEngineercount(storedEngineerCount+1);
				System.out.println("eng");
				break;
			}
			case "medic":
			{
				updatingPlayer.setMediccount(storedMedicCount+1);
				System.out.println("med");
				break;
			}
			case "sniper":
			{
				updatingPlayer.setSnipercount(storedSniperCount+1);
				System.out.println("sniper");
				break;
			}
			case "spy":
			{
				updatingPlayer.setSpycount(storedSpyCount+1);
				System.out.println("spy");
				break;
			}
			
			}
		}
		
		PlayerDBInterface.saveOrUpdate(updatingPlayer);
		
	}
}

boolean checkDoesLogIsReachable(int id)
{
    JSONObject json=null;
    try
    {
    	json = JsonReader.readJsonFromUrl("http://logs.tf/json/"+id);
    }
    catch (IOException e)
    {
    	return false;
    }
    
    
    if (json==null)
    	return false;
    else
    	return true;
}


private void checkUpdate() throws IOException {
    JSONObject json=null;
	try {
		json = JsonReader.readJsonFromUrl("http://logs.tf/json/327983");
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if (json==null)
	{
		System.out.println("JSON NULL BAD ID");
	}
	else
	{
    System.out.println(json.toString());
    FileInterface FI = new FileInterface();

    //System.out.println(json.get("id"));
	}
}




}