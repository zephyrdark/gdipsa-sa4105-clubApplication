package clubApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
	public static void main(String[] args) {
		System.out.println("--ClubApplication main--");
		
		// Test Member and respective Club methods.
		Club club1 = new Club();
		club1.addMember(new Person("Lee", "Alvin"));
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
		club1.addFacility(new Facility("Gym"));
		club1.addFacility(new Facility("Spa","Treat yourself to a rejuvenating spa"));
		
		System.out.println("\nShow club Facilities:");
		club1.showFacilities();
		
		System.out.println("\nShow club Facilities and Members:");
		club1.show();
		
		// Test Booking class
		try {
			Booking booking1 = new Booking(club1.findMember(0), club1.getFacility("Gym"), 
					stringToLocalDateTime("2024-05-30 12:00"), stringToLocalDateTime("2024-06-14 12:00"));
			booking1.show();
		} catch(BadBookingException e) {
			System.out.println(e.getMessage());
		}
		
		
		// TEST CASES
		
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
