package com.data.queries;

public interface JobQueries {

	
	public static final String FETCH_All_JOBS = "findalljobs";

	public static final String FETCH_All_JOBS_QUERY = "from Job";
	
	public static final String FETCH_JOBS_BY_JOBID = "findjobbyjobid";

	public static final String FETCH_JOBS_BY_JOBID_QUERY = "from Job i where i.jobId = :jobId ";
/*	
	public static final String FETCH_JOBS_BY_PARENTID = "findjobbyparentid";

	public static final String FETCH_JOBS_BY_PARENTID_QUERY = "from Job i where i.parentId = :parentId ";*/
	/*
	public static final String FETCH_JOBS_BY_SUBJECTID = "findsubjectbysubjectidinJob";

	public static final String FETCH_JOBS_BY_SUBJECTID_QUERY = "from Job i where i.subjectId = :subjectId ";
	*/
}
