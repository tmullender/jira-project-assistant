/**
 * 
 */
package co.escapeideas.jira.dataaccess.product;

import java.util.List;

import co.escapeideas.jira.dataaccess.project.ReleaseVo;


/**
 * @author tmullender
 *
 */
public interface UseCaseDataAccess {
	
	List<UseCaseVo> getUseCases(FeatureVo feature);
	
	List<UseCaseVo> getUseCases(ReleaseVo release);
	
	List<UseCaseVo> getUseCases(ReleaseVo release, FeatureVo feature);
	
}
