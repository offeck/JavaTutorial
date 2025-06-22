
public class PhoneNumber {
	private String phoneNumber;
	
	public PhoneNumber(String phoneNumber) {
		if (!isLegalNumber(phoneNumber))
			throw new IllegalArgumentException("");
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String toString() {
		return phoneNumber;
	}	
	
	public boolean equals(Object other){
		boolean isEqual = false;
		if(other instanceof PhoneNumber){
			isEqual = phoneNumber.equals(((PhoneNumber) other).getPhoneNumber());
		}
		return isEqual;
	}
	
	private boolean isLegalNumber(String phoneNumber) {
		boolean isLegal = (phoneNumber != null) &&
				       ((phoneNumber.length() == 9) | (phoneNumber.length() == 10)) &&
				       (phoneNumber.charAt(0) =='0');
		for (int i = 0; i < phoneNumber.length() & isLegal; i = i + 1) {
			char c = phoneNumber.charAt(i);
			isLegal = ('0' <= c) & (c <= '9');
	  	}
		return isLegal;	
	}
}