/**
 * 
 */
package co.escapeideas.jira.wsdl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.dataaccess.product.ProductDataAccess;
import co.escapeideas.jira.dataaccess.product.ProductVo;
import co.escapeideas.jira.dataaccess.project.ProjectVo;

/**
 * @author tmullender
 *
 */
public class ProductDao implements ProductDataAccess {
	
	private JiraSoapService service;

	/**
	 * @return the service
	 */
	public JiraSoapService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(JiraSoapService service) {
		this.service = service;
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.dataaccess.product.ProductDataAccess#getProducts()
	 */
	@Override
	public List<ProductVo> getProducts() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<ProductVo> getProducts(ProjectVo project) {
		final List<ProductVo> products = new ArrayList<ProductVo>();
		try {
			for (RemoteComponent component : service.getComponents(TokenFactory.getToken(), project.getKey())){
				products.add(convert(component, project));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
		return products;
	}

	private ProductVo convert(RemoteComponent component, ProjectVo project) {
		final ProductVo product = new ProductVo();
		product.setProject(project.getKey());
		product.setKey(component.getId());
		product.setName(component.getName());
		return product;
	}


}
