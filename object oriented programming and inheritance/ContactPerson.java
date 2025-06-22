public class ContactPerson extends Record<PhoneNumber>{
	
	private String contactType;
	
	public ContactPerson(String name, PhoneNumber phoneNumber, String contactType){
		super(name, phoneNumber);
		this.contactType = contactType;
	}
	
	public String getContactType() {
		return contactType;
	}
	
	public String toString() {
		return "["+getKey()+" "+getValue()+" "+contactType+"]";
	}
}