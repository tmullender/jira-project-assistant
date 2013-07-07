/**
 * 
 */
package co.escapeideas.jira.dataaccess.common;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author tmullender
 *
 */
public class UserDao extends JdbcDaoSupport implements UserDataAccess {

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.dataaccess.common.UserDataAccess#getUsers()
	 */
	@Override
	public List<UserVo> getUsers() {
		throw new UnsupportedOperationException();
	}

}
