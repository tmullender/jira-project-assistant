/**
 * 
 */
package co.escapeideas.jira.wsdl;

import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.dataaccess.product.FeatureVo;
import co.escapeideas.jira.dataaccess.product.UseCaseDataAccess;
import co.escapeideas.jira.dataaccess.product.UseCaseVo;
import co.escapeideas.jira.dataaccess.project.ReleaseVo;

/**
 * @author tmullender
 *
 */
public class StoryDao extends AbstractIssueDao implements UseCaseDataAccess {
	
	private static final String STORIES_BY_RELEASE_AND_PRODUCT = "type = 'Story' and fixVersion = ? and component = ?";
	private static final String STORIES_BY_RELEASE = "type = 'Story' and fixVersion = ?";
	/* (non-Javadoc)
	 * @see co.escapeideas.jira.dataaccess.common.TaskDataAccess#getTasks(co.escapeideas.jira.dataaccess.project.ReleaseVo)
	 */
	@Override
	public List<UseCaseVo> getUseCases(ReleaseVo release, FeatureVo feature) {
		final String query = getQueryCreator().createQuery(STORIES_BY_RELEASE_AND_PRODUCT, release.getKey(), feature.getProduct());
		return getStories(query);
	}

	@Override
	public List<UseCaseVo> getUseCases(ReleaseVo release) {
		final String query = getQueryCreator().createQuery(STORIES_BY_RELEASE, release.getKey());
		return getStories(query);
	}

	@Override
	public List<UseCaseVo> getUseCases(FeatureVo feature) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<UseCaseVo> getStories(String query) {
		final List<UseCaseVo> issues = new ArrayList<UseCaseVo>();
		for (RemoteIssue issue : getIssues(query)) {
				issues.add(convert(issue));
		}
		return issues;
	}
	
	private UseCaseVo convert(RemoteIssue issue) {
		final UseCaseVo vo = new UseCaseVo();
		vo.setDescription(issue.getDescription());
		vo.setKey(issue.getKey());
		vo.setTitle(issue.getSummary());
		vo.setOwner(issue.getAssignee());
		vo.setStatus(issue.getStatus());
		getWorklogs(vo);
		return vo;
	}

	
}
