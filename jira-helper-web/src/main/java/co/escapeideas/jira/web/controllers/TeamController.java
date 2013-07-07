/**
 * 
 */
package co.escapeideas.jira.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import co.escapeideas.jira.domain.Member;
import co.escapeideas.jira.domain.Team;
import co.escapeideas.jira.services.common.MemberService;
import co.escapeideas.jira.services.common.TeamService;

/**
 * @author tmullender
 *
 */
@Controller
@SessionAttributes({"team"})
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/team/create")
	public String handleCreateRequest(
			ModelMap map,
			@RequestParam(value="title", defaultValue="") String title,
			@RequestParam(value="description", defaultValue="") String description) {
		if (!StringUtils.isEmpty(title) && !StringUtils.isEmpty(description)){
			teamService.create(title, description);
			return "forward:/do/home";
		}
		return "team/create";
	}
	
	@RequestMapping("/team/{team}")
	public String handleTeamRequest(ModelMap map, @PathVariable("team") String key){
		final Team team = teamService.getTeam(key);
		map.addAttribute("team", team);
		final List<Member> members = memberService.getMembers();
		for (Member member:team.getMembers()){
			members.remove(member);
		}
		map.addAttribute("members", members);
		return "team/view";
	}
	
	@RequestMapping("/user/create")
	public String handleCreateRequest(ModelMap map, HttpServletRequest request){
		final String response;
		final String username = request.getParameter("username");
		final String name = request.getParameter("name");
		final String emailAddress = request.getParameter("emailAddress");
		final Team team = (Team) map.get("team");
		if (!StringUtils.isEmpty(username)){
			memberService.create(username, name, emailAddress);
			if (team == null){
				response = "forward:/do/home";
			} else {
				response = "forward:/do/team/" + team.getKey();
			}
		} else {
			response = "user/create";
		}
		return response;
	}
}
