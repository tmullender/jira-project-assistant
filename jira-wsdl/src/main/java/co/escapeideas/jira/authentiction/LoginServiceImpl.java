/**
 * 
 */
package co.escapeideas.jira.authentiction;

import java.rmi.RemoteException;

import co.escapeideas.jira.wsdl.TokenFactory;

/**
 * @author tmullender
 *
 */
public class LoginServiceImpl implements LoginService {

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.authentiction.LoginService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean login(String username, String password) {
		String token;
		try {
			token = TokenFactory.getToken(username, password);
		} catch (RemoteException e) {
			e.printStackTrace();
			token = null;
		}
		return token != null;
	}

}
