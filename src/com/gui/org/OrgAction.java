package com.gui.org;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.autoinsure.model.bom.Client;
import com.autoinsure.service.bom.client.ClientService;
import com.framework.bom.ServiceLocator;
import com.gui.BaseAction;
import com.service.bom.org.OrgService;

/**
 * 
 * @author mahendra
 * 
 * @date 23 Apr 2011
 */
public class OrgAction extends BaseAction {
	private Vector orgList = new Vector();
	private Vector clients = new Vector();

	@Override
	public void init(Map data) throws Exception {
		ClientService clientService = (ClientService) ServiceLocator.getInstance().getBean("clientService");
		clients = new Vector(clientService.getClients(input));
	}

	@Override
	public void executeAction(String actionCommand) throws Exception {
		if ("Search".equals(actionCommand)) {
			OrgService orgService = (OrgService) ServiceLocator.getInstance().getBean("orgService");
			Map criteria = new HashMap(1);
			criteria.put("client.clientId", getClientId());
			orgList = new Vector(orgService.getOrganisations(criteria));
		} else if ("New".equals(actionCommand)) {
			orgList.add(new Client());
		} else if ("Delete".equals(actionCommand)) {
		}
	}

	public Vector getOrgList() {
		return orgList;
	}

	public void setOrgList(Vector orgList) {
		this.orgList = orgList;
	}

	public Vector getClients() {
		return clients;
	}

	public void setClients(Vector clients) {
		this.clients = clients;
	}
}