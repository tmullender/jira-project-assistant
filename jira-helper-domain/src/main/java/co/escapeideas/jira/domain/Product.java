package co.escapeideas.jira.domain;

import java.util.List;

public interface Product extends ProductItem {

	void addFeature(Feature feature);
	
	List<Feature> getFeatures();

}
