package com.gui.login;

import java.util.HashMap;
import java.util.Map;

import com.autoinsure.model.bom.User;
import com.framework.BaseError;
import com.framework.bom.ServiceLocator;
import com.gui.user.UserAction;
import com.service.bom.user.UserService;

/**
 * 
 * @author mahendra
 * 
 * @date 23 Apr 2011
 */
public class LoginAction extends UserAction {
	private String userId;
	private String password;
	private Map userMap;
	
	public void init(Map data)throws Exception{
		
	}

	@Override
	public void executeAction(String actionCommand)throws Exception {
		UserService userService = (UserService) ServiceLocator.getInstance().getBean("userService");		
		Map criteria = new HashMap();
		criteria.put("userId", userId);
		criteria.put("password", password);
		User user = userService.validateLogin(criteria);
		if (user != null) {	
			setSessionValue("User", user);
			setSessionValue("clientId", getClientId());
			setSessionValue("Role", user.getUserType().getRole());
		}else{
			addError(new BaseError("Login failed"));
		}
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map getUserMap() {
		return userMap;
	}

	public void setUserMap(Map userMap) {
		this.userMap = userMap;
	}

}
