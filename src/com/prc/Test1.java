package com.prc;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your choice");
		int ch=sc.nextInt();
		switch(ch) {
		case 1:
			System.out.println("a");
			break;
		case 3:
			System.out.println("c");
			break;
		case 2:
			System.out.println("b");
			break;
			default:
				System.out.println("invalid");
		}

	}

}
