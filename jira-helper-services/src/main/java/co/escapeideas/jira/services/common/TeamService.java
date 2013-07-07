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
public interface TeamService {

	List<Team> getTeams();

	void create(String title, String description);

	Team getTeam(String key);
	
	void addMember(Team team, Member member);

	void removeMember(Team team, Member member);

}
