package com.facebookproject.view;

import java.util.Scanner;

import com.facebookproject.controller.FacebookControllerInterface;
import com.facebookproject.entity.FacebookUser;
import com.facebookproject.utility.ControllerFactory;

public class FacebookView {

	public static void main(String[] args) {
		String s="y";
		
		Scanner sc=new Scanner(System.in);
		
		while(s.equals("y")) {
			
			System.out.println("Welcome to facebook");
			System.out.println("Press 1 to signup");
			System.out.println("Press 2 to signin");
			
			System.out.println("enter choice");
			int ch=sc.nextInt();
			
			FacebookControllerInterface fc=ControllerFactory.createObject();
			FacebookUser fi;
			
			switch(ch) {
			
				case 1:
					fc.createProfileController();
					break;
				
				case 2:
					fi=fc.signIN();
					if(fi!=null) {
						
						while(s.equals("y")) {
						
						System.out.println("***************MAIN MENU*******************");
						System.out.println("press 1 to view all profile");
						System.out.println("press 2 to view profile");
						System.out.println("press 3 to delete profile");
						System.out.println("press 4 to search pfofile");
						System.out.println("press 5 to edit profile");
						System.out.println("press 6 to create timeline");
						
						
						System.out.println("enter choice");
						int cc=sc.nextInt();
						
						switch(cc) {
						case 1:fc.viewAllProfileController();
						break;
						case 2:fc.viewProfileController();
						break;
						case 3:fc.deleteProfileController();
						break;
						case 4:fc.searchProfileController();
						break;
						case 5:fc.editProfileController();
						break;
						case 6:fc.createTimeline();
						break;
						
						default:System.out.println("wrong choice");
						
					}
						System.out.println("press y/n to continue");
						s=sc.next();
					}
				}
					
					else {
						System.out.println("Please use signin");
					}
				
				default:
					System.out.println("enter correct choice");
				
			}
			
			System.out.println("press y/n to continue");
			s=sc.next();
		
			}
					
			
	}
	
			
}

