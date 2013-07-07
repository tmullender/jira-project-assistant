package co.escapeideas.jira.services.project;

import java.util.List;

import co.escapeideas.jira.domain.Project;

public interface ProjectService {

	List<Project> getProjects(boolean loadChildren);

	Project getProject(String key, boolean loadChildren);

}