
public class RomanToNumber {
	
	public static void main(String[] args) {
        System.out.println("Input: MX, Output: "+romanToDecimal("MX"));//1010
        System.out.println("Input: IV, Output: "+romanToDecimal("IV"));//4
        System.out.println("Input: CMLIV, Output: "+romanToDecimal("CMLIV"));//954
        System.out.println("Input: XIV, Output: "+romanToDecimal("XIV"));//14
    }

	// Assumes r is a char that represents a legal roman numeral
	// Returns the numerical value of r as a roman numeral
	public static int romanToDecimal(char r) {
		int num = -1;
		if(r == 'I')
			num = 1;
		if(r == 'V')
			num = 5;
		if(r == 'X')
			num = 10;
		if(r == 'L')
			num = 50;
		if(r == 'C')
			num = 100;
		if(r == 'D')
			num = 500;
		if(r == 'M')
			num = 1000;
		return num;
	}

	// Assumes s is not null and a string that represents a legal roman numeral
	// Returns the numerical value of s as a roman numeral
	public static int romanToDecimal(String s) {
		int res = 0;
		for(int i = 0; i < s.length(); i = i + 1){
			int n1 = romanToDecimal(s.charAt(i));
			if(i + 1 < s.length()){
				int n2 = romanToDecimal(s.charAt(i+1));
				if (n1 >= n2){
					res = res + n1;
				}
				else {
					res = res + (-n1);
				}
			}
			else {res = res + n1;}
		}
		return res;
	}

}
