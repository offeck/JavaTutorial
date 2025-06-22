import java.util.Scanner;

public class Digits {
	public static void main(String[] args){
		Scanner myScanner = new Scanner(System.in); 

  		int x = myScanner.nextInt();
		int counter = 1;
		while (x >= 10) {
		    counter = counter + 1;
		    x = x/10;
		}
 		System.out.println(counter);
 		myScanner.close();
	}
}
