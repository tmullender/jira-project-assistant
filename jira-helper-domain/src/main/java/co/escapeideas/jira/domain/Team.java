/**
 * 
 */
package co.escapeideas.jira.domain;

import java.util.List;

/**
 * @author tmullender
 *
 */
public interface Team {
	
	List<Member> getMembers();
	
//	void addMember(Member member);
	
	int getAvailability(Release release);

	String getKey();

}
