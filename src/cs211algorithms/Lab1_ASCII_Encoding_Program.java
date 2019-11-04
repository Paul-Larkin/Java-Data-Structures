package cs211algorithms;

import java.util.Scanner;

/*
 * @author: Paul Larkin
 * @date: 21/02/2019
 * @description: The challenge here was to perform
 * ASCII encoding on a given sentence, the letter 
 * frequence should also be displayed to the user.
 *
 */

public class Lab1_ASCII_Encoding_Program {

	public static void main(String[] args) {
		System.out.print("Please enter a sentence: \n");
		Scanner userInput = new Scanner (System.in);
		String input = userInput.nextLine();
		
		userInput.close();
		
		int[] ascii = new int [256];
		int num;
		
		for(int i=0; i<input.length(); i++) {
			num = input.charAt(i);
			System.out.print(Integer.toBinaryString(num) + " ");
			ascii[num]++;
		}
		
		System.out.println();
		
		for(int i=0; i<ascii.length; i++) {
			if(ascii[i]>=1) {
				System.out.println("The letter \"" + (char)i + "\" occurs " + ascii[i] + " times");
			}
		}	
	}
}