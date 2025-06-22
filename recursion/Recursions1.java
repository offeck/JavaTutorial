
public class Recursions1 {
	
	//---------------factorial--------------------
	// Assume n >= 0
	// Returns n!
	public static int factorialIterative(int n) {
		int output = 1;
		for (int i = 2; i <= n; i = i+1)
			output = output * i;
	 	return output;
	}
	public static int factorial(int n) {
		int output;
		if (n==0)
			output = 1;
		else
			output = n * factorial(n-1);
		return output;
	}
	
	
	//---------------perfect matching--------------------
	// Assume n > 0 is even
	// Returns the number of ways to divide n members into pairs
	public static int perfectMatching(int n) {
		int output;
		if (n==0)
			output = 1;
		else
			output = (n-1)*perfectMatching(n-2);
		return output;
	}
	public static int perfectMatchingIterative(int n) {
		int output = 1;
		for (int i = 3; i < n; i = i+2)
			output = output * i;
	 	return output;
	}
	
	
	//---------------fibonacci--------------------
	// Assume n >= 0
	// Returns the n'th number in the Fibonacci series
	public static int fibonacciIterative(int n){
		int output = 0;
		if (n == 0 | n == 1)
			output = 1;
		else{
			int f0 = 1,f1 = 1;
			for (int i = 2; i <= n; i = i+1){
				output = f0 + f1;
				f0 = f1;
				f1 = output;
			}
		}
		return output;
	}
	public static int fibonacci(int n){
		int output;
		if (n == 0 | n == 1) 
			output = 1;
		else 
			output = fibonacci(n-1) + fibonacci(n-2);	
		return output;
	}
	
	
	//---------------spiderman--------------------
	// same as fibonacci


	public static void main(String[] args){
		int n = 30;
		System.out.println(fibonacci(n));
	}
}
