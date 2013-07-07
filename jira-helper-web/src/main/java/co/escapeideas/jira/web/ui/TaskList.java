/**
 * 
 */
package co.escapeideas.jira.web.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import co.escapeideas.jira.domain.Task;
import co.escapeideas.jira.domain.UseCase;

/**
 * @author tmullender
 *
 */
public class TaskList {
	
	private static final Long JIRA_HOUR = 60*60L;
	private static final Long JIRA_DAY = 8*JIRA_HOUR;
	
	private final Date start;
	private final Date end;
	
	private Map<String, Long> userTime = new HashMap<String, Long>();
	private List<Item> items = new ArrayList<Item>();
	
	public TaskList(String start, String end) {
		this.start = Formatter.toDate(start);
		this.end = Formatter.toDate(end);
	}

	/**
	 * @return the userTime
	 */
	public Map<String, Long> getUserTime() {
		return userTime;
	}

	/**
	 * @return the tasks
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param userTime the userTime to set
	 */
	public void setUserTime(Map<String, Long> userTime) {
		this.userTime = userTime;
	}

	/**
	 * @param tasks the tasks to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

	private void addUserTime(String user, Long timeSpent){
		final Long previous = userTime.put(user, timeSpent);
		if (previous != null){
			userTime.put(user, timeSpent + previous);
		}
	}
	
	private Item convert(Task task) {
		Item item = new Item();
		item.setKey(task.getKey());
		item.setTitle(task.getTitle());
		item.setTimeSpent(task.getTimeSpent(start, end)/JIRA_DAY);
		item.setTotalSpent(task.getTimeSpent()/JIRA_DAY);
		return item;
	}

	public void add(List<UseCase> useCases) {
		for (UseCase useCase:useCases){
			add(useCase);
		}
	}

	public void add(UseCase useCase) {
		Item item = convert(useCase);
		items.add(item);
		for (Task task:useCase.getTasks()){
			Item child = convert(task);
			item.addChild(child);
			for (Entry<String, Long> entry : task.getTimeSpentByUser(start, end).entrySet()){
				addUserTime(entry.getKey(), entry.getValue()/JIRA_DAY);
			}
		}
	}

	private Item convert(UseCase useCase) {
		Item item = new Item();
		item.setKey(useCase.getKey());
		item.setTitle(useCase.getTitle());
		return item;
	}

}
