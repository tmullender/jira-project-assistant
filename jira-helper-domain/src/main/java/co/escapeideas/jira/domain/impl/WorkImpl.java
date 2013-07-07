/**
 * 
 */
package co.escapeideas.jira.domain.impl;

import java.util.Date;

import co.escapeideas.jira.domain.Work;

/**
 * @author tmullender
 *
 */
public class WorkImpl implements Work {
	
	private String author;
	private Long timeSpent;
	private Date start;
	private String comment;
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @return the timeSpent
	 */
	public Long getTimeSpent() {
		return timeSpent;
	}
	/**
	 * @return the start
	 */
	public Date getStart() {
		return start;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @param timeSpent the timeSpent to set
	 */
	public void setTimeSpent(Long timeSpent) {
		this.timeSpent = timeSpent;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(Date start) {
		this.start = start;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public Long getTimeSpent(Date start, Date end) {
		if (start == null || end == null){
			return timeSpent;
		}
		Long myStart = start.getTime();
		Long myEnd = end.getTime();
		Long startTime = this.start.getTime();
		if (startTime > myStart){
			myStart = startTime;
		}
		if (startTime + timeSpent < myEnd){
			myEnd = startTime + timeSpent;
		}
		if (myEnd - myStart < 0){
			return 0L;
		}
		return myEnd - myStart;
	}
	
	@Override
	public String getUser() {
		return getAuthor();
	}

}
