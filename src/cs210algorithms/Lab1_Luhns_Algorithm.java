package cs210algorithms;

/*
 * @author: Paul_Larkin
 * @date: 29/04/2019
 * @description: Preform Luhn's Algorithm 
 * to check valid credit card numbers
 */

import java.util.Scanner;

public class Lab1_Luhns_Algorithm {

    public static void main (String[]args){

        Scanner userInput = new Scanner (System.in);
        System.out.println("Enter a card number to check validity");
        String cardNumber = userInput.nextLine();
        userInput.close();

        if(checkValid(cardNumber)) {
            System.out.println("This number is VALID");
        }
        else {
            System.out.println("This number is INVALID");
        }
    }

    public static boolean checkValid(String number){

        String cardNumber = number;
        String reverse = "";

        for(int i = cardNumber.length()-1; i>=0; i--) {
            reverse += cardNumber.charAt(i); //Reverse the cardNumber
        }
        int sum = 0;

        for(int j=0; j<=reverse.length()-1; j++){

            int current = Character.getNumericValue(reverse.charAt(j)); //Get the numeric value

            if(j%2!=0) {
                current *= 2; //Double every second digit
            }
            if(current>9) {
                current -=9; //If greater than nine then reduce by nine
            }
            sum += current; //Calculate the sum
        }
        if(sum%10==0) {
            return true; //Valid
        }
        else {
            return false; //Invalid
        }
    }
}