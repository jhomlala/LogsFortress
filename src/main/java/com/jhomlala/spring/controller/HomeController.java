package com.jhomlala.spring.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhomlala.spring.dao.ContactDAO;
import com.jhomlala.spring.dao.PlayerDAO;
import com.jhomlala.spring.model.Contact;
import com.jhomlala.spring.model.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * This controller routes accesses to the application to the appropriate
 * hanlder methods. 
 * @author www.codejava.net
 *
 */
@Controller
public class HomeController {

	@Autowired
	private PlayerDAO contactDAO;
	
	@RequestMapping(value="/")
	public ModelAndView listContact(ModelAndView model) throws IOException{
	FileInterface FI = new FileInterface();	
	int LastLogId = FI.LoadLastLogID();
	model.addObject("LastLogId",LastLogId);
	model.addObject("LastLogIdPercent",(float)LastLogId/329100 * 100);
	model.addObject("PlayerCount",contactDAO.getPlayersNumber());
	
	model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = "/player", method = RequestMethod.POST)
	public ModelAndView viewPlayer(ModelAndView model,HttpServletRequest request) throws IOException {
		
		String ReceivedSteamID = request.getParameter("steamid");
		model.addObject("sid",ReceivedSteamID);
		FileInterface FI = new FileInterface();	
		int LastLogId = FI.LoadLastLogID();
		model.addObject("LastLogId",LastLogId);
		model.addObject("LastLogIdPercent",(float)LastLogId/329100 * 100);
		model.addObject("PlayerCount",contactDAO.getPlayersNumber());
		StatsGenerator.createStatsForPlayer(model,ReceivedSteamID);
	    model.setViewName("player");
	    
	    return model;
	}

	
	@RequestMapping("/redir")
	protected String redirect(
	    @RequestParam("redir_url") String redirectUrl,
	    HttpServletRequest request, 
	    HttpServletResponse response) throws IOException 
	{
		System.out.println("TUTAJ");
		response.sendRedirect("home");
		return null;
		
	}
	
	@RequestMapping(value = "/redir", method = RequestMethod.GET)
	static String processForm()
	{
		System.out.println("TUTAJ");
	    return "redirect:/";
	}
	
	

	

}
