package cs210algorithms;

/*
 * @author: Paul Larkin
 * @date: 23/10/2018
 * @description: Using Monte Carlo Algorithm to see if
 * presedential race 2018 results will match the order
 * of candidate likelyhood to win from favorite to 
 * least likely.
 *
 * @details This is a program designed for CS210 Lab4
 * It take in a number as a 'int' data type, then uses the number to 
 * perform a series of itterations. Leading to the Monte Carlo
 * simulation technique.
 *
 * Using excel I have calculated the probability of placings in 
 * the 2018 Irish presedential election.
 *
 * The loop will create arrays with that only survive the scope of 
 * the current itteration. If the array created is equal to an array
 * the lists the predictios order as per paddy power a counter will
 * incremenet. Using this incrementation I can calculate the 
 * probability of the result being the same as the prediction.
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lab4_Monte_Carlo_Algorithm {

	public static void main (String [] args){

		//Declared an array to store the candidates in the order of Paddy Power prediction
		String [] paddys_Predictions = {"Michael D. Higgins", "Sean Gallagher", "Liadh NiRiada", "Peter Casey", "Joan Freeman", "Gavin Duffy"};
			String [] election_result = new String [6];//Declare an array left empty to store the election results as they are produced
		
		double count = 0;//Double count used to count the times a created array is identical to predicted array

		Random rand = new Random();//Call to random number
			double random_Number;//Declare a double to use as the holder for random number

		Scanner userInput = new Scanner(System.in);//Call to use scanner
			System.out.println("Please Enter a Number of Itterations to Perform"); //Prompt the user to input a number
				int num_Itterations = userInput.nextInt();//New variable int that holds number of itterations
				userInput.close();
					System.out.println("We will perform " + num_Itterations + " Itterations");
						System.out.println(" "); //Blank line

		for (int i = 1; i <=num_Itterations; i++){ // For loop to itterate 1000 times to give monte carlo effect
		random_Number = rand.nextDouble() * 100.00 + 0.00;	//Generate random number between 0 and 100, it is a double

			if (random_Number>0.00 && random_Number<=98.00){ //If statement with likelyhood of candidate paddy selected being first
				election_result[0] = "Michael D. Higgins"; //If statement is true, candidate enters the array
		
				random_Number = rand.nextDouble() * 100.00 + 0;	//Generate random number between 0 and 100, it is a double
				if (random_Number>0.00 && random_Number<=43.33){ //If statement with likelyhood of candidate paddy selected being second
					election_result[1] = "Sean Gallagher";//If statement is true, candidate enters the array
				
					random_Number = rand.nextDouble() * 100.00 + 0;	//Generate random number between 0 and 100, it is a double
					if (random_Number>0.00 && random_Number<=46.29){ //If statement with likelyhood of candidate paddy selected being third
						election_result[2] = "Liadh NiRiada";//If statement is true, candidate enters the array
					
						random_Number = rand.nextDouble() * 100.00 + 0;	//Generate random number between 0 and 100, it is a double
						if (random_Number>0.00 && random_Number<=43.10){ //If statement with likelyhood of candidate paddy selected being fourth
							election_result[3] = "Peter Casey";//If statement is true, candidate enters the array
						
							random_Number = rand.nextDouble() * 100.00 + 0;	//Generate random number between 0 and 100, it is a double
							if (random_Number>0.00 && random_Number<=50.00){ //If statement with likelyhood of candidate paddy selected being fifth
								election_result[4] = "Joan Freeman";//If statement is true, candidate enters the array
							
								random_Number = rand.nextDouble() * 100.00 + 0;	//Generate random number between 0 and 100, it is a double
								if (random_Number>0.00 && random_Number<=100){ //If statement with likelyhood of candidate paddy selected being sixth
									election_result[5] = "Gavin Duffy";	//If statement is true, candidate enters the array
								
									if (Arrays.equals(election_result, paddys_Predictions) == true) {//If statement to see if the array created is identical to the prediction array
									count ++; // if so the count will increase by one
									}			
									else {//Else the count remains the same
									count = count;
									}
								}
							}
							else{
								election_result[4]="Not Freeman";
							}
						}
						else{
							election_result[3]="Not Casey";
						}
					}
					else {
						election_result[2]="Not NiRiada";
					}
				}		
				else {
					election_result[1]="Not Gallagher";
				}
			}
			else{
				election_result[0]="Not Higgins";
			}

		}//End of for loop

		System.out.println("The Number of arrays that are in the order of prediction are [" + count + "]"); //Print the final count of arrays that meet criteria
			System.out.println(" "); //Blank line

		double percentage_Chance = (count/num_Itterations)*100.0; // Calculate the percentage of arrays compared to itteratioins to give a % value
			System.out.print("The likelyhood of the election to be in the order predicted is [" + percentage_Chance + "%]"); //Print the result

	}//End of main method
}//End of Class