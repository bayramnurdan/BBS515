
public class Phone {
	private String countryCode;
	private String phoneCode;
	private String number;
	private String phoneType;
	
	// constructor  takes all parameters
	public Phone(String countryCode, String phoneCode,String number, String phoneType) {  
		this.countryCode = countryCode;
		this.phoneCode = phoneCode;
		this.number = number;           //must contain 7 digits
		this.phoneType = phoneType.substring(0, 1).toUpperCase() + phoneType.substring(1).toLowerCase();   //format type of phone
	}
	
	
	// constructor takes only phone code,  the number and type
	public Phone(String phoneCode, String number, String phoneType) {  
		this.countryCode = "+90";  //if country code is not given it is assigned as +90
		this.phoneCode = phoneCode;
		this.number  = number;
		this.phoneType  = phoneType.substring(0, 1).toUpperCase() + phoneType.substring(1).toLowerCase();   //format type of phone
	}
	
	
	// set methods 
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public void setphoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
				
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	
	// get methods
	
	public String getCountryCode() {
		return this.countryCode;
	}
	
	public String getPhoneCode() {
		return this.phoneCode;
	}
	public String getNumber() {
		return this.number;
	}
	
	public String getWholeNumber() {
		return this.countryCode + this.phoneCode + this.number;
	}
	
	//display method
	
	public String toString() {   
		
		return "Phone number is: " + this.countryCode + " " + this.phoneCode  + " "  + this.number + ". Phone type is: " + this.phoneType + ".";
	}
}
