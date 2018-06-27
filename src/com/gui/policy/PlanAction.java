package com.gui.policy;

import com.gui.BaseAction;

public class PlanAction extends BaseAction {

	@Override
	protected void executeAction(String actionCommand) throws Exception {
		addActionData("treeMap", treeMap);
	}

}
