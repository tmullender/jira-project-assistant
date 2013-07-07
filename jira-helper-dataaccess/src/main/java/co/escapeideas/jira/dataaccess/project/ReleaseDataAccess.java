/**
 * 
 */
package co.escapeideas.jira.dataaccess.project;

import java.util.List;

/**
 * @author tmullender
 *
 */
public interface ReleaseDataAccess {

	List<ReleaseVo> getReleases(ProjectVo project);
}
