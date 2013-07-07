/**
 * 
 */
package co.escapeideas.jira.services.common;

import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.dataaccess.project.TeamDataAccess;
import co.escapeideas.jira.dataaccess.project.TeamVo;
import co.escapeideas.jira.domain.Member;
import co.escapeideas.jira.domain.Team;
import co.escapeideas.jira.domain.impl.TeamImpl;

/**
 * @author tmullender
 *
 */
public class TeamServiceImpl implements TeamService {
	
	private TeamDataAccess teamDao;
	
	private MemberService memberService;

	/**
	 * @return the teamDao
	 */
	public TeamDataAccess getTeamDao() {
		return teamDao;
	}

	/**
	 * @return the memberService
	 */
	public MemberService getMemberService() {
		return memberService;
	}

	/**
	 * @param teamDao the teamDao to set
	 */
	public void setTeamDao(TeamDataAccess teamDao) {
		this.teamDao = teamDao;
	}

	/**
	 * @param memberService the memberService to set
	 */
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.services.project.TeamService#getTeams()
	 */
	@Override
	public List<Team> getTeams() {
		final List<Team> teams = new ArrayList<Team>();
		for (TeamVo vo:teamDao.getTeams()){
			teams.add(convert(vo));
		}
		return teams;
	}

	@Override
	public void create(String title, String description) {
		TeamVo team = new TeamVo();
		team.setTitle(title);
		team.setDescription(description);
		teamDao.create(team);
	}
	
	@Override
	public Team getTeam(String key) {
		return convert(teamDao.getTeam(key));
	}
	
	private Team convert(TeamVo vo) {
		final TeamImpl team = new TeamImpl();
		team.setKey(vo.getKey());
		team.setTitle(vo.getTitle());
		team.setDescription(vo.getDescription());
		team.setMembers(memberService.getMembers(team));
		return team;
	}

	@Override
	public void addMember(Team team, Member member) {
		teamDao.addMember(team.getKey(), member.getKey());
	}

	@Override
	public void removeMember(Team team, Member member) {
		teamDao.removeMember(team.getKey(), member.getKey());
	}

}
