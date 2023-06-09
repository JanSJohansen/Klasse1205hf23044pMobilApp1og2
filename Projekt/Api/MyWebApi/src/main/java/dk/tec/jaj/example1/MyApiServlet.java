package dk.tec.jaj.example1;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/MyWebApi")
public class MyApiServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.print("ConstextPath: " + request.getContextPath());
		out.print("<br>ServletPath: " + request.getServletPath());
		out.print("<br>PathInfo: " + request.getPathInfo());
		
		
		
	}

}
