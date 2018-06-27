package com.gui.policy;

import java.util.Map;

import com.autoinsure.model.bom.User;
import com.autoinsure.service.plan.PlanService;

/**
 * 
 * @author mahendra
 * 
 * @date 11 Mar 2012
 */
public class SummaryAction extends PlanAction {
	private Map data;

	@Override
	protected void executeAction(String actionCommand) throws Exception {
		if ("Comfirm".equals(actionCommand)) {
			if (treeMap != null) {
				treeMap.put("clientId", getClientId());
				Map policyMap = (Map) treeMap.get("policyMap");
				policyMap.put("updatedUser", ((User) getSessionValue("User")).getUserId());
				treeMap = PlanService.getInstance().savePlane(treeMap);
			}
		}

	}

	public Map getData() {
		return data;
	}

	public void setData(Map data) {
		this.data = data;
	}

}
