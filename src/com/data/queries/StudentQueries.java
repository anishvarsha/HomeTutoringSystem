package com.data.queries;

public interface StudentQueries {
	
	
	public static final String FETCH_ALL_STUDENTS= "findallstudents";

	public static final String FETCH_ALL_STUDENTS_QUERY = "from StudentTutor";
	
	public static final String FETCH_STUDENT_BY_FIRSTNAME= "findstudentbyfirstname";

	public static final String FETCH_STUDENT_BY_FIRSTNAME_QUERY = "from StudentTutor i where i.firstName = :firstName ";
	
	public static final String FETCH_STUDENT_BY_LASTNAME= "findstudentbylastname";

	public static final String FETCH_STUDENT_BY_LASTNAME_QUERY = "from StudentTutor i where i.lastName = :lastName ";

}