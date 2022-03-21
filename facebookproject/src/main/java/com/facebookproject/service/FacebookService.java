package com.facebookproject.service;

import java.util.List;

import com.facebookproject.DAO.FacebookDAOInterface;
import com.facebookproject.entity.FacebookUser;
import com.facebookproject.utility.DAOFactory;

public class FacebookService implements FacebookServiceInterface {
	FacebookDAOInterface fd=null;
	public FacebookService(){
		 fd=DAOFactory.createObject();
	}

	public int createProfileService(FacebookUser fu) {
		FacebookDAOInterface fd=DAOFactory.createObject();
		return fd.createProfileDAO(fu);
	}

	@Override
	public List<FacebookUser> viewAllProfileService() {
		// TODO Auto-generated method stub
		return fd.viewAllProfileDAO();
	}

	@Override
	public FacebookUser viewProfileService(FacebookUser fu) {
		FacebookUser s=fd.viewProfileDAO(fu);
		return s;
	}

	@Override
	public int deleteProfileService(FacebookUser fu) {
		int i=fd.deleteProfileDAO(fu);
		return i;
	}

	@Override
	public List<FacebookUser> searchProfileService(FacebookUser fu) {
		// TODO Auto-generated method stub
		return fd.searchprofileDAO(fu);
	}

	@Override
	public int editProfileService(FacebookUser fu) {
		int i=fd.editProfileDAO(fu);
		return i;
	}

	@Override
	public FacebookUser signINService(FacebookUser fu) {
		FacebookUser s=fd.signINDAO(fu);
		return s;
	}

}
