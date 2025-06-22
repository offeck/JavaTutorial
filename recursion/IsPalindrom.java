
public class IsPalindrom {
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(""));//true
		System.out.println(isPalindrome("aa"));//true
		System.out.println(isPalindrome("not a palindrom"));//false
		System.out.println(isPalindrome("RacecaR"));//true

	}

	// Assumes s is not null
	// Returns true if s is a palindrome and false if s isn’t a palindrome
	public static boolean isPalindrome(String s) {
		boolean ans; 
		if(s.length() == 0 || s.length() == 1)
			ans = true;
		else if (s.charAt(0) != s.charAt(s.length() - 1))
			ans = false;
		else
			ans = isPalindrome(s.substring(1, s.length() - 1));
		return ans; 
	}
}
