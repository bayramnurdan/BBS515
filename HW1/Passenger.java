

public class Passenger {
	private String firstName;
	private String lastName;
	private String gender;
	private Phone phoneNumber;
	
	// constructor that takes all fields as parameter
	public Passenger(String firstName, String lastName, String gender, Phone phoneNumber) {
		this.firstName = firstName.substring(0, 1).toUpperCase()  + firstName.substring(1).toLowerCase();
		this.lastName = lastName.substring(0, 1).toUpperCase()  + lastName.substring(1).toLowerCase();  // Format  name and gender.
		this.gender = gender.substring(0, 1).toUpperCase()  + gender.substring(1).toLowerCase();
		this.phoneNumber = phoneNumber;
			
		}
	
		
	
	// get methods
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
		}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	
	public Phone getPhoneNumber() {
		return this.phoneNumber;
	}
	
	
	// set methods
	
	public void  setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public void setPhoneNumber(Phone phoneNumber) {
		this.phoneNumber = phoneNumber;
		
	}
	
	// display method
	
	public String toString() {
		return "Passenger's name is: "  + this.firstName +  " " + this.lastName  + ". Passenger is " + this.gender + ". "+ this.phoneNumber;
	} 
	
	
	
}
