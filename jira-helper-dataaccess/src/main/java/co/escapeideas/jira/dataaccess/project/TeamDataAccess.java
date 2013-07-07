/**
 * 
 */
package co.escapeideas.jira.dataaccess.project;

import java.util.List;

/**
 * @author tmullender
 *
 */
public interface TeamDataAccess {
	
	List<TeamVo> getTeams();

	void create(TeamVo team);

	TeamVo getTeam(String key);

	void addMember(String team, String member);

	void removeMember(String team, String member);

}
