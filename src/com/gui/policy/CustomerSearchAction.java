package com.gui.policy;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.autoinsure.model.bom.Customer;
import com.autoinsure.service.customer.CustomerService;
import com.framework.bom.ServiceLocator;
import com.gui.BaseAction;
import com.service.bom.org.OrgService;

/**
 * 
 * @author mahendra
 * 
 * @date 25 Sep 2011
 */
public class CustomerSearchAction extends BaseAction {
	private Vector organisations;
	private Vector<Customer> customerList = new Vector<Customer>();

	@Override
	public void init(Map data) throws Exception {
		OrgService orgService = (OrgService) ServiceLocator.getInstance().getBean("orgService");
		Map criteria = new HashMap(1);
		criteria.put("client.clientId", getClientId());
		organisations = new Vector(orgService.getOrganisations(criteria));
	}

	@Override
	protected void executeAction(String actionCommand) throws Exception {
		if ("Search".equals(actionCommand)) {
			CustomerService customerService = (CustomerService) ServiceLocator.getInstance().getBean(
					"customerService");
			customerList = new Vector(customerService.getCustomers(input));
		} else if ("Load".equals(actionCommand)) {
			Vector seletedObj = getSelectedObj();
			if (seletedObj != null && !seletedObj.isEmpty()) {
				Customer customer = (Customer) seletedObj.get(0);
				addActionData("plan.customer", customer);
			}
		}
	}

	public Vector getOrganisations() {
		return organisations;
	}

	public void setOrganisations(Vector organisations) {
		this.organisations = organisations;
	}

	public Vector<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(Vector<Customer> customerList) {
		this.customerList = customerList;
	}
}
