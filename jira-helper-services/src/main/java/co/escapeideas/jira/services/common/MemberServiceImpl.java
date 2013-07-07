/**
 * 
 */
package co.escapeideas.jira.services.common;

import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.dataaccess.common.MemberDataAccess;
import co.escapeideas.jira.dataaccess.common.MemberVo;
import co.escapeideas.jira.dataaccess.project.TeamVo;
import co.escapeideas.jira.domain.Member;
import co.escapeideas.jira.domain.Team;
import co.escapeideas.jira.domain.impl.MemberImpl;

/**
 * @author tmullender
 *
 */
public class MemberServiceImpl implements MemberService {

	private MemberDataAccess memberDao;
	/**
	 * @return the memberDao
	 */
	public MemberDataAccess getMemberDao() {
		return memberDao;
	}

	/**
	 * @param memberDao the memberDao to set
	 */
	public void setMemberDao(MemberDataAccess memberDao) {
		this.memberDao = memberDao;
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.services.common.MemberService#getMembers(co.escapeideas.jira.domain.Team)
	 */
	@Override
	public List<Member> getMembers(Team team) {
		final List<Member> members = new ArrayList<Member>();
		for (MemberVo vo:memberDao.getMembers(convert(team))){
			members.add(convert(vo));
		}
		return members;
	}

	@Override
	public List<Member> getMembers() {
		final List<Member> members = new ArrayList<Member>();
		for (MemberVo vo:memberDao.getMembers()){
			members.add(convert(vo));
		}
		return members;
	}
	
	@Override
	public void create(String username, String name, String emailAddress) {
		MemberVo vo = new MemberVo();
		vo.setKey(username);
		vo.setName(name);
		vo.setEmailAddress(emailAddress);
		memberDao.create(vo);
	}
	
	private Member convert(MemberVo vo) {
		final MemberImpl member = new MemberImpl();
		member.setKey(vo.getKey());
		member.setEmailAddress(vo.getEmailAddress());
		member.setName(vo.getName());
		return member;
	}

	private TeamVo convert(Team team) {
		final TeamVo vo = new TeamVo();
		vo.setKey(team.getKey());
		return vo;
	}

}
