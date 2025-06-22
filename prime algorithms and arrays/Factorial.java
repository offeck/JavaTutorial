import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();
		int fact = 1;
		int i = 1;
		//accumulate the product of numbers 1 to n into fact
		while ( i <= n ) {
			fact = fact * i;
			i = i + 1;
		}
		System.out.println("n!  =" + fact);
	}

}
