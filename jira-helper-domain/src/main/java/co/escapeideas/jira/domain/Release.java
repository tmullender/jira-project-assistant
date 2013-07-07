/**
 * 
 */
package co.escapeideas.jira.domain;

import java.util.Date;
import java.util.List;

/**
 * @author tmullender
 *
 */
public interface Release extends ProjectItem {
	
	List<Task> getTasks();
	
	void addTask(Task task);
	
	Date getStartDate();
	
	Date getEndDate();

	int getAvailableTime();	

}
