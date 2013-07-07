/**
 * 
 */
package co.escapeideas.jira.domain.impl;

import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.domain.Task;
import co.escapeideas.jira.domain.UseCase;

/**
 * @author tmullender
 *
 */
public class UseCaseImpl extends TaskImpl implements UseCase {
	
	private List<Task> tasks = new ArrayList<Task>();

	public UseCaseImpl(String key) {
		super(key);
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.domain.UseCase#addTask(co.escapeideas.jira.domain.Task)
	 */
	@Override
	public void addTask(Task task) {
		tasks.add(task);
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.domain.UseCase#getTasks()
	 */
	@Override
	public List<Task> getTasks() {
		return tasks;
	}

}
