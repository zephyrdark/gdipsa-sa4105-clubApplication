package clubApplication;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;

public class Club {	
	// Attributes
	
	// --MEMBER RELATED--
	private ArrayList<Member> members = new ArrayList<Member>();
	private int currentNumber = 0;
	
	// --FACILITY RELATED--
	private Map<String, Facility> facilities = new HashMap<String, Facility>();
	
	// --BOOKING RELATED--
	private BookingRegister clubBookingRegister;
	
	
	// Constructors
	public Club() {
		clubBookingRegister = new BookingRegister();
	}
	
	// Methods	
	
	// --MEMBER RELATED--
	
	// Adds a person into this Club instance's members.
	public Member addMember(Person person) {
		// initialize new Member using Person, since Person object must already
		// exist and we can get the attributes required for Member from Person.
		Member newMember = new Member(currentNumber, person.getSurName(), 
				person.getFirstName(), person.getSecondName());
		// add new member as last member;
		members.add(newMember);
		currentNumber++;
		return newMember;
	}
	
	// Removes a Member from this Club's instance, given a memberNumber integer.
	public void removeMember(int memberNumber) {
		for (Member member: members) {
			if (member.getMemberNumber() == memberNumber) {
				members.remove(member);
				break;
			}
		}
	}
	
	// Shows all members of this Club instance's members.
	public void showMembers() {
		// Implementation #1 - using for loop
//		for (Member member: members) {
//			member.show();
//		}
		// Implementation #2 - using stream and method reference
		members.forEach(Member::show);
	}
	
	// Gets the list of members of this Club's instance.
	public ArrayList<Member> getMembers() {
		return members;
	}
	
	// Finds a Member in this Club's instance, given a memberNumber integer.
	public Member findMember(int memberNumber) {
		// Implementation #1 - using for loop
//		for (Member member: members) {
//			if (member.getMemberNumber() == memberNumber) {
//				return member;
//			}
//		}
//		return null;
		// Implementation #2 - using stream
		return members.stream()
			    .filter(x -> x.getMemberNumber() == memberNumber)
			    .findFirst()
			    .orElse(null);
	}
	
	
	// --FACILITY RELATED--
	
	/*
	 * 6)	Provide methods for handling facilities, equivalent to those 
	 * provided for members. Implement the following methods in class Club 
	 * using HashMap: getFacility(String name),  getFacilities(),  
	 * addFacility(), removeFacility() and showFacilities() 
	 */
	
	// Gets the Facility object given a facility name.
	public Facility getFacility(String name) {
		return facilities.get(name);
	}
	
	// Gets all the facilities of this Club's instance.
	public Map<String, Facility> getFacilities() {
		return facilities;
	}
	
	// Adds given facility object into this Club instance's facilities.
	public Facility addFacility(Facility facility) {
		facilities.put(facility.getName(), facility);
		return facility;
	}
	
	// Removes given facility name from this Club instance's facilities
	public void removeFacility(String name) {
		facilities.remove(name);
	}

	// Shows all facilities name and description from this Club instance's 
	// facilities.
	public void showFacilities() {
		// Implementation #1 - using for loop
		// Use .keySet() to get the String Keys (facility names) of facilities Map,
		// and loop through each String, obtain the respective facility and 
		// call its.show() method
//		for (String facility: facilities.keySet()) {
//			facilities.get(facility).show();
//		}
		// Implementation #2 - using collections values() + forEach + method reference
		facilities.values().forEach(Facility::show);
	}
	
	
	// --BOOKING RELATED--
	/*
	 * 24)	Include an instance of BookingRegister in the Club class. 
	 * 		Also in the  Club class, add a method addBooking() which will accept 
	 * 		the membership number of a member, the name of a facility, and a pair 
	 * 		of LocalDateTime objects. This method should obtain references to the 
	 * 		appropriate Member and Facility objects, then use the BookingRegister 
	 * 		object to store the booking.
	 */
	public void addBooking(int memberNumber, String facilityName, 
			LocalDateTime start, LocalDateTime end) throws BadBookingException {
		// Implementation #1 - use for loop to get Member Object
//		Member bookingMember = null;
//		for (Member member: members) {
//			if (member.getMemberNumber() == memberNumber) {
//				bookingMember = member;
//				break;
//			}
//		}
		// Implementation #2 - use stream and filter Each to get Member Object
		Member bookingMember = members.stream()
			    .filter(x -> x.getMemberNumber() == memberNumber)
			    .findFirst()
			    .orElse(null);		
		Facility bookingFacility = facilities.get(facilityName);
		clubBookingRegister.addBooking(bookingMember, bookingFacility, start, end);
	}
	
	/*
	 * 25)	Add method getBookings() to the Club class. As parameters, it will accept 
	 * the name of a facility, and two LocalDateTime object (which specify a date range). 
	 * This method will simply use the BookingRegister to get all Booking objects within 
	 * the time interval specified.
	 * 
	 * You can also add a method showBookings() to the Club 
	 * class,  which accepts the same parameters, and uses the Booking.show() method to 
	 * print each retrieved booking to the screen.
	 */
	public ArrayList<Booking> getBookings(String facilityName, LocalDateTime start, LocalDateTime end) {
		return clubBookingRegister.getBookings(facilities.get(facilityName),start,end);
	}
	
	// Implementation using Stream
	public void showBookings(String facilityName, LocalDateTime start, LocalDateTime end) {
		// Call the show() of each Booking from the ArrayList<Booking> returned from getBookings
		getBookings(facilityName,start,end).forEach(Booking::show);
	}
	
	/*
	 * 27)	Add method showFacilitiesSortedByName() to the Club class. It displays all the
	 * facilities, sorted by name.
	 */
	public void showFacilitiesSortedByName() {
		facilities.values().stream()
		.sorted(Comparator.comparing(Facility::getName))
		.forEach(System.out::println);
	}
	
	/*
	 * 28)	Add method showFacilitiesSortedByDescription() to the Club class. It also
	 *  displays all the facilities but sorted by description.
	 */
	public void showFacilitiesSortedByDescription() {
		facilities.values().stream()
		.filter(x -> x.getDescription() != null)
		.sorted(Comparator.comparing(Facility::getDescription))
		.forEach(System.out::println);
	}
	
	/*
	 * 29)	Add method showMembersSorted() to the Club class. It displays all the 
	 * members, sorted by full name (surname, then first name, then second name).
	 */
	public void showMembersSorted() {
		// TO-DO
	}
	
	
	// General
	public void show() {
		showFacilities();
		showMembers();
	}
}
