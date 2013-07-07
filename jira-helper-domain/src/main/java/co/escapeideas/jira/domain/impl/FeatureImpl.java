/**
 * 
 */
package co.escapeideas.jira.domain.impl;

import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.domain.Feature;
import co.escapeideas.jira.domain.UseCase;

/**
 * @author tmullender
 *
 */
public class FeatureImpl extends AbstractProductItem implements Feature {
	
	private String productKey;
	private List<UseCase> tasks = new ArrayList<UseCase>();

	public FeatureImpl(String key) {
		super(key);
	}

	/**
	 * @return the productKey
	 */
	public String getProductKey() {
		return productKey;
	}

	/**
	 * @return the tasks
	 */
	public List<UseCase> getTasks() {
		return tasks;
	}

	/**
	 * @param tasks the tasks to set
	 */
	public void setTasks(List<UseCase> tasks) {
		this.tasks = tasks;
	}

	public void setProductKey(String key) {
		productKey = key;
	}
	
	@Override
	public void addUseCase(UseCase useCase) {
		addChild(useCase);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UseCase> getUseCases() {
		return (List<UseCase>) getChildren();
	}
	
	public String toString() {
		return "\n\t" + super.toString() + tasks;
	}


}
