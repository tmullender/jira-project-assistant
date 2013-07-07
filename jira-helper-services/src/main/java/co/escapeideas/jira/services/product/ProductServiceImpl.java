/**
 * 
 */
package co.escapeideas.jira.services.product;

import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.dataaccess.product.ProductDataAccess;
import co.escapeideas.jira.dataaccess.product.ProductVo;
import co.escapeideas.jira.dataaccess.project.ProjectVo;
import co.escapeideas.jira.domain.Product;
import co.escapeideas.jira.domain.Project;
import co.escapeideas.jira.domain.impl.ProductImpl;

/**
 * @author tmullender
 *
 */
public class ProductServiceImpl implements ProductService {
	
	private ProductDataAccess productData;

	/**
	 * @return the productData
	 */
	public ProductDataAccess getProductData() {
		return productData;
	}

	/**
	 * @param productData the productData to set
	 */
	public void setProductData(ProductDataAccess productData) {
		this.productData = productData;
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.services.product.ProductService#getProducts(co.escapeideas.jira.domain.Project, boolean)
	 */
	@Override
	public List<Product> getProducts(Project project, boolean loadChildren) {
		final List<Product> products = new ArrayList<Product>();
		for (ProductVo product : productData.getProducts(convert(project))){
			products.add(convert(product, loadChildren));
		}
		return products;
	}
	
	private Product convert(ProductVo vo, boolean loadChildren) {
		final ProductImpl product = new ProductImpl(vo.getProject(), vo.getKey());
		product.setTitle(vo.getName());
		return product;
	}

	private ProjectVo convert(Project project) {
		final ProjectVo vo = new ProjectVo();
		vo.setKey(project.getKey());
		return vo;
	}


}
