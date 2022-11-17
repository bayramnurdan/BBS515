
//BBS 515 HW1.
//This code belongs to Nurdan Emin.
//Student number N22137478.

import java.util.Scanner;

public class Main {
	
	public static String passengerFirstName = "";  // to make variable all available through the main class we use public and static keywords
	public static String passengerLastName = "";
	public static String passengerGender="";
	public static String passengerCountryCode="+90";
	public static String passengerTelephoneCode="";
	public static String passengerTelephoneNumber="";
	public static String passengerPhoneType="";
	public static String turkishGSM = "yes";
	
	

	public static void main(String[] args) {
		
		int capacityOfBus =42;
		
		Bus bus = new Bus("06 BBS 515", capacityOfBus);  //create instance of bus class
		Scanner scan = new Scanner(System.in);    //create scanner object
		
	
		System.out.println("--------------------------Welcome to the Nurdan's bus ticket booking program!-------------------------");  // there must be a way to center it but I could not find yet.
		
		
		boolean exit = false;
		while (! exit){  // unless exit is on it will keep showing the menu.
		getMenu();           
		System.out.println("Enter your choice: ");
		
		int userResponse = scan.nextInt();
		if (userResponse ==1) {     //book a seat
			System.out.println("To book a seat I need some info:\n"
					+ "The seat number you want to book for: ");
			int seatNumberToBook = scan.nextInt();
			if (seatNumberToBook>=0 && seatNumberToBook<capacityOfBus) {   //check if there is a seat with that number
				if (bus.isSeatAvailable(seatNumberToBook)) {   // check if the seat is available
					askQuestionsForBooking();
					Phone passengerPhone = new Phone(passengerCountryCode, passengerTelephoneCode, passengerTelephoneNumber, passengerPhoneType);
					Passenger  passengerToBookFor = new Passenger(passengerFirstName, passengerLastName, passengerGender, passengerPhone);
					bus.bookSeat(passengerToBookFor, seatNumberToBook);
					
						
				}else {
						System.out.println("The number you wish is not empty please choose another seat");   // ask another seat to book if the first one is full.
						seatNumberToBook = scan.nextInt();
						askQuestionsForBooking();
						Phone passengerPhone = new Phone(passengerCountryCode, passengerTelephoneCode, passengerTelephoneNumber, passengerPhoneType);
						Passenger  passengerToBookFor = new Passenger(passengerFirstName, passengerLastName, passengerGender, passengerPhone);
						bus.bookSeat(passengerToBookFor, seatNumberToBook);

					}
				}else {
					System.out.println("Sorry, our seat numbers range from 0 to " + Integer.toString(capacityOfBus) +".\n");
				}
			
			
			
		}else if (userResponse ==7 ) {    // exit 
			exit = true;
			System.out.println("Exiting...");
			System.exit(0);
			
			
		}else if (userResponse==2) {   // cancel the booking
			System.out.println("To make a cancellation I need some info");
			System.out.println("The seat number you want to cancel: ");
			int seatNumberToCancel = scan.nextInt();
			System.out.println("The first name of passenger: ");
			String firstNameToCancel = scan.next();
			System.out.println("The last name of passenger: ");
			String lastNameToCancel = scan.next();
			bus.cancelSeat(firstNameToCancel, lastNameToCancel, seatNumberToCancel); 

			
		}else if (userResponse==3) {
			System.out.println("Printing all passengers...\n");
			System.out.println(bus.printAllPassengers());
			System.out.println("\n");
			
		}else if (userResponse==4) {
			System.out.println("Printing all available seats...\n");
			System.out.println("\n");
			System.out.println(bus.printAllAvaliableSeatIDS());
			
		}else if (userResponse==5) {  //print all seats
			System.out.println("Printing all seats...\n");
			bus.printAllSeats();
			System.out.println("\n");
			
		}else if (userResponse==6) {
			System.out.println("To make a search I need passengers:\nFirst name");
			String firstNameToSearch = scan.next();
			System.out.println("Last name:");
			String lastNameToSearch = scan.next();
			bus.searchPassenger(firstNameToSearch, lastNameToSearch);
			System.out.println("\n");
			
		}else {
			System.out.println("Please choose a valid option.\n");
		}
	}
		
		
		}
	
// This method asks sequential questions and assigns them to corresponding variables
	
	public static void askQuestionsForBooking() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Your first name:");
		
		
		passengerFirstName= scan.next();
		System.out.println("Your last name:");
		passengerLastName  = scan.next();
		System.out.println("Your gender: ");
		passengerGender = scan.next();
		System.out.println("Do you use  Turkish GSM? Yes or No");
		turkishGSM=scan.next();
		if (turkishGSM.equalsIgnoreCase("No")) {
			System.out.println("Telephone country code: ");    //we must ask this only if the passenger is outside from Turkey.
			passengerCountryCode= scan.next();
			
		}
		System.out.println("GSM or city code: ");  
		passengerTelephoneCode= scan.next();  //reads one word
		System.out.println("the main part of your phone number(must contain 7 digits without space)");
		passengerTelephoneNumber= scan.next();
		scan.nextLine();
		System.out.println("The type of phone you gave: Home, Office, Mobile etc:");
		passengerPhoneType= scan.next();
		
		
		
}
	public static void getMenu() {
		System.out.println("1-Book a seat.\n"
				+ "2-Cancel booking. \n"
				+ "3-Print all passengers.\n"
				+ "4-Print avaliable seats.\n"
				+ "5-Print all seats.\n"
				+ "6-Search passenger by name. \n"
				+ "7-Exit.");
		
		
	}
	}
	
		
		
	
