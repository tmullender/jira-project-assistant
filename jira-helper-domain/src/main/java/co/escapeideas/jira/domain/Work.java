/**
 * 
 */
package co.escapeideas.jira.domain;

import java.util.Date;

/**
 * @author tmullender
 *
 */
public interface Work {
	
	String getUser();

	Long getTimeSpent();

	Long getTimeSpent(Date start, Date end);

}
