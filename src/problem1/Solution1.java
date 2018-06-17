package problem1;

import java.util.Scanner;

public class Solution1 {
	public static void main(String[] args) {
		System.out.print("Please write a positive numnber or zero in range from 0 to 100 ");
		Scanner sc = new Scanner(System.in);

		String ch = sc.next();
		
		if(!ch.matches("^[\\-d|\\d]+$"))
		{
			 throw new IllegalArgumentException("Only allow numeric values");
			
		}
		
		Integer  value=Integer.parseInt(ch);
		if(value>100)
		{
			throw new IllegalArgumentException("Your value is more greater that 100 ");
		}
		
		if(value<0)
		{
			throw new IllegalArgumentException(" Upps your value is les that zero");
		}
		else
		{
			System.out.printf("Upa your value is correct %s \n" ,value );
			return ;
		}
			
		
	}
}
