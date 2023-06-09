package dk.tec.jaj.example2;


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
import dk.tec.jaj.Elev;
import dk.tec.jaj.MatchEnum;


//@WebServlet("/MyWebApi")
public class MyApiServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		
        Elev e1 = new Elev(1000, "Martin", 22, "McDonalds Senior Floormanager");
		
		ArrayList<Elev> elever = new ArrayList<Elev>();
		elever.add(e1);
		elever.add(new Elev(1001, "Marco", 19, "Tagfejer"));
		elever.add(new Elev(1002, "Joseph", 40, "EjendomsserviceManager"));
		
		ObjectMapper mapper = new ObjectMapper();
		
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		if(analyze.getLevel() == MatchEnum.MatchElevId)
		{
			//out.print("<br/>Match på Elev og id: " + analyze.getId());
			
			String jsonStr = mapper.writeValueAsString(elever.get(analyze.getId()));
			
			out.print(jsonStr);	
		}
		else if(analyze.getLevel() == MatchEnum.MatchElev)
		{
			String jsonStr = mapper.writeValueAsString(elever);
			out.print(jsonStr);
		}
		else
		{
			out.print("No Match<br/>");
		}
		
	}

}





