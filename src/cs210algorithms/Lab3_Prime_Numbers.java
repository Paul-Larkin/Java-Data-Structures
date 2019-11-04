package cs210algorithms;

import java.util.Scanner;

/*
 * @author: Paul_Larkin
 * @date: 29/04/2019
 * @description: Find the Nth prime number.
 * 
 * @details: The user enters a number 'n' and 
 * the program will return the prime number 
 * that occurs at this point, the 'Nth' prime.
 * If the user enters 3, the return will be 5.
 * If the user enters 6, the return will be 13.
 */

public class Lab3_Prime_Numbers {

	public static void main(String args[] ) {
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Please enter a number");
			
		int n = userInput.nextInt();
		
		userInput.close();
		
		int nthPrime = getNthPrime(n);
		
		System.out.println("The "+n+"th prime number is " +nthPrime);
	}
	
	public static int getNthPrime(int primeToFind) {
		
		int counter = 0; //Counts the number of primes found
		
		int isPrime = 2; //Start with 2 as 1 is not prime
		
		boolean check= true; //Preset check to true assuming a num is prime unless proved otherwise
		
		while(counter < primeToFind) { //Only loop till the nTh no greater
			
			//Checks if 'isPrime' is divisible by smaller nums beginning with 2
			for(int checkDivisible = 2; checkDivisible < isPrime; checkDivisible++){ 
				
				if(isPrime%checkDivisible == 0) {
					check= false; //False indicating not a prime number
				}
			}
			if(check == true){
				counter++; //We found a prime now lets find the next
			}
				
			check = true; //Reset check to true
				
			isPrime++; //Increment and check is the next number a prime
		}
		return isPrime -1; //-1 because isPrime will attempt to check the next number as per while loop condition
	}
}

