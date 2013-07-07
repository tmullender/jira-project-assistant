/**
 * 
 */
package co.escapeideas.jira.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import co.escapeideas.jira.domain.Feature;
import co.escapeideas.jira.domain.Product;
import co.escapeideas.jira.domain.Project;
import co.escapeideas.jira.domain.Release;
import co.escapeideas.jira.domain.UseCase;
import co.escapeideas.jira.services.product.FeatureService;
import co.escapeideas.jira.services.product.ProductService;
import co.escapeideas.jira.services.product.UseCaseService;
import co.escapeideas.jira.services.project.ProjectService;
import co.escapeideas.jira.services.project.ReleaseService;
import co.escapeideas.jira.web.ui.TaskList;

/**
 * @author tmullender
 *
 */
@Controller
@SessionAttributes({"project", "products", "product", "release"})
public class ProjectController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ReleaseService releaseService;
	
	@Autowired
	private FeatureService featureService;
	
	@Autowired
	private UseCaseService useCaseService;

	@RequestMapping("/project/{project}")
	protected ModelAndView handleProjectRequest(@PathVariable("project") String key) throws Exception {
		final ModelAndView model = new ModelAndView("/project");
		if (key != null){
			final Project project = projectService.getProject(key, false);
			if (project != null){
				project.addProducts(productService.getProducts(project, false));
				project.addReleases(releaseService.getReleases(project, false));
				model.addObject("project", project);
			}
		}
		return model;
	}
	
	@RequestMapping("/product/{product}")
	protected String handleProductRequest(ModelMap map, @PathVariable("product") String key) throws Exception {
		final Project project = (Project) map.get("project");
		final String view;
		if (project != null){
			view = "/product";
			for (Product product : project.getProducts()){
				if (product.getKey().equals(key)){
					map.addAttribute("product", product);
				}
			}
		} else {
			view = "/login";
		}
		return view;
	}

	@RequestMapping("/release/{release}")
	protected String handleReleaseRequest(ModelMap model, @PathVariable("release") String key,
			@RequestParam(value="start", defaultValue="2013-04-01") String start, 
			@RequestParam(value="end", defaultValue="2013-04-30") String end) throws Exception {
		final Product product = (Product) model.get("product");
		final Project project = (Project) model.get("project");
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		final String view;
//		if (model.containsKey("tasklist")){
//			view = "/release";
//			TaskList taskList = (TaskList) model.get("tasklist");
//			TaskList updated = new TaskList(start, end);
//			updated.add(taskList.getItems());
//		} else
			if (product != null && project != null){
			view = "/release";
			for (Release release : project.getReleases()){
				if (release.getKey().equals(key)){
					model.addAttribute("release", release);
					TaskList taskList = new TaskList(start, end);
					taskList.add(getUseCases(release, product));
					model.addAttribute("tasklist", taskList);
				}
			}
		} else {
			view = "/login";
		}
		return view;
	}
	
	private List<UseCase> getUseCases(Release release, Product product){
		final Feature feature = featureService.getFeatures(product).get(0);
		final List<UseCase> useCases = useCaseService.getUseCases(release, feature);
		return useCases;
	}



}
