package algorithms;

/*
 * @author: Paul Larkin
 * @date: 05/05/2019
 * @name: FizzBuzz
 */

public class FizzBuzz {

	public static void main(String[] args) {

		for (int i=1; i<=100; i++) {
			if (i%5 == 0 && i%3 == 0) {
				System.out.println(i+" FizzBuzz");
			}
			else if(i%5 == 0) {
				System.out.println(i+" Fizz");
			}
			else if(i%3 == 0) {
				System.out.println(i+" Buzz");
			}
			else {
				System.out.println(i);
			}
		}
	}
}
