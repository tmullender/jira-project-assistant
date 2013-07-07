/**
 * 
 */
package co.escapeideas.jira.wsdl;

import java.rmi.RemoteException;

/**
 * @author tmullender
 *
 */
public class TokenFactory {

	private static final JiraSoapService service = JiraServiceFactory.getService();
	private static final String user = System.getProperty("wsdl.user");
	private static final String password = System.getProperty("wsdl.pass");

	private static String token = null;

	public static String getToken() throws RemoteException{
		return getToken(user, password);
	}
	
	public static String getToken(String username, String password) throws RemoteException{
		if (token == null){
			token = service.login(username, password);
		}
		return token;
	}
	
	public static void resetToken(){
		token = null;
	}
}
