
public class Ceasar {

	public static void main(String[] args) {
		String str = "BEN GURION UNIVERSITY";	
		int key = 3;
		String encrypted = encrypt(str, key);
		System.out.println(encrypted);// "EHQ JXULRQ XQLYHUVLWB" 
		String decrypted = decrypt(encrypted, key);
		System.out.println(decrypted);// "BEN GURION UNIVERSITY"

	}

	// Assumes str is not null and contains English letters, and that key is not negative
	// Returns the encrypted string according to the key
	public static String encrypt(String str, int key) {
		String encrypted = "";
		final int ALPHABET_SIZE = 26;
		for(int i = 0; i < str.length(); i = i + 1) {
			int c = str.charAt(i);
			if(c <= 'Z' && c >= 'A') {
				c = c - 'A';
				c = (c + key) % ALPHABET_SIZE;
				c = c + 'A';
			}
			else if(c <= 'z' && c >= 'a') {
				c = c - 'a';
				c = (c + key) % ALPHABET_SIZE;
				c = c + 'a';
			}
			encrypted = encrypted + (char)c;
		}
		return encrypted;
	}

	// Try at home!!
	// Assumes str is not null and contains English letters, and that key is not negative
	// Returns the decrypted string according to the key
	public static String decrypt(String encrypted, int key) {
		String decrypted = "";
		final int ALPHABET_SIZE = 26;
		for(int i = 0; i < encrypted.length(); i = i + 1) {
			int c = encrypted.charAt(i);
			if(c <= 'Z' && c >= 'A') {
				c = c - 'A';
				c = (c - key) % ALPHABET_SIZE;
				if (c < 0) {
			        c = ALPHABET_SIZE + c;
			      }
				c = c + 'A';
			}
			else if(c <= 'z' && c >= 'a') {
				c = c - 'a';
				c = (c - key) % ALPHABET_SIZE;
				if (c < 0) {
			        c = ALPHABET_SIZE + c;
			      }
				c = c + 'a';
			}
			decrypted = decrypted + (char)c;
		}
		return decrypted;
	} 
	
}
