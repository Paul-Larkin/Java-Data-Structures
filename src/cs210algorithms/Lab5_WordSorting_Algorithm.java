package cs210algorithms;

import java.util.Scanner;

/*
 * @author: Paul Larkin
 * @date: 30/04/2019
 * @description: The user will enter a number 'n'
 * then enter'n' number of random words, the 
 * output of the program will be a list of all
 * the words entered in order of the amount of 
 * character they contain. If a two or more
 * words contain the same number of characters
 * the they will be ordered alphabetically.
 * Smallest to largest and A-Z.
 */

public class Lab5_WordSorting_Algorithm {
	
	public static void main (String[]args) {
	
	Scanner userInput = new Scanner (System.in);
	
	int numberOfWords = Integer.parseInt(userInput.nextLine());
	
	String[] wordArray = new String[numberOfWords];

		for(int i = 0; i < wordArray.length; i++) {
			wordArray[i] = userInput.nextLine();
		}
		
		userInput.close();
		
		sortArray(wordArray);
		
		printArray(wordArray);
	}	
	
	public static void printArray (String[] arrayToPrint) {
		
		for(int i = 0; i < arrayToPrint.length; i++) {
			System.out.println(arrayToPrint[i]); //Simple print array method
		}
	}
	
	public static void sortArray (String[] wordArray) {
		
		for(int i = 0; i < wordArray.length; i++) {
			
			for(int j = 0; j < wordArray.length-1; j++) {
				
				//Compare length and keep smaller words to the left of the array
				if(wordArray[j].length() > wordArray[j+1].length()) { //Swap if 
					
					String tempString = wordArray[j]; //Swap words
					wordArray[j]= wordArray[j+1];
					wordArray[j+1] = tempString;
				}
				
				//If same length compare alphabetically ignoring case
				if((wordArray[j].length() == wordArray[j+1].length()) 
					&& ((wordArray[j].compareToIgnoreCase(wordArray[j+1]))>0)) {
					
					String tempString = wordArray[j]; //Swap words
					wordArray[j]= wordArray[j+1];
					wordArray[j+1] = tempString;
				}
			}
		}
	}
}
