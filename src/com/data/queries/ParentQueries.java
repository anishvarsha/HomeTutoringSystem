package com.data.queries;

public interface ParentQueries {
	
	public static final String FETCH_ALL_PARENTS= "findallparents";

	public static final String FETCH_ALL_PARENTS_QUERY = "from ParentTutor";
	
	public static final String FETCH_PARENT_BY_FIRSTNAME= "findparentsbyfirstname";

	public static final String FETCH_PARENT_BY_FIRSTNAME_QUERY = "from ParentTutor i where i.firstName = :firstName ";
	
	public static final String FETCH_PARENT_BY_LASTNAME= "findparentsbylastname";

	public static final String FETCH_PARENT_BY_LASTNAME_QUERY = "from ParentTutor i where i.lastName = :lastName ";
	
	/*public static final String FETCH_PARENT_BY_PARENTID= "findparentsbyparentId";

	public static final String FETCH_PARENT_BY_PARENTID_QUERY = "from ParentTutor i where i.parentId = :parentId ";*/

}
