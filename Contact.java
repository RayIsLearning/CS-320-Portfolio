package contactService;

public class Contact {

	private String id;		//variables		
	private String firName;		
	private String lasName;		
	private String pNumber;	
	private String addr;		
	
	public Contact(String id, String fName, String lName, String phone, String addy) { //conditions for contact variables
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(fName == null || fName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		if(lName == null || lName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		if(phone == null || phone.length() > 10 || phone.length() < 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		if(addy == null || addy.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		this.id = id;
		this.firName = fName;
		this.lasName = lName;
		this.pNumber = phone;
		this.addr = addy;
	}
	public String getId() {//getter methods
		return id;
	}
	public String getName() {
		return firName + " " + lasName;
	}
	public String getPhone() {
		return pNumber;
	}
	public String getAddr() {
		return addr;
	}
	
	public void setFirstName(String fName) {
		if(fName == null || fName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		firName = fName;
	}
	public void setLastName (String lName){
		if(lName == null || lName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		lasName = lName;
	}
	public void setPhoneNumber (String phone) {
		if(phone == null || phone.length() > 10 || phone.length() < 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		pNumber = phone;
	}
	public void setAddress(String addy) {
		if(addy == null || addy.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		addr = addy;
	}
}