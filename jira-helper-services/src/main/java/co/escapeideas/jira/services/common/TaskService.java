/**
 * 
 */
package co.escapeideas.jira.services.common;

import java.util.List;

import co.escapeideas.jira.domain.Release;
import co.escapeideas.jira.domain.Task;
import co.escapeideas.jira.domain.UseCase;

/**
 * @author tmullender
 *
 */
public interface TaskService {
	
	List<Task> getTasks(Release release);
	
	List<Task> getTasks(UseCase useCase);

}
