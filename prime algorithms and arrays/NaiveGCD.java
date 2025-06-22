import java.util.Scanner;

// This class implements a simple algorithm for finding the greatest common divisor of two positive integers,
// by simply checking all possibilities, in descending order.
public class NaiveGCD {
	public static void main(String[] args){
		Scanner myScanner = new Scanner(System.in);

		int m = myScanner.nextInt();
		int n = myScanner.nextInt();
		int i = m;
		while ((m%i != 0)  ||  (n%i != 0)){
	  // while (!((m%i == 0)  &  (n%i == 0))){

			i = i-1; 
		}       
		System.out.println(i);
		myScanner.close();
   }
}
