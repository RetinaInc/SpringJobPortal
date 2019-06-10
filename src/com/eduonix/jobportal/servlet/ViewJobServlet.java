package com.eduonix.jobportal.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduonix.jobportal.dao.JobPostingDAO;
import com.eduonix.jobportal.entities.JobPosting;

/**
 * Servlet implementation class ViewJobServlet
 */
@WebServlet("/ViewJobs")
public class ViewJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		JobPostingDAO dao = new JobPostingDAO();
		List<JobPosting> jobs = dao.getAllJobPostings();
		request.setAttribute("jobs", jobs);
		RequestDispatcher rd = request.getRequestDispatcher("/viewJobs.jsp");
		rd.forward(request, response);
	}

	

}
