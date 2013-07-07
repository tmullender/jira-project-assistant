/**
 * 
 */
package co.escapeideas.jira.dataaccess.project;

import java.util.Date;

/**
 * @author tmullender
 *
 */
public class ReleaseVo {
	
	private String key;
	private String name;
	private Date endDate;
	private String product = "SOP";

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getProduct() {
		return product;
	}

}
