/**
 * 
 */
package co.escapeideas.jira.dataaccess.project;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author tmullender
 *
 */
public class ReleaseDao extends JdbcDaoSupport implements ReleaseDataAccess {

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.dataaccess.project.ReleaseDataAccess#getReleases(co.escapeideas.jira.dataaccess.project.ProjectVo)
	 */
	@Override
	public List<ReleaseVo> getReleases(ProjectVo project) {
		throw new UnsupportedOperationException();
	}

}
