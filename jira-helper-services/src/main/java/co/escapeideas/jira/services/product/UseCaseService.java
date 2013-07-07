/**
 * 
 */
package co.escapeideas.jira.services.product;

import java.util.List;

import co.escapeideas.jira.domain.Feature;
import co.escapeideas.jira.domain.Release;
import co.escapeideas.jira.domain.UseCase;

/**
 * @author tmullender
 *
 */
public interface UseCaseService {
	
	List<UseCase> getUseCases(Release release, Feature feature);

}
