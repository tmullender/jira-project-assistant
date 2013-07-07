/**
 * 
 */
package co.escapeideas.jira.web.ui;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tmullender
 *
 */
public class Item {
	
	private String key;
	private String title;
	private Long timeSpent = 0L;
	private Long totalSpent = 0L;
	private List<Item> children = new ArrayList<Item>();
	
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
	 * @return the timeSpent
	 */
	public Long getTimeSpent() {
		return timeSpent;
	}
	/**
	 * @return the totalSpent
	 */
	public Long getTotalSpent() {
		return totalSpent;
	}
	/**
	 * @return the children
	 */
	public List<Item> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Item> children) {
		this.children = children;
	}

	/**
	 * @param key the key to set
	 */
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
	 * @param timeSpent the timeSpent to set
	 */
	public void setTimeSpent(Long timeSpent) {
		this.timeSpent = timeSpent;
	}
	/**
	 * @param totalSpent the totalSpent to set
	 */
	public void setTotalSpent(Long totalSpent) {
		this.totalSpent = totalSpent;
	}
	
	public void addChild(Item item){
		timeSpent += item.timeSpent;
		totalSpent += item.totalSpent;
		children.add(item);
	}
	
}

