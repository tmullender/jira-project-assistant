/**
 * 
 */
package co.escapeideas.jira.domain;

import java.util.List;

/**
 * @author tmullender
 *
 */
public interface UseCase extends ProductItem {
	
	void addTask(Task task);
	
	List<Task> getTasks();

}
