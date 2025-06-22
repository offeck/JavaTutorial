import java.util.Scanner;

// This class implements Euclid's algorithm for finding the greatest common divisor of two positive integers.
public class GCD {
	public static void main(String[] args){
		
		Scanner myScanner = new Scanner(System.in);

	     int m = myScanner.nextInt();
	     int n = myScanner.nextInt();
	     int r = m%n;
	     while (r != 0) {
	        m = n;
	        n = r; 
	        r = m%n;
	     }
	     System.out.println(n);
	     myScanner.close();
	}
}
