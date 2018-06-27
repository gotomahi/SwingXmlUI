package com.service.bom.policy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.autoinsure.model.bom.Customer;
import com.autoinsure.model.bom.Dealer;
import com.autoinsure.model.bom.DealerVariables;
import com.autoinsure.model.bom.MakeModel;
import com.autoinsure.model.bom.Plan;
import com.autoinsure.model.bom.Policy;
import com.autoinsure.model.bom.Vehicle;
import com.autoinsure.service.bom.makemodel.MakeModelService;
import com.autoinsure.service.policy.PolicyService;
import com.framework.bom.ServiceLocator;
import com.service.bom.dealer.DealerService;

public class PolicyServiceTest {
	private PolicyService policyService;

	protected void setUp() throws Exception {
		policyService = (PolicyService) ServiceLocator.getInstance().getBean("policyService");
	}

	public void testSavePlan() {
		DealerService dlrService = (DealerService) ServiceLocator.getInstance().getBean("dealerService");
		Dealer dealer = new Dealer();
		dealer.setDealerId(1);
		dealer.setDealerVersionId(1);
		try {
			//dlrService.load(dealer);
		} catch (Exception e) {

		}
		Map criteria = new HashMap();
		criteria.put("dealer.dealerId", 1);
		criteria.put("dealer.dealerVersionId", 1);
		List dlrVars = dlrService.getDealerVariables(criteria);
		MakeModelService makeModelService = (MakeModelService) ServiceLocator.getInstance().getBean("makeModelService");
		criteria.clear();
		criteria.put("make", "Ford");
		criteria.put("model", "Fiesta");
		criteria.put("clss", "ALL");
		List makes = makeModelService.getMakeModels(criteria);
		Customer c = new Customer();
		c.setCustomerId(2);
		c.setCustomerVersionId(1);
//		CustomerService custService = (CustomerService) ServiceLocator.getInstance().getBean("customerService");
//		custService.loadCustomer(c);
		Plan plan = new Plan();
		plan.setCustomer(c);
		Policy p = new Policy();
		p.setDealer(dealer);
		p.setDealerVariables((DealerVariables) dlrVars.get(0));
		Vehicle v = new Vehicle();
		v.setVin("vin11111");
		v.setMakeModel((MakeModel) makes.get(0));
		v.setRegno("regno");
		p.setVehicle(v);
		p.setVehicle(v);
		// p.setPolicyNumber("00000001");
		// p.setPolicyType("W");
		List policies = new ArrayList();
		policies.add(p);
		plan.setPolicies(policies);
		PolicyService policyService = (PolicyService) ServiceLocator.getInstance().getBean("policyService");
		try {
			policyService.savePlan(plan);
		} catch (Exception e) {

		}
	}

	public void testSaveVehicle() {
		MakeModel m = new MakeModel();
		m.setStatus(MakeModel.UNCHANGED);
		m.setMakeModelId(1);
		Vehicle v = new Vehicle();
		v.setMakeModel(m);
		v.setVin("vin11111");
		v.setRegDate(new Date());
		v.setWarrantyDate(new Date());
		v.setRegno("erter");
//		BaseServiceImpl b = (BaseServiceImpl) ServiceLocator.getInstance().getBean("baseService");
//		try {
//			b.persist(v);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

	protected void tearDown() throws Exception {
		policyService = null;
	}
}
