/**
 * 
 */
package co.escapeideas.jira.dataaccess.project;

import java.util.List;

/**
 * @author tmullender
 *
 */
public interface ProjectDataAccess {
	
	ProjectVo getProject(String key);

	List<ProjectVo> getProjects();

}
