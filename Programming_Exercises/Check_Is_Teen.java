package algorithms;

import java.util.Scanner;

/*
 * @author: Paul Larkin
 * @date: 14/02/2019
 * @description: Java book exercise.
 * 
 * @details: Write a program that 
 * contains a method tha takes in
 * an age and prints out if the age 
 * corresponds to that of a teenager.
 */

public class Check_Is_Teen {

	public static void main(String[] args) {
		
		int age = 0;	
		
		Scanner userInput = new Scanner (System.in);
		
		System.out.println("Please enter a number");
		
		if(userInput.hasNextInt()) {
			age = userInput.nextInt();
		}
		else {
			System.out.println("Next time enter a number");
			System.exit(0);
		}
		userInput.close();
		
		checkIsTeen(age);
	}
	
	private static void checkIsTeen (int age) {
		
		if(age>=13 && age<=19) {
			System.out.println("This IS the age of a Teenager");
		}
		else {
			System.out.println("This is NOT the age of a Teenager");
		}
	}
}
