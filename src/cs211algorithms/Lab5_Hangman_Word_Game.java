package cs211algorithms;

/*
 * @ authors: 15731659 - Paul Larkin
 * @ authors: 18251916 - Sean Tracey 
 */


import java.util.*;

public class Lab5_Hangman_Word_Game {

    //Class variables
    private static String word;
    private static String underscores;
    private static String guess;
    private static int remainingGuesses = 8;
    private static ArrayList<String> previousGuesses = new ArrayList<>();

    public static void main(String[] args){

        //Read corresponding File
        FileIO reader = new FileIO();
        //Scanner
        Scanner scan = new Scanner(System.in);

        //New array containing all the dictionary wordsX
        String[] inputs = reader.load("X:/CS265/EclipseWorkspace/CS211/src/cs211/dictionary.txt");    //Reading the File as a String array

        //Display to user
        System.out.println("**********************************");
        System.out.println("******* LETS PLAY HANGMAN ********");
        System.out.println("**********************************\n");

        //Scanner and prompt
        Scanner sc = new Scanner (System.in);
        System.out.println("Please Select a Word Length");

        //Allow user to select word length
        int wordLength = sc.nextInt();
        System.out.println("You have selected: " + wordLength);

        //Generate a random word
        int random = (int )(Math.random() * inputs.length + 1);
        word = inputs[random];

        //While the word is not of the chosen length, keep
        //generating random numbers till be find a suitable word
        while(word.length()!=wordLength){
            random = (int )(Math.random() * inputs.length + 1);
            word = inputs[random];
        }

        //Print the word
        //System.out.println(word);

        //The underscores string is filled
        underscores = new String(new char[word.length()]).replace("\0", "_");

        //While still hidden letters and attempts left
       while (underscores.contains("_") && remainingGuesses!=0) {
            printString(underscores);
            guess = sc.next();
            makeGuess(guess);
        }
    }

    /*
     * Method to take in a guess from the user and
     * check it against the word that is to be guessed.
     * A new String will be created of equal length to
     * the word.
     * If the word contains the guess at the current index
     * it will be added to the new String, else if the
     * string of '_' contains a '_' at the current
     * index a '_' will be added to the new string.
     * Finally if not a '_' or the letter guessed it must be a
     * previously guessed letter so we add the letter from the
     * word to the new string.
     */

    public static void makeGuess(String guess) {
        //New string
        String moddedUnderscore = "";
        //Loop through word to guess
        for (int i = 0; i < word.length(); i++) {
            //If the letter at i is the guessed letter
            if (word.charAt(i) == guess.charAt(0)) {
                moddedUnderscore += guess.charAt(0);
            }
            //If its a _ at i
            else if (underscores.charAt(i) == '_') {
                moddedUnderscore += "_";
            }
            else {
                //Assumes letter already been guessed
                moddedUnderscore += word.charAt(i);
            }
        }
        //If the underscores String has been un-affected by the last guess
        if (underscores.equals(moddedUnderscore)) {
            //Increment the guesses
            remainingGuesses--;
            //Add guess to Arraylist
            previousGuesses.add(guess);
            //Add a new series of images
            addImage();
        }else {
            underscores = moddedUnderscore;
        }
        //If every letter has been guessed
        if (underscores.equals(word)) {
            System.out.println("Correct! You win! The word was " + word);
        }
    }

    public static void addImage() {
        if (remainingGuesses == 7) {
            System.out.println("               The word doesn't contain the letter "+guess);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("                _______________________");
            System.out.println("               |                       |");
            System.out.println("               |_______________________|");
            System.out.println("               Previous Guesses: "+ previousGuesses);
            System.out.println();
        }
        if (remainingGuesses == 6) {
            System.out.println("               The word doesn't contain the letter "+guess);
            System.out.println();
            System.out.println("                 ||");
            System.out.println("                 ||");
            System.out.println("                 ||");
            System.out.println("                 ||");
            System.out.println("                 ||");
            System.out.println("                 ||");
            System.out.println("                 ||");
            System.out.println("               __||____________________");
            System.out.println("               |                       |");
            System.out.println("               |_______________________|");
            System.out.println("               Previous Guesses: "+ previousGuesses);
            System.out.println();
        }
        if (remainingGuesses == 5) {
            System.out.println("               The word doesn't contain the letter "+guess);
            System.out.println("                  ____________");
            System.out.println("                 ||");
            System.out.println("                 ||");
            System.out.println("                 ||");
            System.out.println("                 ||");
            System.out.println("                 ||");
            System.out.println("                 ||");
            System.out.println("                 ||");
            System.out.println("                _||____________________");
            System.out.println("               |                       |");
            System.out.println("               |_______________________|");
            System.out.println("               Previous Guesses: "+ previousGuesses);
            System.out.println();
        }
        if (remainingGuesses == 4) {
            System.out.println("               The word doesn't contain the letter "+guess);
            System.out.println("                  ____________");
            System.out.println("                 ||          _|_");
            System.out.println("                 ||         /   \\");
            System.out.println("                 ||        ( o o )");
            System.out.println("                 ||         \\_x_/");
            System.out.println("                 ||");
            System.out.println("                 ||");
            System.out.println("                 ||");
            System.out.println("                _||____________________");
            System.out.println("               |                       |");
            System.out.println("               |_______________________|");
            System.out.println("               Previous Guesses: "+ previousGuesses);
            System.out.println();
        }
        if (remainingGuesses == 3) {
            System.out.println("               The word doesn't contain the letter "+guess);
            System.out.println("                  ____________");
            System.out.println("                 ||          _|_");
            System.out.println("                 ||         /   \\");
            System.out.println("                 ||        ( o o )");
            System.out.println("                 ||         \\_x_/");
            System.out.println("                 ||           |");
            System.out.println("                 ||           |");
            System.out.println("                 ||");
            System.out.println("                 ||");
            System.out.println("                _||____________________");
            System.out.println("               |                       |");
            System.out.println("               |_______________________|");
            System.out.println("               Previous Guesses: "+ previousGuesses);
            System.out.println();
        }
        if (remainingGuesses == 2) {
            System.out.println("             The word doesn't contain the letter "+guess);
            System.out.println("                  ____________");
            System.out.println("                 ||          _|_ ");
            System.out.println("                 ||         /   \\");
            System.out.println("                 ||        ( o o )");
            System.out.println("                 ||         \\_x_/");
            System.out.println("                 ||           |");
            System.out.println("                 ||           |");
            System.out.println("                 ||          / \\ ");
            System.out.println("                _||_________/___\\______");
            System.out.println("               |                       |");
            System.out.println("               |_______________________|");
            System.out.println("               Previous Guesses: "+ previousGuesses);
            System.out.println();
        }
        if (remainingGuesses == 1) {
            System.out.println("               The word doesn't contain the letter "+guess);
            System.out.println("                  *************LAST ATTEMPT*************");
            System.out.println("                  ____________");
            System.out.println("                 ||          _|_     -------");
            System.out.println("                 ||         /   \\  (  Help! )");
            System.out.println("                 ||        ( 0 0 ) < -------");
            System.out.println("                 ||         \\_@_/");
            System.out.println("                 ||        ~~~|~~~");
            System.out.println("                 ||           |");
            System.out.println("                 ||          / \\ ");
            System.out.println("                _||_________/___\\______");
            System.out.println("               |                       |");
            System.out.println("               |_______________________|");
            System.out.println("               Previous Guesses: "+ previousGuesses);
            System.out.println();
        }
        if (remainingGuesses == 0) {
            System.out.println("     ____________________________________________");
            System.out.println("     |                                           |");
            System.out.println("     |               GAME OVER!                  |");
            System.out.println("     |             ____________                  |");
            System.out.println("     |            ||           |                 |");
            System.out.println("     |            ||          _|_                |");
            System.out.println("     |            ||         /   \\               |");
            System.out.println("     |            ||        ( x x )              |");
            System.out.println("     |            ||         \\_-_/               |");
            System.out.println("     |            ||          /|\\                |");
            System.out.println("     |            ||         | | |               |");
            System.out.println("     |           _||________  / \\  ______        |");
            System.out.println("     |          |           \\ | | /      |       |");
            System.out.println("     |          |________________________|       |");
            System.out.println("     |___________________________________________|");
            System.out.println("                 The word was " + word);
        }
    }
    /*
     * Method used to print out the underscore string
     * with spaces in between characters "_ _ _ _ _"
     */
    private static void printString(String toPrint){
        for(int i=0; i<toPrint.length(); i++) {
            System.out.print(toPrint.charAt(i) + " ");
        }
        System.out.println(" ");
        System.out.println("Guess a letter");
    }
}
