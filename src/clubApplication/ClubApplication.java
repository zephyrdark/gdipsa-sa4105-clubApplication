package clubApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class ClubApplication {
	
	// Instantiate DateTimeFormatter object that will create LocalDateTime objects
	static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	
	// Method - Helpers
	
	// Converts String input to LocalDateTime objects
	private static LocalDateTime stringToLocalDateTime(String str) {
		try {
			LocalDateTime date = null;
			date = LocalDateTime.parse(str, df);
			return date;
		} catch (DateTimeParseException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	// Method - Main
	public static void main(String[] args) throws BadBookingException {
		System.out.println("--ClubApplication main--");
		
		// Test Member and respective Club methods.
		Club club1 = new Club();
		club1.addMember(new Person("Lee", "Alvin"));
		club1.addMember(new Person("Lee", "Elvin"));
		club1.addMember(new Person("Tan", "Ah", "Kow"));
		club1.addMember(new Person("Tan", "Ah", "Meow"));
		club1.addMember(new Person("Tan", "Mee", "Meow"));
		club1.addMember(new Person("Tan", "Ah", "Beng"));
		club1.addMember(new Person("Stan", "Laurel"));
		club1.showMembers();
		
		System.out.println("\nRemove Member 1");
		club1.removeMember(1);
		club1.showMembers();
		
		System.out.println("\nFind members 0 and 2");
		System.out.println(club1.findMember(0));
		System.out.println(club1.findMember(2));
			
		// Test Facility and respective Club methods.				
		club1.addFacility(new Facility("Gym","Bodies in motion, Strength and sweat intertwining, Paths to wellness forged."));
		club1.addFacility(new Facility("Spa","Tranquil oasis, Renewal in every breath, Blissful waters flow."));
		club1.addFacility(new Facility("Massage","Gentle hands bestow, Serenity and relief, Tension fades away."));
		club1.addFacility(new Facility("Events Space","Vibrant gatherings, Echoes of laughter and joy, Memories take flight."));
		club1.addFacility(new Facility("Karaoke"));
		
		System.out.println("\nShow club Facilities:");
		club1.showFacilities();
		
		System.out.println("\nShow club Facilities and Members:");
		club1.show();
		
		
		// -- TEST CASES --
		
		// Test BookingRegister
		
		// Test BookingRegister - Instantiate and initialize BookingRegister
		BookingRegister br = new BookingRegister();

		// Test BookingRegister - Add booking to BookingRegister
		System.out.println("\nAdd Booking to BookingRegister");
		br.addBooking(club1.findMember(0),club1.getFacility("Gym"),
				stringToLocalDateTime("2024-05-30 12:00"),stringToLocalDateTime("2024-06-07 12:00"));;
		
		
		// Test BookingRegister - Get bookings from BookingRegister
		System.out.println("\nCurrent bookings in BookingRegister for " + club1.getFacility("Gym"));
		ArrayList<Booking> a = br.getBookings(club1.getFacility("Gym"), 
				stringToLocalDateTime("2024-05-29 12:00"),stringToLocalDateTime("2024-06-15 12:00"));
		a.stream().forEach(x -> System.out.println(x));
		
		// Test Booking class - Remove booking from BookingRegister
		Booking bookingToRemove = br.getBookingRegister().get(club1.getFacility("Gym")).get(0);
		br.removeBooking(bookingToRemove);
		System.out.println("\nRemoved Booking from BookingRegister");
		
		ArrayList<Booking> b = br.getBookings(club1.getFacility("Gym"), 
				stringToLocalDateTime("2024-05-29 12:00"),stringToLocalDateTime("2024-06-15 12:00"));
		b.stream().forEach(x -> System.out.println(x));
		
		// Test Club class - Add booking
		System.out.println("\nAdd Booking from Club");
		club1.addBooking(0, "Gym", stringToLocalDateTime("2024-06-07 12:00"), 
				stringToLocalDateTime("2024-06-10 12:00"));
		
		System.out.println("\nAdd Booking from Club");
		club1.addBooking(0, "Gym", stringToLocalDateTime("2024-06-11 12:00"), 
				stringToLocalDateTime("2024-06-14 12:00"));
		
		System.out.println("\nCurrent bookings in Club for " + club1.getFacility("Gym"));
		club1.showBookings("Gym", stringToLocalDateTime("2024-06-07 12:00"), 
				stringToLocalDateTime("2024-06-14 12:00"));
		
		// Test Club class - Show Club Facilities Sorted By Name (question 27)
		System.out.println("\nShow Club Facilities Sorted By Name");
		club1.showFacilitiesSortedByName();
		
		// Test Club class - Show Club Facilities Sorted By Description (question 28)
		System.out.println("\nShow Club Facilities Sorted By Description");
		club1.showFacilitiesSortedByDescription();
		
		// Test Club class - Show Club Members, sorted by full name (surname, then 
		// first name, then second name) (question 29)
		System.out.println("\nShow Club Members, Sorted By Full Name");
		club1.showMembersSorted();
		
		// Test exception for null Member
//		System.out.println("\nTest null member:");
//		try {
//			Booking booking1 = new Booking(club1.findMember(9999), club1.getFacility("Gym"), 
//					stringToLocalDateTime("2024-05-30 12:00"), stringToLocalDateTime("2024-06-14 12:00"));
//		} catch(BadBookingException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		// Test exception for null Facility
//		System.out.println("\nTest null facility:");
//		try {
//			Booking booking2 = new Booking(club1.findMember(0), club1.getFacility("Cove"), 
//					stringToLocalDateTime("2024-05-30 12:00"), stringToLocalDateTime("2024-06-14 12:00"));
//		} catch(BadBookingException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		// Test exception for null no start date
//		System.out.println("\nTest no start date:");
//		try {
//			Booking booking3 = new Booking(club1.findMember(0), club1.getFacility("Gym"), 
//					stringToLocalDateTime("2024"), stringToLocalDateTime("2024-06-14 12:00"));
//		} catch(BadBookingException e) {
//			System.out.println(e.getMessage());
//		} catch(NullPointerException e) {
//			System.out.println(e);
//		}
//		
//		// Test exception for null no end date
//		System.out.println("\nTest no end date:");
//		try {
//			Booking booking4 = new Booking(club1.findMember(2), club1.getFacility("Spa"), 
//					stringToLocalDateTime("2024-05-30 12:00"), stringToLocalDateTime("2024"));
//		} catch(BadBookingException e) {
//			System.out.println(e.getMessage());
//		} catch(NullPointerException e) {
//			System.out.println(e);
//		}
//		
//		// Test exception for null no end date
//		System.out.println("\nTest start date after end date:");
//		try {
//			Booking booking4 = new Booking(club1.findMember(2), club1.getFacility("Spa"), 
//					stringToLocalDateTime("2024-05-30 12:00"), stringToLocalDateTime("2024-05-20 12:00"));
//		} catch(BadBookingException e) {
//			System.out.println(e.getMessage());
//		} catch(NullPointerException e) {
//			System.out.println(e);
//		}
	}
}
