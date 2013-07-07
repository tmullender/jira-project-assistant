/**
 * 
 */
package co.escapeideas.jira.dataaccess.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import co.escapeideas.jira.dataaccess.product.UseCaseVo;
import co.escapeideas.jira.dataaccess.project.ReleaseVo;

/**
 * @author tmullender
 *
 */
public class TaskDao extends JdbcDaoSupport implements TaskDataAccess {

	/**
	 * @author tmullender
	 *
	 */
	public class Mapper implements ParameterizedRowMapper<TaskVo> {
		@Override
		public TaskVo mapRow(ResultSet result, int row) throws SQLException {
			final TaskVo task = new TaskVo();
			task.setKey(result.getString(""));
			task.getDescription(result.getString(""));
			return task;
		}
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.dataaccess.common.TaskDataAccess#getTasks(co.escapeideas.jira.dataaccess.product.UseCaseVo)
	 */
	@Override
	public List<TaskVo> getTasks(UseCaseVo useCase) {
		return getJdbcTemplate().query("", new String[]{}, new Mapper());
	}

	@Override
	public List<TaskVo> getTasks(ReleaseVo release) {
		return new ArrayList<TaskVo>();
	}

}
