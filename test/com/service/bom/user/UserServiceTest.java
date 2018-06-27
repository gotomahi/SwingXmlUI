package com.service.bom.user;

import junit.framework.TestCase;

import com.autoinsure.model.bom.User;
import com.framework.bom.ServiceLocator;

/**
 * 
 * @author mahendra
 * 
 * @date 7 Oct 2011
 */
public class UserServiceTest extends TestCase {
	private UserService userService;

	
	protected void setUp() throws Exception {
		super.setUp();
		userService = (UserService) ServiceLocator.getInstance().getBean("userService");
	}

	public final void testLoadUser()throws Exception {
		User user = new User();
		user.setRecordId(1);
		//userService.load(user);
		assertTrue(user != null);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		userService = null;
	}
}
