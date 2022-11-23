package com.ecom;

import java.util.Scanner;

import com.ecom.dao.AdminDAO;

public class HomeScreen {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int ch;
		boolean status=true;
		AdminScreen adscreen;  //declaration
		adscreen = new AdminScreen();  //memoery allocation
		
		UserScreen usscreen;
		usscreen = new UserScreen();
		
		AdminDAO adminDAO =new AdminDAO();
		
		
		String email , pass;
		do {
		System.out.println("1. admin");
		System.out.println("2. user");
		System.out.println("0. exit");
		System.out.println("enter your choice");
		  ch=sc.nextInt();
		
		switch(ch) {
		case 1:
			System.out.println("welcome admin!!!");
			System.out.println("enter email id");
			email=sc.next();
			
			System.out.println("enter Password");
			pass=sc.next();
			
			status = adminDAO.login(email,pass);
			if(status==true)
			{
				adscreen.productMenu();
			}
			else 
			{
				System.out.println("incorrect credential");
			}
			break;
			
		case 2:
			System.out.println("welcome user");
			usscreen.init();
			
			
			
			break;
		case 0:
			System.out.println("good bye");
			break;
		default:
			System.out.println("something went wrong");
		
		}
		}
		while(ch!=0);
	}

}
