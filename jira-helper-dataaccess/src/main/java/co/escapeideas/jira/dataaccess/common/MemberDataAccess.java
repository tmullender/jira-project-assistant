/**
 * 
 */
package co.escapeideas.jira.dataaccess.common;

import java.util.List;

import co.escapeideas.jira.dataaccess.project.TeamVo;

/**
 * @author tmullender
 *
 */
public interface MemberDataAccess {

	List<MemberVo> getMembers(TeamVo convert);

	void create(MemberVo vo);

	List<MemberVo> getMembers();

}
