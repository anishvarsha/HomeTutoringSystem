package com.data.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.hibernate.Job;
import com.data.hibernate.ParentTutor;
import com.data.operations.JobOperations;
import com.data.operations.ParentOperations;

@WebServlet("/JobServlet")
public class JobServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	/**
	 * Default Constructor
	 */

	 public JobServlet(){
		 super();
	 }

	 /**
	  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	  */
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		  JobOperations userDAO = new JobOperations();
		  List<Job> parents = userDAO.getAllJobs();
		  if(!parents.isEmpty()) {
			 String json=  JsonParser.convertToJson(parents.get(0));
			 response.setContentType("application/json");
			 
			 PrintWriter out = response.getWriter();
				// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
				
				response.getWriter().write(json);
			// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
			
		  }
	  }

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		  //String password = request.getParameter("username");
		  String payRate = request.getParameter("payrate");
		  String payType = request.getParameter("paytype");
		 
		  String description = request.getParameter("description");
		  String jobtime = request.getParameter("jobtime");
		  String subject = request.getParameter("subject");
		  String parent = request.getParameter("parent");
		  HttpSession session = request.getSession(true);
		  
		  int subjectid = Integer.parseInt(subject);
		  int parentid = Integer.parseInt(parent);
		  
	
	      try {
	            JobOperations userDAO = new JobOperations();
	           userDAO.addJob(description, payRate, payType, jobtime, subjectid, true, parentid);
	            //userDAO.addParent("abcsd","Unnati", "Singh", "xyz@gmail.com",Integer.parseInt("12345"));
	            System.out.println("inserted job");
	            
	            response.sendRedirect("dashparent.html");
	      }catch (Exception e) {
	 
	            e.printStackTrace();
	      }
		  
		 // System.out.println("user: "+userName);

	  }

}
