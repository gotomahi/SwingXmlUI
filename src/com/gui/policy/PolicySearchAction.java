package com.gui.policy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.autoinsure.model.bom.Policy;
import com.autoinsure.service.plan.PlanService;
import com.autoinsure.service.policy.PolicyService;
import com.framework.bom.ServiceLocator;
import com.gui.BaseAction;

/**
 * 
 * @author mahendra
 * 
 * @date 12 Feb 2012
 */
public class PolicySearchAction extends BaseAction {
	private Vector policyList = new Vector();
	private String policySearchPage;
	
	@Override
	public void init(Map data) throws Exception {
		policySearchPage = (String)data.get("policySearchPage");
	}

	@Override
	protected void executeAction(String actionCommand) throws Exception {
		if ("Search".equals(actionCommand)) {
			PolicyService policyService = (PolicyService) ServiceLocator.getInstance().getBean("policyService");
			List list = policyService.searchPolicies(input);
			if (list != null) {
				policyList.clear();
				policyList.addAll(list);
			}
		} else if ("Load".equals(actionCommand)) {
			Policy policy = (Policy) getSelectedObj().firstElement();
			Map data = new HashMap();
			data.put("Policy", policy);
			data.put("operation", "amendment");
			addActionData(data);
		}else if ("View".equals(actionCommand)) {
			Policy policy = (Policy) getSelectedObj().firstElement();
			Map data = new HashMap();
			Map planMap = PlanService.getInstance().loadPlan(policy.getPolicyId(), getClientId());
			data.putAll(planMap);
			data.put("operation", "amendment");
			addActionData(data);
		}
	}

	public Vector getPolicyList() {
		return policyList;
	}

	public void setPolicyList(Vector policyList) {
		this.policyList = policyList;
	}

	public String getPolicySearchPage() {
		return policySearchPage;
	}

	public void setPolicySearchPage(String policySearchPage) {
		this.policySearchPage = policySearchPage;
	}

}
