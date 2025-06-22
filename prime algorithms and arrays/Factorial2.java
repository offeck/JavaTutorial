import java.util.Scanner;
public class Factorial2 {
  
	public static void main(String[] args) {
	Scanner myScanner = new Scanner(System.in);
	int n = myScanner.nextInt();
	int fact = 1;
	//accumulate the product of numbers 1 to n into fact
	for (int i = 1; i <= n; i = i + 1){
		fact = fact * i;
	}
	System.out.println("n!  =" + fact);
  }
}
