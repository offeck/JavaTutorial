
import java.util.Scanner;

public class IsSumEven2 {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        boolean isEven = true;
        int x = myScanner.nextInt();

        // flip the isEven flag whenever an odd number is encountered to track the parity of the sum
        while (x > 0){
            if (x%2 == 1)
                isEven = ! isEven;
            x = myScanner.nextInt();
        }

        if (isEven == true)
            System.out.println("Is even");
        else
            System.out.println("Is odd");

    }
}
