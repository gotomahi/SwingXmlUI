package com.gui.claim;

import java.util.Date;
import java.util.Map;

import com.autoinsure.model.bom.Claim;
import com.autoinsure.model.bom.ClaimNote;

/**
 * 
 * @author mahendra
 * 
 * @date 28 Jan 2012
 */
public class ClaimNoteAction extends ClaimAction {
	private String note;

	@Override
	public void init(Map data) throws Exception {
		note = null;
	}

	@Override
	protected void executeAction(String actionCommand) throws Exception {
		Claim claim = (Claim) treeMap.get("claim");
		if ("Add".equals(actionCommand)) {
			ClaimNote claimNotes = new ClaimNote();
			claimNotes.setNotes(note);
			claimNotes.setUpdatedDate(new Date());
			claimNotes.setUser(getUser().getUserId());
			claimNotes.setClaim(claim);
			claim.getClaimNotes().add(claimNotes);
		}
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
