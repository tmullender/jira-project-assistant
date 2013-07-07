/**
 * 
 */
package co.escapeideas.jira.wsdl;

import java.net.URL;

import javax.xml.rpc.ServiceException;

/**
 * @author tmullender
 *
 */
public class JiraServiceFactory {
	
	private static JiraSoapService INSTANCE;
	
	public static JiraSoapService getService(){
		if (INSTANCE == null){
			try {
				INSTANCE = new JiraSoapServiceServiceLocator().getJirasoapserviceV2();
			} catch (ServiceException e) {
				e.printStackTrace();
				INSTANCE = null;
			}
		}
		return INSTANCE;
	}
	
	public static JiraSoapService getService(String path){
		if (INSTANCE == null){
			try {
				URL url = new URL(path);
				INSTANCE = new JiraSoapServiceServiceLocator().getJirasoapserviceV2(url);
			} catch (Exception e) {
				e.printStackTrace();
				INSTANCE = null;
			}
		}
		return INSTANCE;
	}

}
