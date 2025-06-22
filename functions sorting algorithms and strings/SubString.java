
public class SubString {

	public static void main(String[] args) {
		System.out.println("Input: {abcbsbsbb, b}, Output: " + subStrC("abcbsbsbb",'b')); //3
		System.out.println("Input: {abcbsbsbb, b, 3}, Output: " + subStrMaxC("abcbsbsbb",'b',3)); //10
	}
	
	// Assume s is not null
	// Returns the number of substrings in s that start, end and contain exactly once char c
	public static int subStrC(String s, char c) {
		int counter = 0;
		for (int i = 0; i < s.length(); i = i+1) {
			if (s.charAt(i) == c) {
				counter = counter + 1;
			}
		}
		int ans = 0;
		if (counter >= 3) {
			ans = counter - 2;
		}
		return ans;
	}
	
	// Assume s is not null
	// Returns the number of substrings in s that start, end and contain char c exactly k times
	public static int subStrCK(String s, char c, int k) {
		int counter = 0;
		for (int i = 0; i < s.length(); i = i+1) {
			if (s.charAt(i) == c) {
				counter = counter + 1;
			}
		}
		int ans = 0;
		if (counter >= k+2) {
			ans = counter - (k+1);
		}
		return ans;
	}
	
	// Assume s is not null
	// Returns the number of substrings in s that start, end and contain char c maximum k times
	public static int subStrMaxC(String s, char c, int max) {
		int sum = 0;
		for(int k = 0; k <= max; k = k+1) {
			sum = sum + subStrCK(s, c, k);
		}
		return sum;
	}
}
