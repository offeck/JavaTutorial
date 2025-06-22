public class OverLoading {
	public static void overLoaded(int n, double d, int m) {
      		System.out.println("int, double, int"); 
      	} 

	public static void overLoaded(double d, int n, int m) {
      		System.out.println("double, int, int"); 
 	}
 
	public static void overLoaded(int n, double d) {
		System.out.println("int, double"); 
	} 
	
	public static void main(String[] args) { 
		int myInt = 0; 
		double myDouble = 0.0; 
		overLoaded(myInt, myDouble, myInt); // int, double, int
		overLoaded(myDouble, myInt, myInt); // double, int, int
		overLoaded(myInt, myInt); // int, double
	}
} 
