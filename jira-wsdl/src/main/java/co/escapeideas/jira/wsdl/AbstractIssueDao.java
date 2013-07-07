/**
 * 
 */
package co.escapeideas.jira.wsdl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.dataaccess.common.AbstractIssueVo;
import co.escapeideas.jira.dataaccess.common.WorkVo;

/**
 * @author tmullender
 *
 */
public abstract class AbstractIssueDao {
	
	private JiraSoapService service;
	private QueryCreator queryCreator;
	
	/**
	 * @return the service
	 */
	public JiraSoapService getService() {
		return service;
	}

	/**
	 * @return the queryCreator
	 */
	public QueryCreator getQueryCreator() {
		return queryCreator;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(JiraSoapService service) {
		this.service = service;
	}

	/**
	 * @param queryCreator the queryCreator to set
	 */
	public void setQueryCreator(QueryCreator queryCreator) {
		this.queryCreator = queryCreator;
	}

	protected RemoteIssue[] getIssues(String query) {
		try {
			return service.getIssuesFromJqlSearch(TokenFactory.getToken(), query, 100);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new RemoteIssue[0];
	}


	protected void getWorklogs(AbstractIssueVo task){
		final List<WorkVo> work = new ArrayList<WorkVo>();
		try {
			for (RemoteWorklog worklog : service.getWorklogs(TokenFactory.getToken(), task.getKey())){
				work.add(convert(worklog));
			}
			task.setWorks(work);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	

	private WorkVo convert(RemoteWorklog worklog) {
		final WorkVo vo = new WorkVo();
		vo.setAuthor(worklog.getAuthor());
		vo.setComment(worklog.getComment());
		vo.setTimeSpent(worklog.getTimeSpentInSeconds());
		if (worklog.getStartDate() != null){
			vo.setStart(worklog.getStartDate().getTime());
		}
		return vo;
	}


}
