/**
 * 
 */
package co.escapeideas.jira.wsdl;

import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.dataaccess.common.TaskDataAccess;
import co.escapeideas.jira.dataaccess.common.TaskVo;
import co.escapeideas.jira.dataaccess.product.UseCaseVo;
import co.escapeideas.jira.dataaccess.project.ReleaseVo;

/**
 * @author tmullender
 *
 */
public class TaskDao extends AbstractIssueDao implements TaskDataAccess {

	private static final String TASKS_BY_PARENT = "type = 'Sub-task' and parent = ?";
	private static final String TASKS_BY_RELEASE = "type = 'Sub-task' and fixVersion = ?";

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.dataaccess.common.TaskDataAccess#getTasks(co.escapeideas.jira.dataaccess.product.UseCaseVo)
	 */
	@Override
	public List<TaskVo> getTasks(UseCaseVo useCase) {
		final String query = getQueryCreator().createQuery(TASKS_BY_PARENT, useCase.getKey());
		return getTasks(query);
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.dataaccess.common.TaskDataAccess#getTasks(co.escapeideas.jira.dataaccess.project.ReleaseVo)
	 */
	@Override
	public List<TaskVo> getTasks(ReleaseVo release) {
		final String query = getQueryCreator().createQuery(TASKS_BY_RELEASE, release.getKey());
		return getTasks(query);
	}
	
	private List<TaskVo> getTasks(String query) {
		final List<TaskVo> issues = new ArrayList<TaskVo>();
		for (RemoteIssue issue : getIssues(query)) {
				issues.add(convert(issue));
		}
		return issues;
	}
	
	private TaskVo convert(RemoteIssue issue) {
		final TaskVo vo = new TaskVo();
		vo.setDescription(issue.getDescription());
		vo.setKey(issue.getKey());
		vo.setTitle(issue.getSummary());
		vo.setOwner(issue.getAssignee());
		vo.setStatus(issue.getStatus());
		getWorklogs(vo);
		return vo;
	}


}
