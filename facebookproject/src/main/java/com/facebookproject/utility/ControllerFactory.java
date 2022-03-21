package com.facebookproject.utility;

import com.facebookproject.controller.FacebookController;
import com.facebookproject.controller.FacebookControllerInterface;

public class ControllerFactory {

	public static FacebookControllerInterface createObject() {
		
		return new FacebookController();
	}

}
