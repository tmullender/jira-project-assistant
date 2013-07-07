/**
 * 
 */
package co.escapeideas.jira.wsdl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.dataaccess.project.ProjectDataAccess;
import co.escapeideas.jira.dataaccess.project.ProjectVo;

/**
 * @author tmullender
 *
 */
public class ProjectDao implements ProjectDataAccess {
	
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
	 * @see co.escapeideas.jira.dataaccess.project.ProjectDataAccess#getProject(java.lang.String)
	 */
	@Override
	public ProjectVo getProject(String key) {
		RemoteProject project;
		try {
			project = service.getProjectByKey(TokenFactory.getToken(), key);
		} catch (RemoteException e) {
			project = new RemoteProject();
		}
		return convert(project);
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.dataaccess.project.ProjectDataAccess#getProjects()
	 */
	@Override
	public List<ProjectVo> getProjects() {
		return getProjects(true);
	}
	
	private List<ProjectVo> getProjects(boolean resetToken) {
		final List<ProjectVo> projects = new ArrayList<ProjectVo>();
		try {
			for (RemoteProject project : service.getProjectsNoSchemes(TokenFactory.getToken())){
				projects.add(convert(project));
			}
		} catch (RemoteAuthenticationException e) {
			if (resetToken){
				TokenFactory.resetToken();
				getProjects(false);
			} 
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return projects;
	}

	private ProjectVo convert(RemoteProject project) {
		final ProjectVo vo = new ProjectVo();
		vo.setDescription(project.getDescription());
		vo.setKey(project.getKey());
		vo.setTitle(project.getName());
		return vo;
	}

}
