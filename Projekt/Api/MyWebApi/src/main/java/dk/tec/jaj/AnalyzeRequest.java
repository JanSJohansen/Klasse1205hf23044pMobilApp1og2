package dk.tec.jaj;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalyzeRequest 
{
	MatchEnum level;
	
	int id;
	
	public MatchEnum getLevel() {
		return level;
	}

	public int getId() {
		return id;
	}

	
	public AnalyzeRequest(String pathInfo) 
	{
		Matcher match = Pattern.compile("/Elev/([0-9]+)").matcher(pathInfo);
		
		if(match.find())
		{
			level = MatchEnum.MatchElevId;
			id = Integer.parseInt(match.group(1));				
		}
		else
		{
			match = Pattern.compile("/Elev").matcher(pathInfo);
			if(match.find())
			{
				level = MatchEnum.MatchElev;
			}
			else
			{
				level = MatchEnum.MatchNo;
			}
		}	
	}
}
