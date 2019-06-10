package com.eduonix.jobportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.eduonix.jobportal.entities.JobPosting;

public class JobPostingDAO {
	
	private Connection conn;
	
	
	public JobPostingDAO() {
		final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String Database_URL= "jdbc:mysql://localhost/jobportaldb";
		final String Database_USER = "webadmin";
		final String Database_PASS = "Password1";
		
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			this.conn= DriverManager.getConnection(Database_URL, Database_USER, Database_PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public JobPosting getJobPostingById(int id) {
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from jobposting where id= "+id);
			if (rs.next()) {
				JobPosting jobPostToReturn = new JobPosting();
				jobPostToReturn.setContactPhone(rs.getString("contactPhone"));
				jobPostToReturn.setJobName(rs.getString("jobName"));
				jobPostToReturn.setJobPostingPassword(rs.getString("jobPostingPassword"));
				jobPostToReturn.setMessageBody(rs.getString("messageBody"));
				jobPostToReturn.setPosterName(rs.getString("posterName"));
				//jobPostToReturn.setId(id);
				jobPostToReturn.setId(rs.getInt("id"));
				return jobPostToReturn;
			} 
			st.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	public void insertJobPosting(JobPosting posting) {
		String sep = "','";
		
		try {
			Statement st = conn.createStatement();
			String sqlQuery = "insert into jobposting (messageBody, jobName, posterName, contactPhone, jobPostingPassword) values "
					+ "('"
					+ posting.getMessageBody()
					+sep+ posting.getJobName()
					+sep+ posting.getPosterName()
					+sep+ posting.getContactPhone()
					+ sep + posting.getJobPostingPassword()
					+"')" ;
			System.out.println(sqlQuery);
			st.executeUpdate(sqlQuery);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeJobPosting(int jobPostId) {
		try {
			Statement st = conn.createStatement();
			String sqlQuery = "Delete from jobposting where id=" +jobPostId;
			st.executeUpdate(sqlQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<JobPosting> getAllJobPostings(){
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from jobposting limit 200");
			//List<JobPosting> jobs = new ArrayList<JobPosting>();
			List<JobPosting> jobs = new ArrayList<>();
			while (rs.next()) {
				JobPosting jobPostToReturn = new JobPosting();
				jobPostToReturn.setContactPhone(rs.getString("contactPhone"));
				jobPostToReturn.setJobName(rs.getString("jobName"));
				jobPostToReturn.setJobPostingPassword(rs.getString("jobPostingPassword"));
				jobPostToReturn.setMessageBody(rs.getString("messageBody"));
				jobPostToReturn.setPosterName(rs.getString("posterName"));
				//jobPostToReturn.setId(id);
				jobPostToReturn.setId(rs.getInt("id"));
				
				jobs.add(jobPostToReturn);
			}
				st.close();
				rs.close();
				return jobs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
