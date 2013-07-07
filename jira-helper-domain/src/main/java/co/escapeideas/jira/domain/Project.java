/**
 * 
 */
package co.escapeideas.jira.domain;

import java.util.List;

/**
 * @author tmullender
 *
 */
public interface Project extends ProjectItem {
	
	void addReleases(List<Release> releases);
	
	void addProducts(List<Product> products);
	
	List<Release> getReleases();

	List<Product> getProducts();

}
