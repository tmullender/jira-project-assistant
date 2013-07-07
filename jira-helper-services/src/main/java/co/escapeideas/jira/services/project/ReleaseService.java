/**
 * 
 */
package co.escapeideas.jira.services.project;

import java.util.List;

import co.escapeideas.jira.domain.Project;
import co.escapeideas.jira.domain.Release;

/**
 * @author tmullender
 *
 */
public interface ReleaseService {
	
	List<Release> getReleases(Project project, boolean loadChildren);

}
