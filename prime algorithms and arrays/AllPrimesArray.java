import java.util.Scanner;

public class AllPrimesArray {
	// print all prime numbers <= n using an array
	public static void main(String[] args){
		Scanner myScanner = new Scanner(System.in);	
		
		int n = myScanner.nextInt();
		int[] primes = new int[n]; 	//array of primes
		int numberOfPrimes = 0; 	//the number of primes we found so far. In addition: the index of next free cell in 'primes' into which we will add the next prime we find
		
		// for all numbers (potential primes) from 2 till n:
		for (int number = 2;number <= n; number = number + 1) {
			boolean isPrime = true;
			
			// check if number is prime
			for(int primesIndex = 0;primesIndex < numberOfPrimes && primes[primesIndex]*primes[primesIndex]  <= number && isPrime; primesIndex = primesIndex + 1){
				if (number%primes[primesIndex] == 0) {
					isPrime = false; 
				}
			}
			
			// if number is prime add it to 'primes' array and update the number of primes found so far:
			if(isPrime) {
				primes[numberOfPrimes] = number;
				numberOfPrimes = numberOfPrimes + 1;
			}
		}
		// print all primes:
		for(int i = 0;i < numberOfPrimes; i = i + 1)
			System.out.println(primes[i]);
		
		myScanner.close();
	} // main
}
