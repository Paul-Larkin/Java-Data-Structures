package programmingexercises;

import java.util.*;

/*
 * @author: Paul Larkin
 * @date: 06/05/2019
 * @name: Reverse_String
 * 
 * @description: From java exercises book.
 * Write a method that accepts a String
 * and reverses it. It should print the reversed String
 * to the screen (one word per line).
 */

 public class Reverse_String {

    public static void main (String[] args){

      System.out.println("Please Enter a Sentence");
      Scanner userInput = new Scanner (System.in);
      String input = userInput.nextLine();
      userInput.close();
      reverseAndPrint(input);
    }

    private static void reverseAndPrint (String input){

      StringBuilder reversed = new StringBuilder();

      for(int i = input.length()-1; i >= 0; i--){
        reversed.append(input.charAt(i));
      }

      for(int i = 0; i < reversed.length(); i++){
        if(reversed.charAt(i) == ' '){
          System.out.println();
        }
        else{
          System.out.print(reversed.charAt(i));
        }
      }
    }
 }