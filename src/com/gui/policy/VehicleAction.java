package com.gui.policy;

import java.util.Map;

public class VehicleAction extends PlanAction {

	@Override
	public void init(Map data) throws Exception {
		this.treeMap = data;
	}

	@Override
	protected void executeAction(String actionCommand) throws Exception {
	}

}
