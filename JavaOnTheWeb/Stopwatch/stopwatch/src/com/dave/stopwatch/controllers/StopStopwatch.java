package com.dave.stopwatch.controllers;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dave.stopwatch.models.Watch;

/**
 * Servlet implementation class StopStopwatch
 */

public class StopStopwatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StopStopwatch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//check to see if a watch is running. If not, re-render page. Prevents errors.
		if(session.getAttribute("currentWatch") == null){
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			view.forward(request, response);
		}
		//retrieve current watch from session
		session.getAttribute("currentWatch");
		Watch current = (Watch) session.getAttribute("currentWatch");
		//set end time of watch
		current.setEndTime(LocalTime.now());
		System.out.println("current start of watch in session: " + current.getStartTime());
		System.out.println("current end of watch in session: " + current.getEndTime());
		System.out.println("Duration of watch in session: " + current.computeDuration().toNanos());
		session.setAttribute("isWatchRunning", false);
		
		if(session.getAttribute("allTheWatches") == null){
			ArrayList<Watch> allTheWatches = new ArrayList<>();
			allTheWatches.add(current);
			session.setAttribute("allTheWatches", allTheWatches);
		}
		else{
			ArrayList<Watch> allTheWatches = (ArrayList<Watch>)session.getAttribute("allTheWatches");
			allTheWatches.add(current);
		}
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
