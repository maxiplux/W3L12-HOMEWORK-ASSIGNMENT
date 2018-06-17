package problem2;

import java.util.Scanner;

public class CustomerAccount {
	String Cus_name ;
	String Acc_No ;
	Double Balance ;
	private final Double MAX_VALUE_ON_ACCCOUNT=100.0;
	
	public CustomerAccount(String cus_name, String acc_No, Double balance) {
		
		if (balance<this.MAX_VALUE_ON_ACCCOUNT )
		{
			throw new CustomerAccountException(String.format("Withdraw :Balance Initial reach below 100$ :  to new customer %s  intial  is %s  Check and try again ", cus_name,balance));
			
		}
		
		 
		this.Cus_name = cus_name;
		this.Acc_No = acc_No;
		this.Balance = balance;
	}
	@Override
	public String toString() {
		
		return String.format("|Name(%s) :<Id:%s, Balance:$%,.2f>|", this.Cus_name,this.Acc_No,this.Balance);
	}
	
	public boolean Withdraw(Double value) 
	{
		
		if (value<=0)
		{
			throw new CustomerAccountException("Withdraw : only positive values ​​are allowed");
			
		}
		
		if (value > this.Balance)
		{
			throw new CustomerAccountException(String.format("Withdraw (Withdraw amount exceed the balance):Amount not allowed :   can not Witdraw %s because your balance is %s", value,this.Balance) );
			
		}
		
		
		if (this.Balance-value>=this.MAX_VALUE_ON_ACCCOUNT )
		{
			throw new CustomerAccountException(String.format("Withdraw :Balance reach below 100$ :   request is %s and your current balance %s", value,this.Balance));
			
		}
		
		this.Balance=this.Balance-value;
		return true;
	}
	
	public boolean deposit(Double value)
	
	
	{
		
		
		if (value<=0)
		{
			throw new CustomerAccountException(String.format("Deposit : only positive values ​​are allowed , value <%s>", value) );
		}
		
		 
		
		this.Balance=this.Balance+value;		
		return true;
	}
	
	public static void main(String[] args) {
		CustomerAccount pedro=  new CustomerAccount("Pedro", "A32241E", 170.0);
		pedro.deposit(130.0);
		
		try 
		{
			pedro.deposit(320.0);
		}
		catch (CustomerAccountException e) 
		{
			System.err.println(e.getMessage()+"\n");
		}
		
		
		try 
		{
			pedro.deposit(-92.0);
		}
		catch (CustomerAccountException e) 
		{
			System.err.println(e.getMessage()+"\n");
		}
		
		try 
		{
			pedro.Withdraw(700.0);
		}
		catch (CustomerAccountException e) 
		{
			System.err.println(e.getMessage()+"\n");
		}
		
		System.out.println(pedro);
		

		try 
		{
			new CustomerAccount("Farid", "A232241E", 10.0);
		}
		catch (CustomerAccountException e) 
		{
			System.err.println(e.getMessage()+"\n");
		}
		
		
		
	}
	
}
