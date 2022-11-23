package com.ecom;

import java.util.Scanner;

import com.ecom.dao.ProductDAO;
import com.ecom.dao.UserDAO;
import com.ecom.model.Product;
import com.ecom.model.User;

public class UserScreen {
	Scanner sc = new Scanner(System.in);

	public void init() {
		int ch;
		String email,pass,name;
		int mobile;
		String res;
		UserDAO uDAO = new UserDAO();
		do {

		System.out.println("1. Register ");
		System.out.println("2. Login");
		System.out.println("0. logout");

		System.out.println("enter your choice");
		ch = sc.nextInt();
		
			switch (ch) {
			case 1:
				System.out.println("enter name");
				name=sc.next();
				
				System.out.println("enter Emailid");
				email=sc.next();
				
				System.out.println("enter Password");
				pass=sc.next();
				
				System.out.println("enter mobile");
				mobile=sc.nextInt();
				
				User u = new User(name,email,pass,mobile);
				boolean s = uDAO.register(u);
				if(s==true) {
					System.out.println("registred succsesfully");
				}
				else {
					System.out.println("try again");
				}
				
				
				break;
			case 2:
				System.out.println("enter Emailid");
				email=sc.next();
				System.out.println("enter Password");
				pass=sc.next();
				
				res = uDAO.login(email, pass);
				if (res == null)
				{
					System.out.println("invalid");
				}
				else {
					System.out.println("welcome :" + res);
					producutMenu();
					
				}
				
				
				///validate data:
				
				break;
			case 0:
				System.out.println("bye");
				break;

			default:
				System.out.println("invalid choice");
			}
		} while (ch != 0);
	}



public void producutMenu() {
	int ch;
	ProductDAO pdao =new ProductDAO();
	
	do {
		System.out.println("1.list all product");
		System.out.println("0.logout");
		System.out.println("2.search product");
		
		System.out.println("enter your choice");
		
		ch = sc.nextInt();
		
		switch(ch) {
		case 1:
			java.util.ArrayList<Product> lst = pdao.getAllProducts();
			if(lst.isEmpty()==true)
			{
				System.out.println("there are no product");
			}
			else
			{
				for(Product temp : lst)
				{
					System.out.println(temp);
				}
			}
		break;
		case 2:
			System.out.println("Enter id");
		int id=sc.nextInt();
		
		Product p = pdao.searchProduct(id);
		if(p==null) 
		{
			System.out.println("product not found");
		}
		else {
			System.out.println(p);
		}
		break;
		case 0:System.out.println("bye user");
		break;
		
		default:
			System.out.println("invalid");
			
		}
		
	}
	while(ch!=0);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}