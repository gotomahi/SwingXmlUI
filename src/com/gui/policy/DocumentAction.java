package com.gui.policy;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.ResourceLoader;
import com.autoinsure.model.bom.PolicyDocument;
import com.framework.util.StringUtil;
import com.gui.BaseAction;

/**
 * 
 * @author mahendra
 * 
 * @date 21 Jan 2012
 */
public class DocumentAction extends BaseAction {
	private Vector<PolicyDocument> documentList = new Vector<PolicyDocument>();
	private String file;
	private String description;

	@Override
	public void init(Map data) throws Exception {
		Map policyMap = (Map) data.get("policyMap");
		if (policyMap != null && policyMap.get("documents") != null) {
			documentList = new Vector((List) policyMap.get("documents"));
		}
	}

	@Override
	protected void executeAction(String actionCommand) throws Exception {
		if ("New".equals(actionCommand)) {
			PolicyDocument policyDocument = new PolicyDocument();
			policyDocument.setDescription(description);
			policyDocument.setFileName(file);
			if (!StringUtil.isEmpty(file))
				policyDocument.setFileData(ResourceLoader.getInstance().getFileData(file));
			documentList.add(policyDocument);
		} else if ("Delete".equals(actionCommand)) {
			Vector seletedObj = getSelectedObj();
			if (seletedObj != null && !seletedObj.isEmpty()) {
				deletedObj.addAll(seletedObj);
			}
		}
	}

	public Vector getDocumentList() {
		return documentList;
	}

	public void setDocumentList(Vector documentList) {
		this.documentList = documentList;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
