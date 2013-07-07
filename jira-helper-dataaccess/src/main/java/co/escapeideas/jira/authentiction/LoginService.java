/**
 * 
 */
package co.escapeideas.jira.authentiction;

/**
 * @author tmullender
 *
 */
public interface LoginService {
	
	boolean login(String username, String password);

}
