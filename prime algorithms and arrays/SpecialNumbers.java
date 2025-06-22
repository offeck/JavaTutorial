
public class SpecialNumbers {

	 public static void main(String[] args) {
		 
		 //go over all possible numbers 
		 for (int i=32; i<100; i=i+1){
			 
			 //for each number, gets its left and right digits 
			 //and check their sum
			 int leftPart = (i*i)/100;		
		 	 int rightPart = (i*i)%100;            
			 if (leftPart + rightPart == i) {             
				 System.out.println(i);
	     }
	   }
	 }	 
}
