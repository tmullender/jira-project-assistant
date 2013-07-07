/**
 * 
 */
package co.escapeideas.jira.domain.impl;

import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.domain.Product;
import co.escapeideas.jira.domain.Project;
import co.escapeideas.jira.domain.Release;

/**
 * @author tmullender
 *
 */
public class ProjectImpl implements Project {
	
	private String description;
	private String key;
	private String owner;
	private String title;
	
	private List<Release> releases = new ArrayList<Release>();
	private List<Product> products = new ArrayList<Product>();

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.domain.ProjectItem#getKey()
	 */
	@Override
	public String getKey() {
		return key;
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.domain.ProjectItem#getTitle()
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.domain.ProjectItem#getOwner()
	 */
	@Override
	public String getOwner() {
		return owner;
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.domain.ProjectItem#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.domain.Project#getReleases()
	 */
	@Override
	public List<Release> getReleases() {
		return releases;
	}

	@Override
	public List<Product> getProducts() {
		return products ;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param releases the releases to set
	 */
	public void setReleases(List<Release> releases) {
		this.releases = releases;
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.domain.Project#addRelease()
	 */
	@Override
	public void addReleases(List<Release> releases) {
		this.releases.addAll(releases);
	}

	@Override
	public void addProducts(List<Product> products) {
		this.products.addAll(products);
	}
}


