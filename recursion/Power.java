
public class Power {
	

	public static void main(String[] args) {
		System.out.println(exp(2, 3));//8
		System.out.println(exp(4, 3));//64
		System.out.println(exp(5, 2));//25
		System.out.println();
	}

	// Assume a, b >= 0
	// Returns the value of a to the power of b
	public static int exp(int a, int b) {
		int result; 
		if(b == 0)
			result = 1;
		else
			result = a * exp(a, b-1);
		return result; 
	}

}
