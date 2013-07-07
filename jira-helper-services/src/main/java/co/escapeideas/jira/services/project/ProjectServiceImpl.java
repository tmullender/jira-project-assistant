/**
 * 
 */
package co.escapeideas.jira.services.project;

import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.dataaccess.project.ProjectDataAccess;
import co.escapeideas.jira.dataaccess.project.ProjectVo;
import co.escapeideas.jira.domain.Project;
import co.escapeideas.jira.domain.impl.ProjectImpl;

/**
 * @author tmullender
 *
 */
public class ProjectServiceImpl implements ProjectService {

	private ProjectDataAccess projectData;
	
	private ReleaseService releaseService;
	
	/**
	 * @return the releaseService
	 */
	public ReleaseService getReleaseService() {
		return releaseService;
	}

	/**
	 * @return the wsdlProjectAccess
	 */
	public ProjectDataAccess getProjectData() {
		return projectData;
	}

	/**
	 * @param projectData the wsdlProjectAccess to set
	 */
	public void setProjectData(ProjectDataAccess projectData) {
		this.projectData = projectData;
	}

	/**
	 * @param releaseService the releaseService to set
	 */
	public void setReleaseService(ReleaseService releaseService) {
		this.releaseService = releaseService;
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.services.project.ProjectService#getProjects()
	 */
	@Override
	public List<Project> getProjects(boolean loadChildren) {
		final List<ProjectVo> projectVos = projectData.getProjects();
		final List<Project> projects = new ArrayList<Project>();
		for (ProjectVo project : projectVos){
			projects.add(convert(project, loadChildren));
		}
		return projects;
	}

	@Override
	public Project getProject(String key, boolean loadChildren) {
		return convert(projectData.getProject(key), loadChildren);
	}
	

	private Project convert(ProjectVo projectVo, boolean loadChildren) {
		final ProjectImpl project = new ProjectImpl();
		project.setDescription(projectVo.getDescription());
		project.setKey(projectVo.getKey());
		project.setTitle(projectVo.getTitle());
		if (loadChildren){
			project.setReleases(releaseService.getReleases(project, loadChildren));
		}
		return project;
	}

}
