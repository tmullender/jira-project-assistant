/**
 * 
 */
package co.escapeideas.jira.dataaccess.product;

import co.escapeideas.jira.dataaccess.common.AbstractIssueVo;

/**
 * @author tmullender
 *
 */
public class FeatureVo extends AbstractIssueVo {

	private long allocatedTime;
	private String product;

	/**
	 * @return the allocatedTime
	 */
	public long getAllocatedTime() {
		return allocatedTime;
	}

	public String getProduct() {
		return product;
	}

	public void setAllocatedTime(long allocatedTime) {
		this.allocatedTime = allocatedTime;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}


}
