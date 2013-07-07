/**
 * 
 */
package co.escapeideas.jira.wsdl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import co.escapeideas.jira.dataaccess.project.ProjectVo;
import co.escapeideas.jira.dataaccess.project.ReleaseDataAccess;
import co.escapeideas.jira.dataaccess.project.ReleaseVo;

/**
 * @author tmullender
 *
 */
public class ReleaseDao implements ReleaseDataAccess {
	
	private JiraSoapService service;

	/**
	 * @return the service
	 */
	public JiraSoapService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(JiraSoapService service) {
		this.service = service;
	}

	/* (non-Javadoc)
	 * @see co.escapeideas.jira.dataaccess.project.ReleaseDataAccess#getReleases(co.escapeideas.jira.dataaccess.project.ProjectVo)
	 */
	@Override
	public List<ReleaseVo> getReleases(ProjectVo project) {
		List<ReleaseVo> versions = new ArrayList<ReleaseVo>();
		try {
			for (RemoteVersion version:service.getVersions(TokenFactory.getToken(), project.getKey())){
				versions.add(convert(version));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return versions;
	}

	private ReleaseVo convert(RemoteVersion version) {
		ReleaseVo vo = new ReleaseVo();
		vo.setName(version.getName());
		vo.setKey(version.getId());
		if (version.getReleaseDate() != null){
			vo.setEndDate(version.getReleaseDate().getTime());
		}
		return vo;
	}

}
