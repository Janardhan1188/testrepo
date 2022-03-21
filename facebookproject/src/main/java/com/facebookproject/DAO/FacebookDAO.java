package com.facebookproject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.facebookproject.entity.FacebookUser;

public class FacebookDAO implements FacebookDAOInterface {
	Connection con=null;
	public FacebookDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int createProfileDAO(FacebookUser fu) {
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into facebookuser values(?,?,?,?)");
			ps.setString(1, fu.getName());
			ps.setString(2, fu.getPassword());
			ps.setString(3, fu.getEmail());
			ps.setString(4, fu.getAddress());
			
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<FacebookUser> viewAllProfileDAO() {
		List<FacebookUser> ll=new ArrayList<FacebookUser>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from facebookuser");
			
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				
				FacebookUser fs=new FacebookUser();
				fs.setName(n);
				fs.setPassword(p);
				fs.setEmail(e);
				fs.setAddress(a);
				
				ll.add(fs);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ll;
	}

	@Override
	public FacebookUser viewProfileDAO(FacebookUser fu) {
		FacebookUser s2=null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from  facebookuser where email=?");
			
			ps.setString(1, fu.getEmail());
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				
				s2=new FacebookUser();
				s2.setName(n);
				s2.setPassword(p);
				s2.setEmail(e);
				s2.setAddress(a);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return s2;
	}

	@Override
	public int deleteProfileDAO(FacebookUser fu) {
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("delete from facebookuser where email=?");
		
			ps.setString(1, fu.getEmail());
			
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<FacebookUser> searchprofileDAO(FacebookUser fu) {
		FacebookUser s2=null;
		List<FacebookUser> ll=new ArrayList<FacebookUser>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from  facebookuser where name=?");
			
			ps.setString(1, fu.getName());
			
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				
				s2=new FacebookUser();
				s2.setName(n);
				s2.setPassword(p);
				s2.setEmail(e);
				s2.setAddress(a);
				
				ll.add(s2);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ll;
	}

	@Override
	public int editProfileDAO(FacebookUser fu) {
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("update facebookuser set name=?,password=?,address=? where email=?");
			ps.setString(1, fu.getName());
			ps.setString(2, fu.getPassword());
			ps.setString(4, fu.getEmail());
			ps.setString(3, fu.getAddress());
			
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public FacebookUser signINDAO(FacebookUser fu) {
		FacebookUser s2=null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from  facebookuser where email=? and password=?");
			
			ps.setString(1, fu.getEmail());
			ps.setString(2, fu.getPassword());
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				
				s2=new FacebookUser();
				s2.setName(n);
				s2.setPassword(p);
				s2.setEmail(e);
				s2.setAddress(a);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return s2;
	}

}
