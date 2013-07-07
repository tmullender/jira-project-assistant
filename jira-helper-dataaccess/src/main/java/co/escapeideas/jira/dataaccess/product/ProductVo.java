/**
 * 
 */
package co.escapeideas.jira.dataaccess.product;

/**
 * @author tmullender
 *
 */
public class ProductVo {

	private String name;
	private String key;
	private String description;
	private String lead;
	private String project;

	public String getName() {
		return name;
	}

	public String getKey() {
		return key;
	}

	public String getDescription() {
		return description;
	}

	public String getLead() {
		return lead;
	}

	public void setName(String name) {
		this.name = name;	
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLead(String lead) {
		this.lead = lead;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

}
