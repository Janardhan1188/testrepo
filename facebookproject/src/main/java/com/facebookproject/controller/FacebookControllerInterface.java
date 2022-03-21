package com.facebookproject.controller;

import com.facebookproject.entity.FacebookUser;

public interface FacebookControllerInterface {

	void createProfileController();

	void viewAllProfileController();

	void viewProfileController();

	void deleteProfileController();

	void searchProfileController();

	void editProfileController();

	FacebookUser signIN();

	void createTimeline();

}
