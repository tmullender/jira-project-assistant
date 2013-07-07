/**
 * 
 */
package co.escapeideas.jira.services.common;

import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.dataaccess.common.TaskDataAccess;
import co.escapeideas.jira.dataaccess.common.TaskVo;
import co.escapeideas.jira.dataaccess.common.WorkVo;
import co.escapeideas.jira.dataaccess.product.UseCaseVo;
import co.escapeideas.jira.dataaccess.project.ReleaseVo;
import co.escapeideas.jira.domain.Release;
import co.escapeideas.jira.domain.Task;
import co.escapeideas.jira.domain.UseCase;
import co.escapeideas.jira.domain.Work;
import co.escapeideas.jira.domain.impl.TaskImpl;
import co.escapeideas.jira.domain.impl.WorkImpl;

/**
 * @author tmullender
 *
 */
public class TaskServiceImpl implements TaskService {
	
	private TaskDataAccess taskData;

	/**
	 * @return the taskData
	 */
	public TaskDataAccess getTaskData() {
		return taskData;
	}

	/**
	 * @param taskData the taskData to set
	 */
	public void setTaskData(TaskDataAccess taskData) {
		this.taskData = taskData;
	}
	
	@Override
	public List<Task> getTasks(UseCase useCase) {
		final List<Task> tasks = new ArrayList<Task>();
		for (TaskVo task : taskData.getTasks(convert(useCase))){
			tasks.add(convert(task));
		}
		return tasks;
	}

	@Override
	public List<Task> getTasks(Release release) {
		final List<Task> tasks = new ArrayList<Task>();
		for (TaskVo task : taskData.getTasks(convert(release))){
			tasks.add(convert(task));
		}
		return tasks;
	}
	
	private Task convert(TaskVo vo) {
		final TaskImpl task = new TaskImpl(vo.getKey());
		task.setDescription(vo.getDescription());
		task.setOwner(vo.getOwner());
		task.setTitle(vo.getTitle());
		task.setStatus(vo.getStatus());
		for (WorkVo work:vo.getWorks()){
			task.add(convert(work));
		}
		return task;
	}

	private Work convert(WorkVo vo) {
		final WorkImpl work = new WorkImpl();
		work.setAuthor(vo.getAuthor());
		work.setComment(vo.getComment());
		work.setStart(vo.getStart());
		work.setTimeSpent(vo.getTimeSpent());
		return work;
	}

	private UseCaseVo convert(UseCase useCase) {
		final UseCaseVo vo = new UseCaseVo();
		vo.setKey(useCase.getKey());
		return vo;
	}
	
	private ReleaseVo convert(Release vo) {
		final ReleaseVo release = new ReleaseVo();
		release.setKey(vo.getKey());
		release.setName(vo.getTitle());
		release.setEndDate(vo.getEndDate());
		return release;
	}

}
