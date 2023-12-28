package com.ilp.service;
import java.util.ArrayList;
import java.util.Scanner;
import com.ilp.entity.Account;
import com.ilp.entity.CurrentAccount;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;

public class AccountServices {
	
	
	public static void createServices(ArrayList<Service> serviceList)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the service code\n");
		String serviceCode = sc.nextLine();
		System.out.println("Enter the service name\n");
		String serviceName = sc.nextLine();
		System.out.println("Enter the rate\n");
		double rate = sc.nextDouble();
        Service service = new Service(serviceCode,serviceName,rate);		
        serviceList.add(service);
        System.out.println(serviceList);
		
	}
	public static void createProducts(ArrayList<Product> productList,ArrayList<Service> serviceList)
	{
	   char choiceService = 0;
	   char choiceProduct = 0;
	   Product product = null;
	   
		do {
		ArrayList<Service> productService = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the product code\n");
		String productCode = sc.nextLine();
		System.out.println("Enter the product name\n");
		String productName = sc.nextLine();
		do
		{
		System.out.println("Enter the type of service you want to use \n");
		String serviceType = sc.nextLine();
        
		for(Service service:serviceList)
		{
          if(service.getServiceName().equals(serviceType))
        		  {
        	         productService.add(service);
        		  }
        		  if(productName.equalsIgnoreCase("SavingsMaxAccount"))
        		  {
        			  product = new SavingsMaxAccount(productCode,productName,productService);
        			  productList.add(product);
        		  }
        		  else if(productName.equalsIgnoreCase("CurrentAccount"))
        		  {
        			  product = new CurrentAccount(productCode,productName,productService);
        			  productList.add(product);
        		  }
        		  else if(productName.equalsIgnoreCase("LoanAccount"))
        		  {
        			  product = new LoanAccount(productCode,productName,productService);
        			  productList.add(product);
        		  }
        		  
		System.out.println("Do you want to add more services\n");
		choiceService =sc.next().charAt(0);
	   }
	
		}while(choiceService=='y'|| choiceService =='Y');
		System.out.println("Do you want to add more products\n");
		 choiceProduct =sc.next().charAt(0);
		
		}while(choiceProduct=='y'|| choiceProduct =='Y');
	}
	

	
	
	
	
//	public static Account createAccount(ArrayList<Product> productList)
//	{
//		
//		
//		Scanner sc =new Scanner(System.in);
//		System.out.println("Enter the Account Number\n");
//		String accountNo = sc.next();
//		System.out.println("Enter the Account balance\n");
//		double balance = sc.nextDouble();
//		System.out.println("1. Savings Max Account   2.Current Account   3.Loan Account\n");
//		System.out.println("Enter your choice of account you want to create");
//		accountChoice = sc.next().charAt(0);
//		Product selectedProduct = productList.get(0)
		
		
		
		
		
		
		
		
		
//	}
	
	public static Customer createCustomer(Customer customer,ArrayList<Product> productList)
	{
		ArrayList<Account> accountList = new ArrayList<>();
		Scanner sc =new Scanner(System.in);
		int accountChoice;
		Product customerProduct;
		Customer customer1 = null;
	    if(customer1 == null)
		{
			Account account = null;
			//Product customerProduct;
			System.out.println("Enter the customer code\n");
			String customerId = sc.nextLine();
			System.out.println("Customer Id not available.Create a new Account.");
			System.out.println("********Accounts Available********");
			System.out.println("1. Savings Max Account   2.Current Account   3.Loan Account\n");
			System.out.println("Enter your choice of account you want to create");
			accountChoice = sc.nextInt();
			System.out.println("Enter the customer code\n");
			String customerCode = sc.next();
			System.out.println("Enter the customer name\n");
			String customerName = sc.next();
			sc.nextLine();
			switch(accountChoice)
			{ 
			case 1:
				for(Product product:productList)
				{
					if(product.getProductName().equalsIgnoreCase("SavingsMaxAccount")){
						customerProduct = product;
						account = createSavingMaxAccount(customerProduct);
					System.out.println(account);
						accountList.add(account);
						customer = new Customer(customerCode,customerName,accountList);
						System.out.println(customer);

					}
				}
			   
			break;
			case 2:
				for(Product product:productList)
				{
					if(product.getProductName().equalsIgnoreCase("CurrentAccount")){
						customerProduct = product;
						account = createCurrentAccount(customerProduct);
						//System.out.println(account);
						accountList.add(account);
						customer = new Customer(customerCode,customerName,accountList);
						System.out.println(customer);

					}
				}
				
				break;
			case 3:
				for(Product product:productList)
				{
					if(product.getProductName().equalsIgnoreCase("LoanAccount")){
						customerProduct = product;
						account = createLoanAccount(customerProduct);
						accountList.add(account);
						customer = new Customer(customerCode,customerName,accountList);
						//System.out.println(customer);
						return customer;
					}
				}
				
//			default:
//				System.out.println("Enter a valid choice of account\n");
//				break;
	      }
			 customer = new Customer(customerCode,customerName,accountList);
		 }
		return customer;
	    
		}
	
	private static Account createLoanAccount(Product customerProduct) {
		
		Scanner sc =new Scanner(System.in);
	    System.out.println("Enter the Account Number\n");
	    String accountNo = sc.next();
	    System.out.println("Enter the Account balance\n");
	    double balance = sc.nextDouble();
	    System.out.println("Enter the Account Type\n");
	    String accountType = sc.next();
	   
		Account account = new Account(accountNo,accountType,balance,customerProduct);
	    return account;
	}
	private static Account createCurrentAccount(Product customerProduct) {
	
		Scanner sc =new Scanner(System.in);
	    System.out.println("Enter the Account Number\n");
	    String accountNo = sc.next();
	    System.out.println("Enter the Account balance\n");
	    double balance = sc.nextDouble();
	    System.out.println("Enter the Account Type\n");
	    String accountType = sc.next();
	    Account account = new Account(accountNo,accountType,balance,customerProduct);
	    return account;
	}
	private static Account createSavingMaxAccount(Product customerProduct) {
		
		Scanner sc =new Scanner(System.in);
	    System.out.println("Enter the Account Number\n");
	    String accountNo = sc.next();
	    System.out.println("Enter the Account balance\n");
	    double balance = sc.nextDouble();
	    System.out.println("Enter the Account Type\n");
	    String accountType = sc.next();
	    Account account = new Account(accountNo,accountType,balance,customerProduct);
	    return account;
		
	}
	
public static void ManageAccounts(Customer customer,ArrayList<Product> productList) 
	{  
	    
		Scanner sc = new Scanner(System.in); 
		ArrayList<Account> tempAccountList = null;
		Account myAccount = null;
		System.out.println("Enter the customer Id \n");
		String checkCustomerCode= sc.next();
		if(customer.getCustomerCode().equalsIgnoreCase(checkCustomerCode))
		{
			System.out.println(customer.getCustomerName() +" has the following accounts\n");
		}
		
		
		tempAccountList = customer.getAccountList();
		for(Account account : tempAccountList) 
		{
			System.out.println(account.getAccountType());
		
	    }
		System.out.println("Enter your choice\n");
		String currentAccountChoice = sc.next();
		
		for(Account account : tempAccountList) 
		{
			if(account.getAccountType().equalsIgnoreCase(currentAccountChoice))
				myAccount = account;	
		}
		
		
		
		System.out.println("1. deposit money 2.Withdraw Money 3. View balance");
		System.out.println("Enter your choice of operation");
		int currentAccountChoiceOperation = sc.nextInt();
		char operationChoice;
		do
		{
		switch(currentAccountChoiceOperation)
		{
		case 1:depositMoney(myAccount);
		        break;
		case 2:withdrawMoney(myAccount); 
		        break;
		case 3:viewBalance(myAccount);
		        break;
	    }
		System.out.println("Do you want to continue the operations\n");
		operationChoice= sc.next().charAt(0);
		}while(operationChoice=='y'||operationChoice=='Y');
		
	
	}
public static void depositMoney(Account myAccount)
{  
	Scanner sc = new Scanner(System.in);
	if(myAccount.getProduct() instanceof SavingsMaxAccount)
	{
		System.out.println("Enter the amount to be deposited\n ");
		double deposit =sc.nextDouble();
		double newBalance = myAccount.getBalance() + deposit;
		System.out.println("Your current balance  : " + newBalance);
	}
	else if(myAccount.getProduct() instanceof CurrentAccount)
	{
		System.out.println("Enter the amount to be deposited\n ");
		double deposit =sc.nextDouble();
		double newBalance = myAccount.getBalance() + deposit;
		System.out.println("Your current balance  : " + newBalance);
	}
	else if(myAccount.getProduct() instanceof LoanAccount)
		{			
		System.out.println("Deposit method ");
		System.out.println("1.Cash or 2.Cheque");
		int depositLoanChoice = sc.nextInt();
		 
		switch(depositLoanChoice) {
		case 1:
			System.out.println("Enter the amount to be deposited\n");
			double deposit = sc.nextDouble();
			double newBalance = myAccount.getBalance() + deposit;
			myAccount.setBalance(newBalance);
			System.out.println("Your current balance is"+ newBalance);
			break;
		case 2:
			System.out.println("Enter amount to be deposited : ");
			double depositCheque = sc.nextDouble();
			double chargePercentage = 0.003;   
			double chargeAmount = depositCheque * chargePercentage;
			double actualDepositAmount = depositCheque - chargeAmount;
			double newBalanceCheque = myAccount.getBalance()+actualDepositAmount;
			System.out.println("Your current balance  : " + newBalanceCheque);
			break;
		}
		
		
		}
}

public static void withdrawMoney(Account myAccount)
{
	
	Scanner sc = new Scanner(System.in);
	if(myAccount.getProduct() instanceof SavingsMaxAccount)
	{
	System.out.println("Enter the amount to withdrawn");
	double withdraw = sc.nextDouble();
	if(myAccount.getBalance() - withdraw < 1000)
		{System.out.println("Sorry !!!!!!! A minimum of Rs 1000 should be maintained in the account\n");}
	else 
	{
	double newBalance = myAccount.getBalance() - withdraw;
	System.out.println("Your balance is "+newBalance);
	}
	
}
	if(myAccount.getProduct() instanceof CurrentAccount)
	{
		System.out.println("Enter amount to be withdrawn : ");
		double withdraw = sc.nextDouble();
		double newBalance = myAccount.getBalance() - withdraw;

		if ((newBalance) < 0)
			System.out.println("Account cannot be empty");
		else 
		{
			double newBalanceWithdraw = myAccount.getBalance() - withdraw;
			myAccount.setBalance(newBalanceWithdraw);
			System.out.println("Your current balance  : " + newBalanceWithdraw);
	}
	}
	
	
}
	
public static void viewBalance(Account myAccount)
{
	System.out.println("Current Balance: " + myAccount.getBalance());
	
	
}


public static void display(Customer customer)
{
System.out.println("**************************CUSTOMER DETAILS***********************");
System.out.println("CustomerID         CustomerName        AccountType        Balance");
System.out.println("*****************************************************************");
ArrayList<Account> accountList = customer.getAccountList() ;
ArrayList<Service> serviceList;
for(Account account:accountList)
{
	System.out.println(customer.getCustomerName()+"  "+customer.getCustomerCode()+"   "+account.getAccountType()+"       "+account.getBalance());
	System.out.println("Your services are");
	serviceList = account.getProduct().getServiceList();
			for(Service service: serviceList)
	{
		System.out.println(service.getServiceName());
	}
}
}
}





