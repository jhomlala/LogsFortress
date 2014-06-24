package com.jhomlala.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.jhomlala.spring.model.Player;

import org.apache.commons.logging.Log;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class PlayerDAOImpl implements PlayerDAO {

	private JdbcTemplate jdbcTemplate;
	
	public PlayerDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Player player) {

		if (player.getId() > 0) {
			Log("UPDATE","UPDATE PLAYER WITH STEAMID "+ player.getSteamid());
			String sql = "UPDATE player SET steamid=?, lastname=?, totalcount=?, scoutcount=?,soldiercount=?,"
					+ "pyrocount=?,demomancount=?,heavycount=?,engineercount=?,mediccount=?,snipercount=?,spycount=?,"
					+ "totalkills=?,totaldeaths=?,totalassists=? WHERE steamid=?";
			jdbcTemplate.update(sql, player.getSteamid(), player.getLastname(),player.getTotalcount(),
					player.getScoutcount(),player.getSoldiercount(),player.getPyrocount(),player.getDemomancount(),
					player.getHeavycount(),player.getEngineercount(),player.getMediccount(),player.getSnipercount(),
					player.getSpycount(),player.getTotalkills(),player.getTotaldeaths(),player.getTotalassists(),player.getSteamid());
		} else {
			Log("INSERT","INSERT PLAYER WITH STEAMID "+ player.getSteamid());
			String sql = "INSERT INTO player (steamid, lastname, totalcount, scoutcount,soldiercount,pyrocount,demomancount"
					+ ",heavycount,engineercount,mediccount,snipercount,spycount,totalkills,totaldeaths,totalassists)"
						+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, player.getSteamid(), player.getLastname(),player.getTotalcount(),
					player.getScoutcount(),player.getSoldiercount(),player.getPyrocount(),player.getDemomancount(),
					player.getHeavycount(),player.getEngineercount(),player.getMediccount(),player.getSnipercount(),
					player.getSpycount(),player.getTotalkills(),player.getTotaldeaths(),player.getTotalassists());
		}
		
	}

	private void Log(String TypeOfLog, String Message) 
	{
		String sql = "INSERT INTO logs (type, message, time) VALUES (?, ?, ?)";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
		String date = sdf.format(new Date()); 
		jdbcTemplate.update(sql,TypeOfLog,Message,date );
		System.out.println("["+date+"]"+"["+TypeOfLog+"]:"+Message+".");

	}

	@Override
	public void delete(int playerid) {
		String sql = "DELETE FROM player WHERE id=?";
		jdbcTemplate.update(sql, playerid);
	}

	@Override
	public List<Player> list() {
		String sql = "SELECT * FROM player";
		List<Player> listPlayer = jdbcTemplate.query(sql, new RowMapper<Player>() {

			@Override
			public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
				Player actualPlayer = new Player();
	
				actualPlayer.setId(rs.getInt("id"));
				actualPlayer.setSteamid(rs.getString("steamid"));
				actualPlayer.setLastname(rs.getString("lastname"));
				actualPlayer.setTotalcount(rs.getInt("totalcount"));
				actualPlayer.setScoutcount(rs.getInt("scoutcount"));
				actualPlayer.setSoldiercount(rs.getInt("soldiercount"));
				actualPlayer.setPyrocount(rs.getInt("pyrocount"));
				actualPlayer.setDemomancount(rs.getInt("demomancount"));
				actualPlayer.setHeavycount(rs.getInt("heavycount"));
				actualPlayer.setEngineercount(rs.getInt("engineercount"));
				actualPlayer.setMediccount(rs.getInt("mediccount"));
				actualPlayer.setSnipercount(rs.getInt("snipercount"));
				actualPlayer.setSpycount(rs.getInt("spycount"));
				
				return actualPlayer;
			}
			
		});
		
		return listPlayer;
	}
	
	
	

	@Override
	public Player get(String id) {
		String sql = "SELECT * FROM player WHERE steamid='" + id+"'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Player>() {

			@Override
			public Player extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Player actualPlayer = new Player();
					
					actualPlayer.setId(rs.getInt("id"));
					actualPlayer.setSteamid(rs.getString("steamid"));
					actualPlayer.setLastname(rs.getString("lastname"));
					actualPlayer.setTotalcount(rs.getInt("totalcount"));
					actualPlayer.setScoutcount(rs.getInt("scoutcount"));
					actualPlayer.setSoldiercount(rs.getInt("soldiercount"));
					actualPlayer.setPyrocount(rs.getInt("pyrocount"));
					actualPlayer.setDemomancount(rs.getInt("demomancount"));
					actualPlayer.setHeavycount(rs.getInt("heavycount"));
					actualPlayer.setEngineercount(rs.getInt("engineercount"));
					actualPlayer.setMediccount(rs.getInt("mediccount"));
					actualPlayer.setSnipercount(rs.getInt("snipercount"));
					actualPlayer.setTotalkills(rs.getInt("totalkills"));
					actualPlayer.setTotaldeaths(rs.getInt("totaldeaths"));
					actualPlayer.setTotalassists(rs.getInt("totalassists"));
					return actualPlayer;
				}
				
				return null;
			}
			
		});
	}

	@Override
	public int getPlayersNumber() 
	{

        String sql = "SELECT count(*) FROM player";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
		
		return count;
	}

}
