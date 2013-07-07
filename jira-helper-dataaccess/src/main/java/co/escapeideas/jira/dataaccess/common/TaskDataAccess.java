/**
 * 
 */
package co.escapeideas.jira.dataaccess.common;

import java.util.List;

import co.escapeideas.jira.dataaccess.product.UseCaseVo;
import co.escapeideas.jira.dataaccess.project.ReleaseVo;

/**
 * @author tmullender
 *
 */
public interface TaskDataAccess {
	
	List<TaskVo> getTasks(UseCaseVo useCase);
	
	List<TaskVo> getTasks(ReleaseVo release);
}
