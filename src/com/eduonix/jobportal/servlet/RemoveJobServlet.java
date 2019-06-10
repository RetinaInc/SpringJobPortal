package com.eduonix.jobportal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduonix.jobportal.dao.JobPostingDAO;
import com.eduonix.jobportal.entities.JobPosting;

/**
 * Servlet implementation class RemoveJobServlet
 */
//@WebServlet("/RemoveJob")
@WebServlet(urlPatterns = {"/RemoveJob", "/JobRemove"})
public class RemoveJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/removeJob.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobPostingDAO dao = new JobPostingDAO();
		int jobPostId = Integer.parseInt(request.getParameter("id"));
		JobPosting postToRemove = dao.getJobPostingById(jobPostId);
		if (postToRemove.getJobPostingPassword().equals(request.getParameter("password"))) {
			dao.removeJobPosting(jobPostId);
			RequestDispatcher rd = request.getRequestDispatcher("/removeJobSuccess.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("error", true);
			//response.getWriter().println("Incorrect Password. Try again.");
			RequestDispatcher rd = request.getRequestDispatcher("/removeJob.jsp");
			rd.forward(request, response);
		}
	}

}
