package algorithms;

import java.util.Scanner;

/*
 * @author: Paul_Larkin
 * @date: 13/05/2019
 * @description: Check if the user
 * input integer is that of an 
 * Armstrong Number.
 * 
 * An Armstrong number is one the is
 * equal to the sum of each individual
 * number it contains cubed.
 * 
 * Example: 371 = (3^3)+(7^3)+(1^3)
 * 
 */

public class Check_Is_ArmstrongNumber {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner (System.in);
		
		System.out.println("Please enter a number");
		
		int number = 0;
				
		if(userInput.hasNextInt()) {
			number = userInput.nextInt();
		}
		else {
			System.out.println("Next time enter a number");
			System.exit(0);
		}
		
		userInput.close();
		
		checkIsArmstrong(number);
	}
	
	public static void checkIsArmstrong(int number) {

		int result = 0;
		int originalNumber = number;
		
		while (number!=0) {
			
			int modRemainder = number%10;
			result += (modRemainder*modRemainder*modRemainder);
			number /= 10;
		}
		
		if(originalNumber == result) {
			System.out.print("True: "+originalNumber+" is an Armstrong Number");
		}else {
			System.out.print("Fale: "+originalNumber+" is Not an Armstrong Number");
		}
	}
}
