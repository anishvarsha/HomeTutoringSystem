package com.data.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.hibernate.ParentTutor;
import com.data.hibernate.StudentTutor;
import com.data.operations.ParentOperations;
import com.data.operations.StudentOperations;

/**
 * Servlet implementation class tutorSignUp
 */
@WebServlet("/TutorSignUp")
public class TutorSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TutorSignUp() {
        // TODO Auto-generated constructor stub
    		super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentOperations userDAO = new StudentOperations();
	
		  List<StudentTutor> student = userDAO.findStudentByFirstName("Unna");
		  if(!student.isEmpty()) {
			 String json=  JsonParser.convertToJson(student.get(0));
			 System.out.println(json);
			 response.setContentType("application/json");
			 PrintWriter out = response.getWriter();
			// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
			out.print(json);
			out.flush();
		  }
	  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String netId = request.getParameter("net");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phonenumber");
		String resumeLink = request.getParameter("resumelink");
		String password = request.getParameter("password");
		int studentId = Integer.parseInt(netId);
		int phoneNo = Integer.parseInt(phoneNumber);
	System.out.println(firstName + "hello");
		try {
			StudentOperations userDAO = new StudentOperations();
			userDAO.addStudent(studentId, password, firstName, lastName, email, phoneNo, resumeLink);
			System.out.println("inserted student");

			response.sendRedirect("Success");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
