/**
 * 
 */
package co.escapeideas.jira.dataaccess.product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author tmullender
 *
 */
public class FeatureDao extends JdbcDaoSupport implements FeatureDataAccess {
	
	private static final String SELECT_ISSUE_BY_TYPE_AND_COMPONENT = "SELECT j.*, s.pname " +
			"FROM nodeassociation n, component c, jiraissue j, issuetype i, issuestatus s " +
			"WHERE c.ID = n.SINK_NODE_ID " +
			"AND j.id = n.SOURCE_NODE_ID " +
			"AND i.id = j.issuetype " +
			"AND s.id = j.issuestatus " +
			"AND n.ASSOCIATION_TYPE = ? " +
			"AND c.cname = ? " +
			"AND i.pname = ?";

	/**
	 * @author tmullender
	 *
	 */
	public class Mapper implements ParameterizedRowMapper<FeatureVo> {

		@Override
		public FeatureVo mapRow(ResultSet result, int row) throws SQLException {
			final FeatureVo feature = new FeatureVo();
			feature.setKey(result.getString("PKEY"));
			feature.setTitle(result.getString("SUMMARY"));
			feature.setDescription(result.getString("DESCRIPTION"));
			feature.setOwner(result.getString("REPORTER"));
			feature.setAllocatedTime(result.getLong("TIMEORIGINALESTIMATE"));
			feature.setStatus(result.getString("PNAME"));
			return feature;
		}

	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.dataaccess.product.FeatureDataAccess#getFeatures(co.escapeideas.jira.dataaccess.product.ProductVo)
	 */
	@Override
	public List<FeatureVo> getFeatures(ProductVo product) {
		return getJdbcTemplate().query(SELECT_ISSUE_BY_TYPE_AND_COMPONENT, new String[]{"IssueComponent", product.getKey(), "Story"}, new Mapper());
	}

}
