/**
 * 
 */
package co.escapeideas.jira.dataaccess.common;

import java.util.List;

/**
 * @author tmullender
 *
 */
public abstract class AbstractIssueVo {

	private String description;
	private String key;
	private String title;
	private String owner;
	private String status;
	
	private List<WorkVo> works;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public void getDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the works
	 */
	public List<WorkVo> getWorks() {
		return works;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	/**
	 * @param works the works to set
	 */
	public void setWorks(List<WorkVo> works) {
		this.works = works;
	}

}
