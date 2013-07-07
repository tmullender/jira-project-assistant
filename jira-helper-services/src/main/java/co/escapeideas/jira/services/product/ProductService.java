/**
 * 
 */
package co.escapeideas.jira.services.product;

import java.util.List;

import co.escapeideas.jira.domain.Product;
import co.escapeideas.jira.domain.Project;

/**
 * @author tmullender
 *
 */
public interface ProductService {
	
	List<Product> getProducts(Project project, boolean loadChildren);

}
