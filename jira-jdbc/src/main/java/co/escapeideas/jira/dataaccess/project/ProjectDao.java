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
public class ProjectDao extends JdbcDaoSupport implements ProjectDataAccess {

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.dataaccess.project.ProjectDataAccess#getProject(java.lang.String)
	 */
	@Override
	public ProjectVo getProject(String key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<ProjectVo> getProjects() {
		throw new UnsupportedOperationException();
	}

}
