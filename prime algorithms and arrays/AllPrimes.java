import java.util.Scanner;

// This class implements an algorithm for finding and printing to the screen all prime numbers
// smaller than or equal to a given positive integer greater than 1.
public class AllPrimes {
	public static void main(String[] args){
		Scanner myScanner = new Scanner(System.in);	
		
		int n = myScanner.nextInt(); // assume n >= 2
		
		// the exterior while loop iterates over all candidate numbers smaller or equal to the input number
		int number = 2;	
		while (number <= n) {
			
			// The inner while loop iterates over all possible divisors smaller than or equal to 
			// the root of the currents number
			boolean isPrime = true;
			int divisor = 2;
			while (divisor * divisor <= number && isPrime) {
				if ( number % divisor == 0) {
					isPrime = false; 
				}
				divisor = divisor + 1;
			}
			if(isPrime) {
				System.out.println(number);
			}
			number = number + 1;
		}
		
		myScanner.close();
	}
}
