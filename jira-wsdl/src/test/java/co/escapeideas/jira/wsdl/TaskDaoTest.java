/**
 * 
 */
package co.escapeideas.jira.wsdl;

import org.junit.BeforeClass;
import org.junit.Test;

import co.escapeideas.jira.dataaccess.product.FeatureVo;
import co.escapeideas.jira.dataaccess.project.ReleaseVo;

/**
 * @author tmullender
 *
 */
public class TaskDaoTest {
	
	private static StoryDao dao = new StoryDao();
	
	@BeforeClass 
	public static void setupClass() throws Exception {
		dao.setService(JiraServiceFactory.getService());
		dao.setQueryCreator(new SimpleQueryCreator());
		TokenFactory.getToken("tmullender", "k0K)a0A)n3N$132");
	}

	/**
	 * Test method for {@link co.escapeideas.jira.wsdl.StoryDao#getTasks(co.escapeideas.jira.dataaccess.product.UseCaseVo)}.
	 */
	@Test
	public void testGetTasksUseCaseVo() {
		//TODO
	}

	/**
	 * Test method for {@link co.escapeideas.jira.wsdl.StoryDao#getTasks(co.escapeideas.jira.dataaccess.project.ReleaseVo, co.escapeideas.jira.dataaccess.product.ProductVo)}.
	 */
	@Test
	public void testGetTasksReleaseVoProductVo() {
		FeatureVo feature = new FeatureVo();
		feature.setProduct("10460");
		ReleaseVo release = new ReleaseVo();
		release.setKey("11090");
		dao.getUseCases(release, feature);
	}

	/**
	 * Test method for {@link co.escapeideas.jira.wsdl.StoryDao#getTasks(co.escapeideas.jira.dataaccess.project.ReleaseVo)}.
	 */
	@Test
	public void testGetTasksReleaseVo() {
		//fail("Not yet implemented");
	}

}
