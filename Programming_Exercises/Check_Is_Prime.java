package algorithms;

import java.util.Scanner;

/*
 * @author: Paul_Larkin
 * @date: 13/05/2019
 * @description: Check if the user
 * input integer is that of an 
 * Prime Number.
 * 
 * Prime number is one the is
 * divisible only by 1 and itself
 * 
 */

public class Check_Is_Prime {

	
	public static void main(String[] args) {
		
		int number = 0;
		
		Scanner userInput = new Scanner (System.in);
		
		System.out.println("Please enter a number");
		
		if(userInput.hasNextInt()) {
			number = userInput.nextInt();
		}
		else {
			System.out.println("Next time enter a number");
			System.exit(0);
		}
		
		userInput.close();
		
		checkIsPrime(number);
	}
	
	public static void checkIsPrime(int number) {
		
		boolean isPrime = true;
		
		for(int i = 2; i < Math.sqrt(number); i++) {
			
			if(number%i == 0) {
				isPrime = false;
			}
		}
			
		if(isPrime) {
			System.out.println("True: "+number+" is an Prime Number");
		}else {
			System.out.println("False: "+number+" is NOT an Prime Number");
		}	
	}
}
