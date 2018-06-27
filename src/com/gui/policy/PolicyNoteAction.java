package com.gui.policy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.autoinsure.model.bom.PolicyNote;
import com.autoinsure.service.policy.PolicyService;
import com.framework.bom.ServiceLocator;

/**
 * 
 * @author mahendra
 * 
 * @date 28 Jan 2012
 */
public class PolicyNoteAction extends PlanAction {
	private String note;

	@Override
	public void init(Map data) throws Exception {
		Map criteria = new HashMap();
		PolicyService policyService = (PolicyService) ServiceLocator.getInstance().getBean("policyService");
	}

	@Override
	protected void executeAction(String actionCommand) throws Exception {
		Map policyMap = (Map) treeMap.get("policyMap");
		if ("Add".equals(actionCommand)) {
			PolicyNote policyNote = new PolicyNote();
			policyNote.setNote(note);
			policyNote.setUpdatedDate(new Date());
			policyNote.setUser(getUser().getUserId());
			Vector notesList = (Vector) policyMap.get("notes");
			if (notesList == null) {
				notesList = new Vector();
				policyMap.put("notes", notesList);
			}
			notesList.add(policyNote);
		}
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
