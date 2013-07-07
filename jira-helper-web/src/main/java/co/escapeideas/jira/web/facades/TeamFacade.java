/**
 * 
 */
package co.escapeideas.jira.web.facades;

import co.escapeideas.jira.domain.impl.MemberImpl;
import co.escapeideas.jira.domain.impl.TeamImpl;
import co.escapeideas.jira.services.common.TeamService;

/**
 * @author tmullender
 *
 */
public class TeamFacade {
	
	private TeamService teamService;

	/**
	 * @return the teamService
	 */
	public TeamService getTeamService() {
		return teamService;
	}

	/**
	 * @param teamService the teamService to set
	 */
	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}
	
	public void addTeamMember(String team, String member){
		TeamImpl teamImpl = new TeamImpl();
		teamImpl.setKey(team);
		MemberImpl memberImpl = new MemberImpl();
		memberImpl.setKey(member);
		teamService.addMember(teamImpl, memberImpl);
	}

	public void removeTeamMember(String team, String member){
		TeamImpl teamImpl = new TeamImpl();
		teamImpl.setKey(team);
		MemberImpl memberImpl = new MemberImpl();
		memberImpl.setKey(member);
		teamService.removeMember(teamImpl, memberImpl);
	}

}
