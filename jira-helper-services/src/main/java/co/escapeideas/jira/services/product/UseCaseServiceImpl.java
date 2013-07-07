/**
 * 
 */
package co.escapeideas.jira.services.product;

import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.dataaccess.common.WorkVo;
import co.escapeideas.jira.dataaccess.product.FeatureVo;
import co.escapeideas.jira.dataaccess.product.UseCaseDataAccess;
import co.escapeideas.jira.dataaccess.product.UseCaseVo;
import co.escapeideas.jira.dataaccess.project.ReleaseVo;
import co.escapeideas.jira.domain.Feature;
import co.escapeideas.jira.domain.Release;
import co.escapeideas.jira.domain.Task;
import co.escapeideas.jira.domain.UseCase;
import co.escapeideas.jira.domain.Work;
import co.escapeideas.jira.domain.impl.TaskImpl;
import co.escapeideas.jira.domain.impl.UseCaseImpl;
import co.escapeideas.jira.domain.impl.WorkImpl;
import co.escapeideas.jira.services.common.TaskService;

/**
 * @author tmullender
 *
 */
public class UseCaseServiceImpl implements UseCaseService {
	
	private static final String NON_SPECIFIC_TASK = "Non specific task";

	private UseCaseDataAccess useCaseData;
	
	private TaskService taskService;

	/**
	 * @return the useCaseData
	 */
	public UseCaseDataAccess getUseCaseData() {
		return useCaseData;
	}

	/**
	 * @return the taskService
	 */
	public TaskService getTaskService() {
		return taskService;
	}

	/**
	 * @param taskService the taskService to set
	 */
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	/**
	 * @param useCaseData the useCaseData to set
	 */
	public void setUseCaseData(UseCaseDataAccess useCaseData) {
		this.useCaseData = useCaseData;
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.services.product.UseCaseService#getUseCases(co.escapeideas.jira.domain.Release, co.escapeideas.jira.domain.Feature)
	 */
	@Override
	public List<UseCase> getUseCases(Release release, Feature feature) {
		final List<UseCase> useCases = new ArrayList<UseCase>();
		for (UseCaseVo useCase:useCaseData.getUseCases(convert(release), convert(feature))){
			useCases.add(convert(useCase));
		}
		return useCases;
	}

	private UseCase convert(UseCaseVo vo) {
		final UseCaseImpl useCase = new UseCaseImpl(vo.getKey());
		useCase.setDescription(vo.getDescription());
		useCase.setOwner(vo.getOwner());
		useCase.setTitle(vo.getTitle());
		useCase.setStatus(vo.getStatus());
		final List<WorkVo> works = vo.getWorks();
		if (!works.isEmpty()){
			TaskImpl task = new TaskImpl(vo.getKey());
			task.setTitle(NON_SPECIFIC_TASK);
			for (WorkVo work:vo.getWorks()){
				task.add(convert(work));
			}
			useCase.addTask(task);
		}
		for (Task task:taskService.getTasks(useCase)){
			useCase.addTask(task);
		}
		return useCase;
	}	

	private Work convert(WorkVo vo) {
		final WorkImpl work = new WorkImpl();
		work.setAuthor(vo.getAuthor());
		work.setComment(vo.getComment());
		work.setStart(vo.getStart());
		work.setTimeSpent(vo.getTimeSpent());
		return work;
	}

	private FeatureVo convert(Feature feature) {
		final FeatureVo vo = new FeatureVo();
		vo.setProduct(feature.getProductKey());
		return vo;
	}

	private ReleaseVo convert(Release release) {
		final ReleaseVo vo = new ReleaseVo();
		vo.setKey(release.getKey());
		return vo;
	}

}
