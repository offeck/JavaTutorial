
public class Recursions2 {

	//---------------gcd--------------------
	// Assume m,n>0
	// Returns gcd(m,n)
	public static int gcd(int m, int n){
	    int output;
        if (m%n==0) 
            output = n;
        else
            output = gcd(n,m%n);
	    return output;
	}
	
	//---------------reverse--------------------
	// Assume s != null
	// Returns s in reversed order
	public static String reverse(String s){
	    String output;
	    if (s.length() == 0)
	        output = s;
	    else
	        output = reverse(s.substring(1))+s.charAt(0);
	    return output;
	}
	// Assume s != null
	// Prints s in reversed order
	public static void printReverse(String s){
		if (s.length() == 0)
			System.out.println(s);
		else {
			System.out.print(s.charAt(s.length()-1));
			printReverse(s.substring(0, s.length()-1));
		}
		return;
	}
	// Assume s != null
	// Prints s in reversed order
	public static void printReverseAcc(String s){
			printReverseAcc(s, "");
	}
	// Assume s != null
	// Prints s in reversed order concatenated with acc
	public static void printReverseAcc(String s, String acc){
		if (s.length()==0)
			System.out.println(acc);
		else {
			printReverseAcc(s.substring(1), s.charAt(0) + acc);
		}
		return;
	}
	//---------------subsets--------------------
	// Assumes s!=null
	// Prints all subsets of s
	public static void printAllSubsets(String s){

		printAllSubsets(s, "");
	}
	// Assumes s!=null
	// Prints all subsets of s, each subset concatenated with acc
	public static void printAllSubsets(String s, String acc){
		if(s.length() == 0){
			System.out.println(acc);
		}
		else {
			printAllSubsets(s.substring(1), acc + s.charAt(0)); // with first char
			printAllSubsets(s.substring(1), acc); // without first char
		}
	}
	//---------------choice--------------------
	// Assume k>=0, n>=0
	// Returns the number of ways to choose k elements from n
	public static int choose(int n, int k) {
		int output;
	 	if (n < k)
			output = 0;
		else if (k == 0) 	
			output = 1;
		else 
			output = choose(n-1,k) + choose(n-1,k-1);
		return output;
	}




}
