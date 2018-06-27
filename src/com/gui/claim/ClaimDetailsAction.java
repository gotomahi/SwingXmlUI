package com.gui.claim;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.autoinsure.model.bom.CausalPart;
import com.autoinsure.model.bom.Claim;
import com.autoinsure.model.bom.InnerClaim;
import com.autoinsure.model.bom.Policy;
import com.autoinsure.service.bom.common.CounterService;
import com.autoinsure.service.bom.common.VersionManager;
import com.autoinsure.service.claim.CausalPartService;
import com.framework.bom.ServiceLocator;
import com.gui.BaseAction;
import com.service.bom.dealer.DealerService;

/**
 * 
 * @author mahendra
 * 
 * @date 4 Feb 2012
 */
public class ClaimDetailsAction extends BaseAction {

	@Override
	public void init(Map data) throws Exception {
		if (data == null || (data != null && data.get("claim") == null)) {
			treeMap = data;
			Claim claim = new Claim();
			treeMap.put("claim", claim);
			claim.setPolicy((Policy) data.get("Policy"));

		}
		// Causal Parts
		CausalPartService causalPartService = (CausalPartService) ServiceLocator.getInstance().getBean(
				"causalPartService");
		Claim claim = (Claim) treeMap.get("claim");
		List list = causalPartService.getCausalPartAreas(VersionManager.getInstance().getCausalPartVersion(
				claim.getPolicy().getVersionId()));
		Vector areas = new Vector();
		if (list != null) {
			areas.addAll(list);
		}
		treeMap.put("CausalPartAreas", areas);
		// Repairing Dealers
		DealerService dealerService = (DealerService) ServiceLocator.getInstance().getBean("dealerService");
		Map criteria = new HashMap();
		criteria.put("organisation.client.clientId", getClientId());
		List dealers = dealerService.getDealers(criteria);
		treeMap.put("DealerList", new Vector(dealers));
		CounterService counterService = (CounterService) ServiceLocator.getInstance().getBean("counterService");
		treeMap.put("PayeeTypes", new Vector(counterService.getPayeeTypes()));
	}

	@Override
	protected void executeAction(String actionCommand) throws Exception {
		if ("causalPart.causalPartArea".equals(actionCommand)) {
			InnerClaim innerClaim = (InnerClaim) getSelectedObj().get(0);
			innerClaim.setClaim((Claim) treeMap.get("claim"));
			innerClaim.getDynamicData().put("Parts", getParts(innerClaim.getCausalPart().getCausalPartArea()));
		} else if ("New".equals(actionCommand)) {
			Claim claim = (Claim) treeMap.get("claim");
			InnerClaim innerClaim = new InnerClaim();
			innerClaim.setCausalPart(new CausalPart());
			innerClaim.setClaim((Claim) treeMap.get("claim"));
			claim.getInnerClaims().add(innerClaim);
			treeMap.put("claim", claim);
		}

	}

	private Vector getParts(String area) {
		Map criteria = new HashMap();
		criteria.put("causalPartArea", area);
		Claim claim = (Claim) treeMap.get("claim");
		criteria.put("versionId", VersionManager.getInstance().getCausalPartVersion(claim.getPolicy().getVersionId()));
		CausalPartService causalPartService = (CausalPartService) ServiceLocator.getInstance().getBean(
				"causalPartService");
		List partList = causalPartService.getParts(criteria);
		Vector parts = new Vector();
		if (partList != null) {
			parts.addAll(partList);
		}
		return parts;
	}

}
