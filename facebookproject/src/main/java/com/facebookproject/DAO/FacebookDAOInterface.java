package com.facebookproject.DAO;

import java.util.List;

import com.facebookproject.entity.FacebookUser;

public interface FacebookDAOInterface {

	int createProfileDAO(FacebookUser fu);

	List<FacebookUser> viewAllProfileDAO();

	FacebookUser viewProfileDAO(FacebookUser fu);

	int deleteProfileDAO(FacebookUser fu);

	List<FacebookUser> searchprofileDAO(FacebookUser fu);

	int editProfileDAO(FacebookUser fu);

	FacebookUser signINDAO(FacebookUser fu);

}
