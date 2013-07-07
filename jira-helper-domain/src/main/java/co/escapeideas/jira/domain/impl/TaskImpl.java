/**
 * 
 */
package co.escapeideas.jira.domain.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.escapeideas.jira.domain.Task;
import co.escapeideas.jira.domain.Work;

/**
 * @author tmullender
 *
 */
public class TaskImpl extends AbstractProductItem implements Task {
	
	private String status;
	private Integer estimate;
	private List<Work> work = new ArrayList<Work>();

	public TaskImpl(String key) {
		super(key);
	}


	@Override
	public Integer getEstimate() {
		return estimate;
	}
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	public void setEstimate(Integer estimate) {
		this.estimate = estimate;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param timeSpent the timeSpent to set
	 */

	public String toString() {
		return "\n\t\t" + super.toString() + " status: " + status;
	}

	/**
	 * @return the timeSpent
	 */
	@Override
	public Long getTimeSpent() {
		long timeSpent = 0;
		for (Work item : work){
			timeSpent += item.getTimeSpent();
		}
		return timeSpent;
	}

	public void add(Work work) {
		this.work.add(work);
	}
	
	@Override
	public Long getTimeSpent(Date start, Date end) {
		long timeSpent = 0;
		for (Work item : work){
			timeSpent += item.getTimeSpent(start, end);
		}
		return timeSpent;
	}

	@Override
	public Map<String, Long> getTimeSpentByUser() {
		final Map<String, Long> timeSpent = new HashMap<String, Long>();
		for (Work item : work){
			Long previous = timeSpent.put(item.getUser(), item.getTimeSpent());
			if (previous != null){
				timeSpent.put(item.getUser(), previous + item.getTimeSpent());
			}
		}
		return timeSpent;
	}

	@Override
	public Map<String, Long> getTimeSpentByUser(Date start, Date end) {
		final Map<String, Long> timeSpent = new HashMap<String, Long>();
		for (Work item : work){
			Long time = item.getTimeSpent(start, end);
			Long previous = timeSpent.put(item.getUser(), time);
			if (previous != null){
				timeSpent.put(item.getUser(), previous + time);
			}
		}
		return timeSpent;
	}


}
