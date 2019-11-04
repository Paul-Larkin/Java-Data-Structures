package cs210algorithms;

import java.util.Scanner;

/*
 * @author: Paul_Larkin
 * @date: 29/04/2019
 * @description: Preform Collatz Conjecture on a number to 
 * measure the number of steps before the number returns 
 * the the value of 1
 * 
 * @details: The Collatz conjecture is a conjecture in 
 * mathematics that concerns a sequence defined as follows: 
 * Start with any positive integer n. 
 * Then each term is obtained from the previous term as follows: 
 * If the previous term is even, the next term is one half the previous term. 
 * If the previous term is odd, the next term is 3 times the previous term plus 1. 
 * The conjecture is that no matter what value of n, the sequence will always reach 1. 
 */

public class Lab2_Collatz_Conjecture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner userInput = new Scanner (System.in);
		
		System.out.println("Please enter a number to perform Collatz Conjecture");
		
		long chosenNumber = userInput.nextLong();
		
		userInput.close();
		
		long steps = (performCollatz(chosenNumber));
		
		System.out.println("The number of steps was: "+steps);
	}
	
	public static long performCollatz(long longNumber) {
		
		long stepsTaken = 0; 
		
		while(longNumber>1) { //Loop until the longNumber becomes 1
			
			if (longNumber%2 == 0) {
				longNumber /=2; //Even numbers divided by 2
			}
			else {
				longNumber *=3;
				longNumber ++; //Odd numbers mult by 3 add 1
			}
			stepsTaken ++; //Counting the steps
		}
		return stepsTaken; //Return result
	}
}
