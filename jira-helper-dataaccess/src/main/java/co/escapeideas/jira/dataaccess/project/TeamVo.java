/**
 * 
 */
package co.escapeideas.jira.dataaccess.project;

/**
 * @author tmullender
 *
 */
public class TeamVo {

	private String key;
	private String title;
	private String description;

	public String getKey() {
		return key;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
