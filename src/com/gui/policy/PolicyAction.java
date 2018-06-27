package com.gui.policy;

import java.util.HashMap;
import java.util.Map;

import com.gui.BaseAction;

public class PolicyAction extends BaseAction {
	protected Map policy = new HashMap();

	@Override
	protected void executeAction(String actionCommand) throws Exception {
	}

	public Map getPolicy() {
		return policy;
	}

	public void setPolicy(Map policy) {
		this.policy = policy;
	}

}
