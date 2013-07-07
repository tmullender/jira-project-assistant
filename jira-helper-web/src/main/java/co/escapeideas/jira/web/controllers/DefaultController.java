/**
 * 
 */
package co.escapeideas.jira.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author tmullender
 *
 */
@Controller
public class DefaultController{

	@RequestMapping("/**")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		final String path = request.getRequestURI();
		return new ModelAndView("/" + path.substring(path.lastIndexOf("/")));
	}

}
