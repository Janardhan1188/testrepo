package com.facebookproject.controller;

import java.util.List;
import java.util.Scanner;

import com.facebookproject.entity.FacebookUser;
import com.facebookproject.entity.TimelineDetails;
import com.facebookproject.service.FacebookServiceInterface;
import com.facebookproject.utility.ServiceFactory;

public class FacebookController implements FacebookControllerInterface {
	FacebookServiceInterface fs=null;
	public FacebookController(){
	 fs=ServiceFactory.createObject();
	}
	public void createProfileController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name");
		String name=sc.next();
		System.out.println("enter password");
		String password=sc.next();
		System.out.println("enter email");
		String email=sc.next();
		System.out.println("enter address");
		String address=sc.next();
		
		FacebookUser fu=new FacebookUser();
		fu.setName(name);
		fu.setPassword(password);
		fu.setEmail(email);
		fu.setAddress(address);
		
		
		int i=fs.createProfileService(fu);
		if(i>0) {
			System.out.println("profilr created");
		}
	}

	public void viewAllProfileController() {
		List<FacebookUser>ll=fs.viewAllProfileService();
		
		ll.forEach(s->{
			System.out.println(s.getName());
			System.out.println(s.getPassword());
			System.out.println(s.getEmail());
			System.out.println(s.getAddress());
			});
		
	}
	//@Override
	public void viewProfileController() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter email to view profile");
		String email=sc.next();
		
		FacebookUser fu=new FacebookUser();
		fu.setEmail(email);
		
		FacebookUser s1= fs.viewProfileService(fu);
		
		if(s1!=null) {
			System.out.println("Name is "+s1.getName());
			System.out.println("password is "+s1.getPassword());
			System.out.println("email is "+s1.getEmail());
			System.out.println("address is "+s1.getAddress());
		}
		else {
			System.out.println("profile not found");
		}
	}
	@Override
	public void deleteProfileController() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter email to delete profile");
		String email=sc.next();
		
		FacebookUser fu=new FacebookUser();
		fu.setEmail(email);
		
		int s1=fs.deleteProfileService(fu);
		
		if(s1>0) {
			System.out.println("profile deleted");
		}
		else {
			System.out.println("could not delete profile");
		}
	}
	@Override
	public void searchProfileController() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter name to search profile");
		String name=sc.next();
		
		FacebookUser fu=new FacebookUser();
		fu.setName(name);
		
		List<FacebookUser>ll=fs.searchProfileService(fu);
		
		ll.forEach(s->{
			System.out.println(s.getName());
			System.out.println(s.getPassword());
			System.out.println(s.getEmail());
			System.out.println(s.getAddress());
			});
	}
	@Override
	public void editProfileController() {
		 System.out.println("your old data");
		 viewProfileController();
		 
		 Scanner sc=new Scanner(System.in);
		 System.out.println("enter new name");
		 String name=sc.next();
		 System.out.println("enter new password");
		 String password=sc.next();
		 System.out.println("enter old email");
		 String email=sc.next();
		 System.out.println("enter new address");
		 String address=sc.next();
		 FacebookUser fu=new FacebookUser();
		 fu.setName(name);
		 fu.setPassword(password);
		 fu.setEmail(email);
		 fu.setAddress(address);
		 
		 int i=fs.editProfileService(fu);
		 
		 if(i>0) {
			 System.out.println("your profile is edited "+name);
		 }
		 else {
			 System.out.println("your profile is not edited");
		 }
	}
	@Override
	public FacebookUser signIN() {

		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter email to signin profile");
		String email=sc.next();
		
		System.out.println("enter password to signin profile");
		String password=sc.next();
		
		FacebookUser fu=new FacebookUser();
		fu.setEmail(email);
		fu.setPassword(password);
		
		FacebookUser s1= fs.signINService(fu);
		
		if(s1!=null) {
			System.out.println("You are signed in");
		}
		else {
			System.out.println("unable to signin");
		}
		return s1;
		
	}
	@Override
	public void createTimeline() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Message ID:");
		String messageid=sc.next();
		
		System.out.println("Enter sender ID:");
		String sender=sc.next();
		
		System.out.println("Enter receiver ID:");
		String receiver=sc.next();
		
		System.out.println("Enter Message:");
		String message=sc.next();
		
		System.out.println("Enter Date:");
		String date=sc.next();
		
		TimelineDetails td=new TimelineDetails();
		
	}

}
