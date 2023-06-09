package dk.tec.jaj.example3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import dk.tec.jaj.AnalyzeRequest;
import dk.tec.jaj.DBTools;
import dk.tec.jaj.Elev;
import dk.tec.jaj.MatchEnum;


//@WebServlet("/MyWebApi")
public class MyApiServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		
		ObjectMapper mapper = new ObjectMapper();
		
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		DBTools db = new DBTools();
		
		switch(analyze.getLevel())
		{
		case MatchElevId:
			Elev elev = db.getElevById(analyze.getId());
			out.print(mapper.writeValueAsString(elev));
			//out.print("Det gik vist godt");
			break;
			
		case MatchElev:
			out.print("Match på elev");
			break;
			
		case MatchNo:
			
			break;
		}	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		super.doPost(request, response);
		
		BufferedReader reader = request.getReader();
		String jsonStr = reader.readLine();
		ObjectMapper mapper = new ObjectMapper();
		Elev elev = mapper.readValue(jsonStr, Elev.class);
		System.out.print(elev.getNavn() + " " + elev.getJob());
	}
	
}





