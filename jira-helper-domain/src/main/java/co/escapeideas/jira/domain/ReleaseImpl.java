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
public class ReleaseImpl implements Release {

	private String key;
	private String title;
	private String owner;
	private String description;
	private List<Task> tasks;
	private Date start;
	private Date end;

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.domain.ProjectItem#getKey()
	 */
	@Override
	public String getKey() {
		return key;
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.domain.ProjectItem#getTitle()
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.domain.ProjectItem#getOwner()
	 */
	@Override
	public String getOwner() {
		return owner;
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.domain.ProjectItem#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.domain.Release#getTasks()
	 */
	@Override
	public List<Task> getTasks() {
		return tasks;
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.domain.Release#addUseCase(co.escapeideas.jira.domain.UseCase)
	 */
	@Override
	public void addTask(Task task) {
		tasks.add(task);
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.domain.Release#getStartDate()
	 */
	@Override
	public Date getStartDate() {
		return start;
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.domain.Release#getEndDate()
	 */
	@Override
	public Date getEndDate() {
		return end;
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.domain.Release#getAvailableTime()
	 */
	@Override
	public int getAvailableTime() {
		return 0;
	}

	public void setEndDate(Date endDate) {
		this.end = endDate;
	}

	public void setName(String name) {
		title = name;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
