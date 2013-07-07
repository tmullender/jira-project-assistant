/**
 * 
 */
package co.escapeideas.jira.dataaccess.product;

import java.util.List;

import co.escapeideas.jira.dataaccess.project.ProjectVo;

/**
 * @author tmullender
 *
 */
public interface ProductDataAccess {

	List<ProductVo> getProducts();
	
	List<ProductVo> getProducts(ProjectVo project);
	
}
