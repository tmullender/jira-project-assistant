package co.escapeideas.jira.domain;

import java.util.List;

public interface Feature extends ProductItem {

	void addUseCase(UseCase useCase);
	
	List<UseCase> getUseCases();

	String getProductKey();
	
}
