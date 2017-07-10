package com.dave.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("name");
		if (userName == null){ userName= "default";}
		String favLanguage = request.getParameter("lang");
		if (favLanguage == null){ favLanguage= "default";}
		String hometown = request.getParameter("town");
		if (hometown == null){ hometown= "default";}
		PrintWriter out = response.getWriter();
		out.write("<h1>Welcome, "+ userName +"</h1>"
				+ "<h3>Your favorite language is "+ favLanguage +"</h3>"
				+ "<h3>Your hometown is "+ hometown +"</h3>");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
