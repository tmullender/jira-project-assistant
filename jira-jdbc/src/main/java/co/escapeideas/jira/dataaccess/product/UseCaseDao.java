/**
 * 
 */
package co.escapeideas.jira.dataaccess.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import co.escapeideas.jira.dataaccess.project.ReleaseVo;

/**
 * @author tmullender
 *
 */
public class UseCaseDao extends JdbcDaoSupport implements UseCaseDataAccess {

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.dataaccess.product.UseCaseDataAccess#getUseCases(co.escapeideas.jira.dataaccess.product.FeatureVo)
	 */
	@Override
	public List<UseCaseVo> getUseCases(FeatureVo feature) {
		final List<UseCaseVo> list = new ArrayList<UseCaseVo>();
		final UseCaseVo useCase = new UseCaseVo();
		useCase.setKey(feature.getKey());
		useCase.setTitle(feature.getTitle());
		useCase.setDescription(feature.getDescription());
		useCase.setOwner(feature.getOwner());
		useCase.setStatus(feature.getStatus());
		list.add(useCase);
		return list;
	}

	@Override
	public List<UseCaseVo> getUseCases(ReleaseVo release) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UseCaseVo> getUseCases(ReleaseVo release, FeatureVo feature) {
		// TODO Auto-generated method stub
		return null;
	}

}
