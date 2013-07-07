/**
 * 
 */
package co.escapeideas.jira.wsdl;

/**
 * @author tmullender
 *
 */
public class SimpleQueryCreator implements QueryCreator {
	
	/* (non-Javadoc)
	 * @see co.escapeideas.jira.wsdl.QueryCreatorX#createQuery(java.lang.String, java.lang.String)
	 */
	@Override
	public String createQuery(String query, String... parameters){
		String response = query;
		for (String parameter : parameters){
			response = response.replaceFirst("\\?", parameter);
		}
		return response;
		
	}

}
