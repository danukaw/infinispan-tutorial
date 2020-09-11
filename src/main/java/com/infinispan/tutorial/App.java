package com.infinispan.tutorial;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/main")
public class App extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	MessageService messageService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		
		for(Message message : messageService.getMesseages()) {
			writer.println(message.getMessage());
			writer.println("<br>");		
		}
		
		writer.println("<br>");		
		writer.println("<br>");		
		
		
		resp.setContentType("text/html");
	}
	

}
