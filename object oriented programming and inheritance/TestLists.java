import java.util.Arrays;

public class TestLists {
	public static void main(String[] args){
		
		List<Integer> myIntList = new DynamicArray<Integer>();
		myIntList.add(1); 
		myIntList.add(2); 
		myIntList.add(3);
		ListOperations.printVertical(myIntList); 
		ListOperations.reverse(myIntList);
		ListOperations.printVertical(myIntList);

		List<String> myStrList = new DynamicArray<String>();
		myStrList.add("man"); 
		myStrList.add("bites");
		myStrList.add("dog");
		ListOperations.printVertical(myStrList); 
		ListOperations.reverse(myStrList);
		ListOperations.printVertical(myStrList);
		
		List<Integer> primes = primesDynamicArray(20);
		ListOperations.printVertical(primes);
		
		System.out.println("primesArray:");
		System.out.println(Arrays.toString(primesArray(10)));
	}
	public static int[] primesArray(int n){
	    int[] primes = new int[n]; // 
	    int numberOfPrimes = 0; // <--- index of next prime
	    for (int number = 2; number <= n; number = number + 1){
	    	boolean isPrime = true; 
	    	for (int i = 0; i < numberOfPrimes &&
	        primes[i]*primes[i] <= number & isPrime; i=i+1) 
	    	    if (number % primes[i] == 0) 
	    		isPrime = false;
	    	if(isPrime) {
	    		primes[numberOfPrimes] = number;
	    		numberOfPrimes = numberOfPrimes + 1;
	    	}
	    }
	    return primes;
	}
	public static List<Integer> primesDynamicArray(int n){
		List<Integer> primes = new DynamicArray<Integer>();
		for (int number = 2; number <= n; number = number+1){
			boolean isPrime = true; 

			for (int i = 0; i < primes.size() && 
					(Integer)primes.get(i)*(Integer)primes.get(i) 
					<= number & isPrime; 
					i = i + 1 ) 
				if (number%(Integer)primes.get(i) == 0)
					isPrime = false;

			if(isPrime) {
				primes.add(new Integer(number));
			}
		}
		return primes;
	}
}