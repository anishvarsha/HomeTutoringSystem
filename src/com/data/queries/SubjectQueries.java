package com.data.queries;

public interface SubjectQueries {

	public static final String FETCH_ALL_SUBJECTS= "findallsubject";

	public static final String FETCH_ALL_SUBJECTS_QUERY = "from Subject";
	
	public static final String FETCH_SUBJECT_BY_SUBJECTID= "findsubjectbysubjectId";

	public static final String FETCH_SUBJECT_BY_SUBJECTID_QUERY = "from Subject i where i.subjectId = :subjectId ";
	
}
