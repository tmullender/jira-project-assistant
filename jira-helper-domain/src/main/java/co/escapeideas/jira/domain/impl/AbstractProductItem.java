/**
 * 
 */
package co.escapeideas.jira.domain.impl;

import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.domain.ProductItem;


/**
 * @author tmullender
 *
 */
public abstract class AbstractProductItem implements ProductItem {
	
	private final String key;
	private String title;
	private String owner;
	private String description;
	
	private List<ProductItem> children = new ArrayList<ProductItem>();

	public AbstractProductItem(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
	
	public String getTitle() {
		return title;
	}

	public String getOwner() {
		return owner;
	}

	public String getDescription() {
		return description;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	protected void addChild(ProductItem item){
		this.children.add(item);
	}
	
	protected List<?> getChildren(){
		return children;
	}
	
	public String toString() {
		return this.key + "\t" + this.title;
	}

}
