/**
 * 
 */
package co.escapeideas.jira.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.escapeideas.jira.services.common.TeamService;
import co.escapeideas.jira.services.project.ProjectService;

/**
 * @author tmullender
 *
 */
@Controller
public class HomeController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TeamService teamService;
	
	@RequestMapping("/home**")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		final ModelAndView model = new ModelAndView("/home");
		if (projectService != null){
			model.addObject("projects", projectService.getProjects(false));
		}
		if (teamService != null){
			model.addObject("teams", teamService.getTeams());
		}
		return model;
	}

}
