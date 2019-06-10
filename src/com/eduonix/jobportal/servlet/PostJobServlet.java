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
 * Servlet implementation class PostJobServlet
 */
@WebServlet("/PostJob")
public class PostJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/postJob.jsp");
		rd.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String contactPhone = request.getParameter("contactphone");
		String posterName = request.getParameter("postername");
		String jobPostingPassword = request.getParameter("password");
		String jobName = request.getParameter("jobname");
		String messageBody = request.getParameter("messagebody");
		
		JobPosting jobPost = new JobPosting();
		jobPost.setContactPhone(contactPhone);
		jobPost.setJobName(jobName);
		jobPost.setMessageBody(messageBody);
		jobPost.setPosterName(posterName);
		jobPost.setJobPostingPassword(jobPostingPassword);
		
		JobPostingDAO dao = new JobPostingDAO();
		dao.insertJobPosting(jobPost);
		RequestDispatcher rd = request.getRequestDispatcher("/postJobSuccess.jsp");
		rd.forward(request, response);
	}

}
