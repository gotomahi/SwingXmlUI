package com.service.bom.makemodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import com.autoinsure.service.bom.makemodel.MakeModelService;
import com.framework.bom.ServiceLocator;

/**
 * 
 * @author mahendra
 * 
 * @date 20 Nov 2011
 */
public class MakeModelTest {
	private MakeModelService makeModelService;

	
	protected void setUp() throws Exception {
		makeModelService = (MakeModelService) ServiceLocator.getInstance().getBean("makeModelService");
	}

	public void testMakeModelSearch() {
		Map criteria = new HashMap();
		criteria.put("make", "Ford");
		criteria.put("model", "Fiesta");
		criteria.put("clss", "ALL");
		criteria.put("clientId", new Long(1));
		List makeModels = makeModelService.getMakeModels(criteria);
		Assert.assertTrue(makeModels.size() > 0);
	}

	
	protected void tearDown() throws Exception {
		makeModelService = null;
	}
}
