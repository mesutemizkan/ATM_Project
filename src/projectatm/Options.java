package projectatm;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Options extends Account{
	
	Scanner scan = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	HashMap <Integer, Integer> accountNoPinNo = new HashMap<>();
	
	public void checkingOperations() {
		do {
		System.out.println("Select Options for Checking Account: \n1.View Balance \n2.Withdraw \n3.Deposit \n4.Exit");
		int option = scan.nextInt();
		if(option == 4) {
			break;
		}
		switch(option) {
		case 1:
			System.out.println("Your checking account balance is: "+ moneyFormat.format(getCheckingBalance()));
			break;
		case 2:
			if(getCheckingBalance()>0) {
			getWithdrawChecking();
			}else {
				System.out.println("When the balance is 0 it is impossible to withdraw");
				System.out.println("You need to deposit first");
			}
			break;
			
		case 3:
			getDepositChecking();
			break;
			default:
				System.out.println("Invalid option, please enter 1,2,3 or 4");
		}
		
		}while(true);
		
		
	}
	
	public void savingOperations() {
		do {
		System.out.println("Select Options for Saving Account: \n1.View Balance \n2.Withdraw \n3.Deposit \n4.Exit");
		int option = scan.nextInt();
		if(option == 4) {
			break;
		}
		switch(option) {
		case 1:
			System.out.println("Your saving account balance is: "+ moneyFormat.format(getSavingBalance()));
			break;
		case 2:
			if(getSavingBalance()>0) {
			getWithdrawSaving();
			}else {
				System.out.println("When the balance is 0 it is impossible to withdraw");
				System.out.println("You need to deposit first");
			}
			break;
			
		case 3:
			getDepositSaving();
			break;
			default:
				System.out.println("Invalid option, please enter 1,2,3 or 4");
		}
		
		}while(true);
		
	}
	
	public void selectAccount() {
		do {
			System.out.println("Select Options:");
			System.out.println("1.Checking Account Operations");
			System.out.println("2.Saving Account Operations");
			System.out.println("3.Exit");
			int option = scan.nextInt();
			if(option == 3) {
				break;
			}else if(option == 1) {
				checkingOperations();
			}else if(option == 2) {
				savingOperations();
			}else {
				System.out.println("Invalid option, please enter 1,2 or 3");
			}
			
		}while(true);
	}
	
	public void login() {
		accountNoPinNo.put(12345, 1234);
		accountNoPinNo.put(23456, 2345);
		accountNoPinNo.put(34567, 3456);
		accountNoPinNo.put(45678, 4567);
		accountNoPinNo.put(56789, 5678);
		
		System.out.println("Hi, Welcome to ATM....");
		
		do {
			System.out.println("Enter your account number please");
			setAccountNumber(scan.nextInt());
			
			System.out.println("Enter your pin number please");
			setPinNumber(scan.nextInt());
			int counter=0;
			for( Map.Entry<Integer,Integer> w : accountNoPinNo.entrySet()) {
				
				if(w.getKey()==getAccountNumber() && w.getValue() == getPinNumber()) {
					selectAccount();
				}else {
					counter++;
				}
			}
			if(counter == accountNoPinNo.size()) {
				System.out.println("Account number or pin number or both are not matching");
				System.out.println("Press any integer to try again or 'Q' to quit");
				String exit = scan.next();
				if(exit.equalsIgnoreCase("q")) {
					System.out.println("Thank you, have a nice day");
					break;
				}
			}
		}while(true);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
