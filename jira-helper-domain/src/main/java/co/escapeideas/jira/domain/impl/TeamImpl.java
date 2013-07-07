/**
 * 
 */
package co.escapeideas.jira.domain.impl;

import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.domain.Member;
import co.escapeideas.jira.domain.Release;
import co.escapeideas.jira.domain.Team;

/**
 * @author tmullender
 *
 */
public class TeamImpl implements Team {
	
	private List<Member> members = new ArrayList<Member>();
	private String key;
	private String title;
	private String description;

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.domain.Team#getMembers()
	 */
	@Override
	public List<Member> getMembers() {
		return members;
	}
	
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param members the members to set
	 */
	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void addMember(Member member) {
		members.add(member);
	}

	@Override
	public int getAvailability(Release release) {
		int availabilty = 0;
		for (Member member: members){
			availabilty += member.getAvailability(release);
		}
		return availabilty;
	}
}
