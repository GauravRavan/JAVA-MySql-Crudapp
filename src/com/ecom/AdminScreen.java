package com.ecom;

import java.util.Scanner;

import com.ecom.dao.ProductDAO;
import com.ecom.model.Product;

public class AdminScreen {
	private static final String ArrayList = null;
	Scanner sc =new Scanner(System.in);
	ProductDAO pdao= new ProductDAO();

	public  void productMenu()
	{
		int ch=0;
		String name;
		Product p;
		boolean s;
		Float price;
		int id;
		
		do {
			System.out.println("1.insert new product");
			System.out.println("2.list all product");
			System.out.println("3.serach product");
			System.out.println("4.update product");
			System.out.println("5.deleteproduct");
			System.out.println("0. logout");
		
		System.out.println("enter your choice");
		ch=sc.nextInt();
		
		switch(ch) {
		
		case 1:
			System.out.println("Enter name of the product");
			name =sc.next();
			
			System.out.println("Enter price of the product");
			price =sc.nextFloat();
			
			 p = new Product(name,price);
			 s= pdao.addProduct(p);
			if(s==true) 
			{
				System.out.println("product added ");
			}
			else {
				System.out.println("contact admin...");
			}
		break;
		
		case 2:
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
		case 3:
			System.out.println("Enter id");
			id=sc.nextInt();
			
			 p = pdao.searchProduct(id);
			if(p==null) 
			{
				System.out.println("product not found");
			}
			else {
				System.out.println(p);
			}
			break;
		case 4:
			System.out.println("Enter id");
			id=sc.nextInt();
			
			System.out.println("Enter name");
			name =sc.next();
			
			System.out.println("Enter price");
			price =sc.nextFloat();
			
			 p = new Product(name,price);
			 p.setId(id);
			 s= pdao.updateProduct(p);
			if(s==true) 
			{
				System.out.println("product updated ");
			}
			else {
				System.out.println("contact admin...");
			}
			break;
			
		case 5:
			System.out.println("Enter id");
			id=sc.nextInt();
			
			 s= pdao.deleteProduct(id);
			if(s==true) 
			{
				System.out.println("product deleted");
			}
			else {
				System.out.println("contact admin...");
			}
			break;
		case 0:
			System.out.println("logout!!!");
			break;
		default:
				System.out.println("invalid");
			}
			
		}
		
		while(ch!=0);

	}

}
