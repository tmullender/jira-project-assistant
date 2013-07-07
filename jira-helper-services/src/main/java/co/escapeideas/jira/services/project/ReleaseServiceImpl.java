/**
 * 
 */
package co.escapeideas.jira.services.project;

import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.dataaccess.project.ProjectVo;
import co.escapeideas.jira.dataaccess.project.ReleaseDataAccess;
import co.escapeideas.jira.dataaccess.project.ReleaseVo;
import co.escapeideas.jira.domain.Project;
import co.escapeideas.jira.domain.Release;
import co.escapeideas.jira.domain.ReleaseImpl;
import co.escapeideas.jira.services.common.TaskService;

/**
 * @author tmullender
 *
 */
public class ReleaseServiceImpl implements ReleaseService {

	private ReleaseDataAccess releaseData;
	
	private TaskService taskService;

	/**
	 * @return the releaseData
	 */
	public ReleaseDataAccess getReleaseData() {
		return releaseData;
	}

	/**
	 * @return the taskService
	 */
	public TaskService getTaskService() {
		return taskService;
	}

	/**
	 * @param releaseData the releaseData to set
	 */
	public void setReleaseData(ReleaseDataAccess releaseData) {
		this.releaseData = releaseData;
	}

	/**
	 * @param taskService the taskService to set
	 */
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	@Override
	public List<Release> getReleases(Project project, boolean loadChildren) {
		List<Release> releases = new ArrayList<Release>();
		for (ReleaseVo release:releaseData.getReleases(convert(project))){
			releases.add(convert(release, loadChildren));
		}
		return releases;
	}

	private Release convert(ReleaseVo vo, boolean loadChildren) {
		ReleaseImpl release = new ReleaseImpl();
		release.setKey(vo.getKey());
		release.setName(vo.getName());
		release.setEndDate(vo.getEndDate());
		if (loadChildren){
			release.setTasks(taskService.getTasks(release));
		}
		return release;
	}

	private ProjectVo convert(Project project) {
		ProjectVo vo = new ProjectVo();
		vo.setDescription(project.getDescription());
		vo.setKey(project.getKey());
		return vo;
	};

}
