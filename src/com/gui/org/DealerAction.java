package com.gui.org;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.autoinsure.model.bom.Dealer;
import com.autoinsure.model.bom.User;
import com.framework.bom.ServiceLocator;
import com.gui.BaseAction;
import com.service.bom.dealer.DealerService;
import com.service.bom.org.OrgService;

/**
 * 
 * @author mahendra
 * 
 * @date 23 Apr 2011
 */
public class DealerAction extends BaseAction {
	protected Vector dealerList;
	protected Vector organisations;

	public void init(Map data) throws Exception {
		OrgService orgService = (OrgService) ServiceLocator.getInstance().getBean("orgService");
		Map criteria = new HashMap(1);
		criteria.put("client.clientId", getClientId());
		organisations = new Vector(orgService.getOrganisations(criteria));
	}

	@Override
	public void executeAction(String actionCommand) throws Exception {
		if ("Search".equals(actionCommand)) {
			DealerService dealerService = (DealerService) ServiceLocator.getInstance().getBean("dealerService");
			dealerList = new Vector(dealerService.getDealers(input));
		} else if ("New".equals(actionCommand)) {
			dealerList.add(new User());
		} else if ("Delete".equals(actionCommand)) {
			Vector seletedObj = getSelectedObj();
			if (seletedObj != null && !seletedObj.isEmpty()) {
				deletedObj.addAll(seletedObj);
			}
		} else if ("DealerVariable".equals(actionCommand)) {
			Vector seletedObj = getSelectedObj();
			if (seletedObj != null && !seletedObj.isEmpty()) {
				setSessionValue("Dealer", (Dealer) selectedObj.get(0));
			}
		}		
	}

	public Vector getOrganisations() {
		return organisations;
	}

	public void setOrganisations(Vector organisations) {
		this.organisations = organisations;
	}

	public Vector getDealerList() {
		return dealerList;
	}

	public void setDealerList(Vector dealerList) {
		this.dealerList = dealerList;
	}

}
