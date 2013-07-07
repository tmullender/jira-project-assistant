/**
 * 
 */
package co.escapeideas.jira.dataaccess.project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author tmullender
 *
 */
public class TeamDao extends JdbcDaoSupport implements TeamDataAccess {
	
	class TeamMapper implements ParameterizedRowMapper<TeamVo> {

		@Override
		public TeamVo mapRow(ResultSet result, int row) throws SQLException {
			final TeamVo vo = new TeamVo();
			vo.setKey(result.getString("TKEY"));
			vo.setDescription(result.getString("DESCRIPTION"));
			vo.setTitle(result.getString("TITLE"));
			return vo;
		}
		
	}

	private static final String SELECT_TEAMS = "SELECT * FROM TEAMS";
	private static final String SELECT_BY_KEY = "SELECT * FROM TEAMS WHERE TKEY = ?";

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.dataaccess.project.TeamDataAccess#getTeams()
	 */
	@Override
	public List<TeamVo> getTeams() {
		return getJdbcTemplate().query(SELECT_TEAMS, new TeamMapper());
	}

	@Override
	public void create(TeamVo team) {
		getJdbcTemplate().update("insert into teams(title, description) values (?, ?)", team.getTitle(), team.getDescription());
	}

	@Override
	public TeamVo getTeam(String key) {
		return getJdbcTemplate().queryForObject(SELECT_BY_KEY, new String[]{key}, new TeamMapper());
	}

	@Override
	public void addMember(String team, String member) {
		getJdbcTemplate().update("insert into team_members(team_key, member_key) values (?, ?)", team, member);
	}

	@Override
	public void removeMember(String team, String member) {
		getJdbcTemplate().update("delete from team_members where team_key = ? and member_key = ?", team, member);
	}

}
