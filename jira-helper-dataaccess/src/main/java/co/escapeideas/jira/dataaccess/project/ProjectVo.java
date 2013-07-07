/**
 * 
 */
package co.escapeideas.jira.dataaccess.project;

/**
 * @author tmullender
 *
 */
public class ProjectVo {
	
	private String description;
	private String key;
	private String title;

	public String getDescription() {
		return description;
	}

	public String getKey() {
		return key;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
