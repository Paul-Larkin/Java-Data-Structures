package cs211algorithms;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/*
 * @author: Paul Larkin
 * @date: 14/02/2019
 * @description: The challenge here was generate
 * a base 58 encoding number to be used a a 
 * public key for vertcoin cryptocurrency
 *
 */

//Professor Phil Maguires Code
	public class Lab0_Vertcoin_Number_Generator{
		
		private static final BigInteger BigInteger = null;

		private static String sha256(String input) throws NoSuchAlgorithmException {
			
			byte[] in = hexStringToByteArray(input);
			MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
			
			byte[] result = mDigest.digest(in);
			StringBuilder sb = new StringBuilder();

			for (byte b : result) {
				sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		}
		
		private static byte[] hexStringToByteArray(String s) {
			
			int len = s.length();
			byte[] data = new byte[len / 2];
			
			for (int i = 0; i < len; i += 2) {
				data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
					+ Character.digit(s.charAt(i+1), 16));
			}
			return data;
		}
		
//My own code		
//....................................................................................................................
		public static void main(String[] args) {
			
			StringBuilder randHex = new StringBuilder("");//String to hold the hex I generate
			String the80String;//To hold the value of the concat 80 string
			String hashed; //To hold the hashed 80
			String doubleHashed = null; //To hold the doublehashed 80
			String doubleHashedSubstring; //For holding the substring 8 digits
			
			//String array containing all hex values.........
			String[] hex = {"0", "1", "2", "3",
							"4", "5", "6", "7",
							"8", "9", "A", "B", 
							"C", "D", "E", "F"};
			
			//Loop to build the empty ranHex string into a 64 digit random hex string........
			for (int i=1; i<=64; i++) {
				int rand = (int) (Math.random()*16);
				int rand2 = (int) (Math.random()*(randHex.length()));
				randHex.insert(rand2, hex[rand]);
			}
			
			//Print out the 64 digit hexNumber.......
			System.out.println("The 64-digit Hex String: "+randHex);
			System.out.print("\n");
			
			//Concatenate 80 and randHex to 80String.........
			the80String ="80"+ randHex;	
			System.out.println("The 80 String: " + the80String);
			//System.out.println("Length of 80String: "+the80String.length());
			System.out.print("\n");
				
			try{
				//Hashing the 80String..........
				hashed  = sha256(the80String);	
				System.out.println("The sha256 80 String: "+hashed);
				
				//Doublehashing the 80String..........
				doubleHashed = sha256(hashed);
				System.out.println("The double sha256 80 String: "+doubleHashed);
				
			}catch (NoSuchAlgorithmException e){
				System.out.println(e.getMessage());
			}	
			
			//Creating substring of last 8 digits of Double Hashed 80........
			doubleHashedSubstring = doubleHashed.substring(0,8);
			doubleHashedSubstring = doubleHashedSubstring.toUpperCase();
			System.out.print("\n");
			
			//Concatenate the 80String with the substring........
			the80String = the80String + doubleHashedSubstring;
			System.out.println("The 80 String with added 8-digits added: "+the80String+"\n");	
			
			//This allows me to convert my 80String to decimal format
			byte[] bytearraynumber  = hexStringToByteArray(the80String);
			BigInteger bignumber = new BigInteger(1, bytearraynumber);	
			System.out.println("The 80String in decimal: "+bignumber+"\n");	
			
			BigInteger fifty8 = new BigInteger("58"); //A number to use for mod and div
			BigInteger remainder; //A number to use to hold the value of the remainder

			//ArrayList to hold all the remainder values which are in big integer format
			ArrayList<BigInteger> remainderList = new ArrayList<BigInteger>();
			
			while(bignumber.bitLength()>0) {	 //While the decimal formatted 80 string is > 0
				remainder = bignumber.mod(fifty8);	//the big integer remainder will be the decimal % 58
				remainderList.add(remainder); //Add this remainder to the remainderlisd
				
				bignumber = bignumber.divide(fifty8);//The decimal then is divided by 58
				System.out.println(bignumber);	//Print out big number to show current state
				System.out.println(remainderList + "<-Remainder");	//Print out the reminder added to the list
			}
			
			//An array of the base 58 alphabet
			String[] base58Array = new String[58];//String array size 58
			for(int i=0;i<58;i++) { //Loop through
				String base58Alphabet = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz"; //String of all base58 values
				base58Array[i]=Character.toString(base58Alphabet.charAt(i));//Fill the array with strings of each individeal char
			}
			
			StringBuilder base58key = new StringBuilder();//To hold my final key result
			for(int i = remainderList.size()-1; i>=0; i--) { //loop from end of remainder list to start
				int currentRemainder = remainderList.get(i).intValue(); //int to hold the current remainder(also is the index) to be changed, starting from last remainder
				base58key.append(base58Array[currentRemainder]); //concat the string to contain the remainder values
			}
			
			System.out.print("\n");
			System.out.println("The 80 String with added 8-digits added: "+the80String);	//My original concat 80 string before made decimal

			System.out.print("\n");
			System.out.print("This is my final answer: "+base58key);	//My final private key
		}
	}