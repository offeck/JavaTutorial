import java.util.Scanner;

public class IsSumEven {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int sum = 0;
		int x = myScanner.nextInt();
		//accumulate positive input numbers into sum
		// the loop ends when the user types a non-positive number 	
		while (x > 0){
			sum = sum + x;
			x = myScanner.nextInt();
		}
		//check sum parity
		if(sum%2 == 0)
		      System.out.println("Is even");
		else
		      System.out.println("Is odd");
	}
}
