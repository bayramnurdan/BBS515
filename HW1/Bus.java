
public class Bus {
	private String licensePlate;
	private int numberOfSeats;
	private Seat [] Seats;         // defining array of seats from Seat class    
	
	
	// constructor that takes all parameters
	
	public Bus(String licensePlate, int numberOfSeats) {
		this.licensePlate = licensePlate ;
		this.numberOfSeats = numberOfSeats;
		this.Seats =  new Seat [this.numberOfSeats];   //specifying size of Seats array
		for (int i= 0; i<this.numberOfSeats; i++) {
			Seats [i]  = new Seat(i);	//creates one empty  instance of Seat class for each number
		}	
	}
	
	
	// get methods
	
	public String getLicensePlate() {
		return this.licensePlate;
	}
	
	
	public int getNumberOfSeats() {
		return this.numberOfSeats;
	}
	
	
	// set methods
	
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	
	
	public void setNumberOfSeats(int numberOfSeats) {  //we must do something related with seats here
		this.numberOfSeats = numberOfSeats;	
	}
	
	
    // book a seat  
	public void bookSeat(Passenger p , int seatID) {
		if (this.isSeatAvailable(seatID)) {
			Seats[seatID].setPassenger(p);
			Seats[seatID].setStatus(false);  // set availability to false
			System.out.println("The booking was done for " + p.getFullName() + ". The passengers seat ID is "  + seatID + ".");
			
			
		}else {
			System.out.println( "This seat is not avaliable " + Seats[seatID].getPassenger() + "sits there.");
		}
		
	}
	
	// check if the seat is available
	public boolean isSeatAvailable(int seatID) {
		if (Seats[seatID].getStatus() == true) {
			return true;
			
		}else {
			return false;
		}
		}
	
	
	// cancel booking 
	public void cancelSeat(String firstName, String lastName, int seatID) {// we need seat ID  and passenger full name to double check
		
		if (Seats[seatID].getPassenger().getFullName().equalsIgnoreCase(firstName + " " +lastName)) {   //user may not give the name capitalized so ignore the case and compare
			Seats[seatID].setStatus(true);                   // sets availability to true
			Seats[seatID].setPassenger(null);
			firstName = firstName.substring(0, 1).toUpperCase()  + firstName.substring(1).toLowerCase();
			lastName = lastName.substring(0, 1).toUpperCase()  + lastName.substring(1).toLowerCase();
			System.out.println("The booking cancelled for " + firstName +  " " + lastName);
		}else {
			System.out.println("The name of passenger and seat number is not matching!");
			
		}
		}
	
	
		
	
	
    // print all the passengers placed in the bus
	public  String  printAllPassengers() {
		
		String  allPassengers = "Present passengers in the bus are: ";
		boolean isTherePassenger = false;
		String noPassenger = "There is no passenger in the bus yet.";
		
		for (int i =0; i<this.numberOfSeats; i++) {
			if (Seats[i].getStatus()== false) {              //if seat is full  adds the name to all passengers string.
				allPassengers +=Seats[i].getPassenger().getFullName() + " " + "at seat number " + Integer.toString(i) + ".";
				isTherePassenger = true;        
			}else {
				continue;
			}
			
			}

		if ( isTherePassenger) {       //returns  two different type of string if there is  at least one passenger or there is not any 
			return allPassengers;
			
		}else {
			return noPassenger;
			
		}
	}
	
	// get all available seats in the bus
	public  String  printAllAvaliableSeatIDS() {
		String  availableSeats = "Avaliable seats are: ";
		String noAvailableSeats = "There is not any available seat";
		boolean isAvailableAny= false;
		
		for (int i =0; i<this.numberOfSeats; i++) {
			if (! Seats[i].getStatus()== false) {
				availableSeats +=Integer.toString(i)  + " ";   //casting int to String here
				isAvailableAny = true;
			}else {
				continue;
			}
		}
		if (isAvailableAny) {
			return availableSeats;
			
		}else {
			return noAvailableSeats;
		}
		}
	
	//  search passenger by name  and return phone number as well.
	public void searchPassenger(String firstName, String lastName) {
		boolean found = false;
		for (int i=0; i<this.numberOfSeats; i++) {
			if (Seats[i].getStatus()==false &&  (Seats[i].getPassenger().getFullName()).equalsIgnoreCase(firstName + " " + lastName)){
				System.out.println(Seats[i].getPassenger().getFullName() +". Passengers phone number is: " +Seats[i].getPassenger().getPhoneNumber().getWholeNumber() + " . The passenger sits at the seat ID: " + Integer.toString(i) + ".");
				found = true;
				
				
			}
			}
		if (! found) {
			System.out.println("Sorry, there is no booking for this name.");
		}
	}
	
	//print all seats status
	public void printAllSeats() {
		for (int i=0; i<this.numberOfSeats; i++) {
			String newI= String.format("%02d", i);    // format numbers as two digits
			if (Seats[i].getStatus()== false) {
				System.out.println( newI+ " - Full");   // format the single digit numbers!
			}else {
				System.out.println( newI + " - Empty");
			}
		}
	}
	
	
	
	
		
	}


