/**
 * 
 */
package co.escapeideas.jira.dataaccess.common;

import java.util.Date;

/**
 * @author tmullender
 *
 */
public class WorkVo {
	
	private String author;
	private Date start;
	private Long timeSpent;
	private String comment;
	
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * @return the start
	 */
	public Date getStart() {
		return start;
	}
	
	/**
	 * @return the timeSpent
	 */
	public Long getTimeSpent() {
		return timeSpent;
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
	 * @param start the start to set
	 */
	public void setStart(Date start) {
		this.start = start;
	}
	
	/**
	 * @param timeSpent the timeSpent to set
	 */
	public void setTimeSpent(Long timeSpent) {
		this.timeSpent = timeSpent;
	}
	
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}
