/**
 * 
 */
package co.escapeideas.jira.services.common;

import java.util.List;

import co.escapeideas.jira.domain.Member;
import co.escapeideas.jira.domain.Team;

/**
 * @author tmullender
 *
 */
public interface MemberService {

	List<Member> getMembers(Team team);

	void create(String username, String name, String emailAddress);

	List<Member> getMembers();

}
