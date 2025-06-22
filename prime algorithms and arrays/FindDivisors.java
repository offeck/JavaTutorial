import java.util.Scanner;

// This class implements an algorithm for finding and printing all divisors
// of a given positive integer greater than 1.
// The loop iterates over all possibilities in ascending order
public class FindDivisors {
	public static void main(String[] args){
		Scanner myScanner = new Scanner(System.in);
		
		int n = myScanner.nextInt(); 
		boolean isPrime = true;
		int p = 2;
		while ( p < n && isPrime ) {
			if(n%p == 0)
				isPrime = false;
			else
				p = p + 1;
		}
		if (isPrime)
			System.out.println(n + " is prime"); 
		else
			System.out.println(p + ", " + n/p);
		myScanner.close();
	}
}
