package co.escapeideas.jira.wsdl;

public interface QueryCreator {

	String createQuery(String query, String... parameters);

}