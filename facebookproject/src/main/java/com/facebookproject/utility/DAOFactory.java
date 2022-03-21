package com.facebookproject.utility;

import com.facebookproject.DAO.FacebookDAO;
import com.facebookproject.DAO.FacebookDAOInterface;

public class DAOFactory {

	public static FacebookDAOInterface createObject() {
		// TODO Auto-generated method stub
		return new FacebookDAO();
	}

}
