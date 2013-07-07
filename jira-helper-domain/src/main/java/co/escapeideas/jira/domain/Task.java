package co.escapeideas.jira.domain;

import java.util.Date;
import java.util.Map;

public interface Task extends ProjectItem {

	Long getTimeSpent();
	
	Long getTimeSpent(Date start, Date end);
	
	Map<String, Long> getTimeSpentByUser();
	
	Map<String, Long> getTimeSpentByUser(Date start, Date end);
	
	Integer getEstimate();
	
}
