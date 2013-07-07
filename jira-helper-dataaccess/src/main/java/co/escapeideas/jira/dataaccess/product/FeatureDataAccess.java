/**
 * 
 */
package co.escapeideas.jira.dataaccess.product;

import java.util.List;

/**
 * @author tmullender
 *
 */
public interface FeatureDataAccess {
	
	List<FeatureVo> getFeatures(ProductVo product);

}
