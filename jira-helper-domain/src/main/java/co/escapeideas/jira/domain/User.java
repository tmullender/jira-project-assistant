package co.escapeideas.jira.domain;

public interface User extends Member {
	
	String getUsername();
	
	String getPassword();
	
	String getToken();

	void setToken(String token);

	boolean isLoggedIn();

}
