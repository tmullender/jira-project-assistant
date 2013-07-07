/**
 * 
 */
package co.escapeideas.jira.dataaccess.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import co.escapeideas.jira.dataaccess.project.TeamVo;

/**
 * @author tmullender
 *
 */
public class MemberDao extends JdbcDaoSupport implements MemberDataAccess {
	
	class MemberMapper implements ParameterizedRowMapper<MemberVo> {

		@Override
		public MemberVo mapRow(ResultSet result, int row) throws SQLException {
			final MemberVo vo = new MemberVo();
			vo.setKey(result.getString("MKEY"));
			vo.setName(result.getString("NAME"));
			vo.setEmailAddress(result.getString("EMAIL"));
			return vo;
		}
		
	}
	
	private static final String SELECT_BY_TEAM = "SELECT M.* FROM MEMBERS M, TEAM_MEMBERS T WHERE M.MKEY=T.MEMBER_KEY AND T.TEAM_KEY = ?";
	private static final String INSERT_MEMBER = "INSERT INTO MEMBERS VALUES (?, ?, ?)";
	private static final String SELECT_ALL = "SELECT * FROM MEMBERS";

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.dataaccess.common.MemberDataAccess#getMembers(co.escapeideas.jira.dataaccess.project.TeamVo)
	 */
	@Override
	public List<MemberVo> getMembers(TeamVo team) {
		return getJdbcTemplate().query(SELECT_BY_TEAM, new String[]{team.getKey()}, new MemberMapper());
	}

	@Override
	public void create(MemberVo vo) {
		getJdbcTemplate().update(INSERT_MEMBER, vo.getKey(), vo.getName(), vo.getEmailAddress());
	}

	@Override
	public List<MemberVo> getMembers() {
		return getJdbcTemplate().query(SELECT_ALL, new MemberMapper());
	}

}
