/**
 * 
 */
package co.escapeideas.jira.domain.impl;

import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.domain.Feature;
import co.escapeideas.jira.domain.Product;

/**
 * @author tmullender
 *
 */
public class ProductImpl implements Product {
	
	private final String key;
	private final String project;
	private final List<Feature> features = new ArrayList<Feature>();
	private String title;
	private String owner;
	private String description;
	
	public ProductImpl(String project, String key){
		this.project = project;
		this.key = key;
	}

	public String toString() {
		return project + "-" + key + "-" + title + ":" + features.size();
	}

	@Override
	public void addFeature(Feature feature) {
		features.add(feature);
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getOwner() {
		return owner;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public List<Feature> getFeatures() {
		return features;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
