/**
 * 
 */
package co.escapeideas.jira.dataaccess.product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import co.escapeideas.jira.dataaccess.project.ProjectVo;

/**
 * @author tmullender
 *
 */
public class ProductDao extends JdbcDaoSupport implements ProductDataAccess {

	protected class Mapper implements ParameterizedRowMapper<ProductVo> {

		@Override
		public ProductVo mapRow(ResultSet result, int row) throws SQLException {
			final ProductVo product = new ProductVo();
			product.setKey(result.getString("PKEY"));
			product.setName(result.getString("PNAME"));
			product.setDescription(result.getString("DESCRIPTION"));
			product.setLead(result.getString("LEAD"));
			return product;
		}

	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.dataaccess.product.ProductDataAccess#getProducts()
	 */
	@Override
	public List<ProductVo> getProducts() {
		return getJdbcTemplate().query("select * from project", new Mapper());
	}

	@Override
	public List<ProductVo> getProducts(ProjectVo project) {
		// TODO Auto-generated method stub
		return null;
	}

}
