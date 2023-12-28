package com.ilp.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Service;
import com.ilp.service.AccountServices;

public class BankUtility {

	

	public static void main(String args[])
	{
		ArrayList<Service> customerServiceChoices = new ArrayList<>();
		ArrayList<Product> productList = new ArrayList<>();
		ArrayList<Service> serviceList = new ArrayList<>();
		Customer customer = null;
		Scanner sc = new Scanner(System.in);
		int mainMenuChoice =0;
		char mainMenu='y';
		do
		{
		System.out.println("*******Welcome To Bank*********\n"); 
		System.out.println("SERVICES PROVIDED\n 1. Create Service  2.Create Product  3. Create Customer  4.Manage accounts  5.Display Customer 6.Exit");
		System.out.println("Enter your choice\n");
		mainMenuChoice = sc.nextInt();
		switch(mainMenuChoice)
		{
		case 1:
			AccountServices.createServices(serviceList);
//			System.out.println(serviceList);
			break;
		case 2:
			AccountServices.createProducts(productList,serviceList);
//			System.out.println(serviceList);
			System.out.println(productList);
			for(Product product : productList)
				System.out.println(product);
			break;
			
		case 3:
			customer = AccountServices.createCustomer(customer,productList);
			System.out.println(customer);
			
			break;
		case 4:
			AccountServices.ManageAccounts(customer,productList);
			break;
		case 5:
			AccountServices.display(customer);		}
		System.out.println("Go back to main menu (Y/N)");
		mainMenuChoice =sc.next().charAt(0);
		
		
		}while(mainMenuChoice == 'y' ||mainMenuChoice == 'Y');
		  
	}
			
		
		
	
	}

