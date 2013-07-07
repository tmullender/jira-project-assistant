/**
 * 
 */
package co.escapeideas.jira.services.product;

import java.util.List;

import co.escapeideas.jira.domain.Feature;
import co.escapeideas.jira.domain.Product;

/**
 * @author tmullender
 *
 */
public interface FeatureService {
	
	List<Feature> getFeatures(Product product);

}
