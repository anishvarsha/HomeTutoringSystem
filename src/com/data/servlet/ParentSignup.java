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

import com.data.hibernate.ParentTutor;
import com.data.operations.ParentOperations;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Servlet implementation class parentSignup
 */
@WebServlet("/ParentSignup")
public class ParentSignup extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * Default Constructor
	 */

	 public ParentSignup(){
		 super();
	 }

	 /**
	  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	  */
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		  ParentOperations userDAO = new ParentOperations();
		  List<ParentTutor> parents = userDAO.findParentByFirstName("Don");
		  if(!parents.isEmpty()) {
			 String json=  JsonParser.convertToJson(parents.get(0));
			 System.out.println(json);
			 response.setContentType("application/json");
			 PrintWriter out = response.getWriter();
			// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
			out.print(json);
			out.flush();
		  }
	  }

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		  //String password = request.getParameter("username");
		  String firstName = request.getParameter("firstname");
		  String lastName = request.getParameter("lastname");
		  //String school = request.getParameter("school");
		  String email = request.getParameter("email");
		  String phoneNumber = request.getParameter("phonenumber");
		  String password = request.getParameter("password");
		  String password2 = request.getParameter("password2");
		  HttpSession session = request.getSession(true);
		  
		  int phone = Integer.parseInt(phoneNumber);
		  System.out.println(phone);
		  System.out.println("firstNAme" + firstName);
	      try {
	            ParentOperations userDAO = new ParentOperations();
	           userDAO.addParent(password,firstName, lastName, email, phone);
	            //userDAO.addParent("abcsd","Unnati", "Singh", "xyz@gmail.com",Integer.parseInt("12345"));
	            System.out.println("inserted parent");
	            
	            response.sendRedirect("Success");
	      }catch (Exception e) {
	 
	            e.printStackTrace();
	      }
		  
		 // System.out.println("user: "+userName);

	  }
}