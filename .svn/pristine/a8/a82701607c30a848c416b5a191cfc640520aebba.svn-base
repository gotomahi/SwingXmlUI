package com.gui.policy;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.autoinsure.service.bom.common.ApplicationManager;

/**
 * 
 * @author mahendra
 * 
 * @date 25 Sep 2011
 */
public class CustomerAction extends PlanAction {

	@Override
	public void init(Map data) throws Exception {
		this.treeMap = data;
		List titles = ApplicationManager.getInstance().getStaticData("Titles");
		treeMap.put("Titles", new Vector(titles));
	}

	@Override
	protected void executeAction(String actionCommand) throws Exception {
		if("Search".equals(actionCommand)){
			setSessionValue("treeMap", treeMap);
		}

	}
}
