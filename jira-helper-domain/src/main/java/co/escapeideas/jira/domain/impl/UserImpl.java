package co.escapeideas.jira.domain.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.escapeideas.jira.domain.Release;
import co.escapeideas.jira.domain.User;

public class UserImpl extends MemberImpl implements User{
	
	private String username;
	private String password;
	private String token;
	
	private List<Date> unavailable = new ArrayList<Date>();
	
	public UserImpl (String username, String password){
		setUsername(username);
		setPassword(password);
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getToken() {
		return token;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public boolean isLoggedIn(){
		return token != null;
	}

	@Override
	public int getAvailability(Release release) {
		int count = release.getAvailableTime();
		for (Date date : unavailable){
			if (date.equals(release.getStartDate()) || (date.after(release.getStartDate()) && date.before(release.getEndDate()))){
				count--;
			}
		}
		return count;
	}

}
