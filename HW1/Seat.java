
public class Seat {
	private int  seatID;  //seat id must be the indices in range of number of seats
	private boolean status;
	private Passenger passenger;
	
	// constructor that takes all parameters
	public Seat(int seatID, boolean status, Passenger passenger) {  //if status is true, the seat is available.
		this.seatID = seatID;
		this.status = status;
		this.passenger = passenger ;   
		
	}
	// empty seat constructor
	public Seat(int seatID) {
		this.seatID = seatID;
		this.status = true;     //The seat's status is true in default
		this.passenger = null; //null is default value of any reference type variable which is not initialized at the time of declaration.
	}
	
	
	// get methods
	
	public int  getSeatID() {
		return this.seatID;
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public Passenger getPassenger() {  //returns  passengers 
		return this.passenger;
	}
	
	// set methods
	public void setSeatID(int seatID) {
		this.seatID = seatID;	
	}
	
	public void setStatus(boolean status) {
		this.status =status;
	}
	
	public void setPassenger (Passenger passenger) {
		this.passenger = passenger;
	}
	
	
	// display method
	
	public String toString() {
		if (this.status == false){     // if someone sits on the seat, method also returns the name of passenger
			return "The seat ID is :" + this.seatID + " The seat is not available. " + "The passenger " + this.passenger.getFullName() + " sits there.";
			
		}else {  //if status true the seat is empty 
			return "The seat ID is :" + this.seatID + " and it is avaliable for booking." ;
		}
			
		
		
		
	}
	
	
	

}
