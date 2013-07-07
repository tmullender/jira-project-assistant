/**
 * 
 */
package co.escapeideas.jira.services.product;

import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.domain.Feature;
import co.escapeideas.jira.domain.Product;
import co.escapeideas.jira.domain.impl.FeatureImpl;

/**
 * @author tmullender
 *
 */
public class FeatureServiceImp implements FeatureService {

	@Override
	public List<Feature> getFeatures(Product product) {
		final List<Feature> features = new ArrayList<Feature>();
		final FeatureImpl feature = new FeatureImpl(null);
		feature.setProductKey(product.getKey());
		features.add(feature);
		return features;
	}

}
