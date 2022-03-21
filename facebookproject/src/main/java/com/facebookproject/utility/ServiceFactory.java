package com.facebookproject.utility;

import com.facebookproject.service.FacebookService;
import com.facebookproject.service.FacebookServiceInterface;

public class ServiceFactory {

	public static FacebookServiceInterface createObject() {
		// TODO Auto-generated method stub
		return new FacebookService();
	}

}
