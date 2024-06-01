package clubApplication;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashMap;

public class Club {	
	// Attributes
	
	// --MEMBER RELATED--
	private List<Member> members = new ArrayList<Member>();
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
				return;
			}
		}
	}
	
	// Shows all members of this Club instance's members.
	public void showMembers() {
		// the below for loop is the equivalent of C#'s for-each
		for (Member member: members) {
			member.show();
		}
	}
	
	// Gets the list of members of this Club's instance.
	public List<Member> getMembers() {
		return members;
	}
	
	// Finds a Member in this Club's instance, given a memberNumber integer.
	public Member findMember(int memberNumber) {
		for (Member member: members) {
			if (member.getMemberNumber() == memberNumber) {
				return member;
			}
		}
		return null;
	}
	
	
	// --FACILITY RELATED--
	
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
		// Use Set and .keySet() to make the facilities K,V pairs readable.
		Set<String> facilitiesKeys = facilities.keySet();
		// Loop through each set and call its .show() method
		for (String facility: facilitiesKeys) {
			facilities.get(facility).show();
		}
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
		// Implementation #1 - for loop to get Member Object
		Member bookingMember = null;
		for (Member member: members) {
			if (member.getMemberNumber() == memberNumber) {
				bookingMember = member;
				break;
			}
		}
		// TO-DO: Implementation #2 - try using Stream to get Member Object
		Facility bookingFacilty = facilities.get(facilityName);
		clubBookingRegister.addBooking(bookingMember, bookingFacilty, start, end);
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
		return clubBookingRegister.getBookings(this.facilities.get(facilityName),start,end);
	}
	
	// Implementation using Stream
	public void showBookings(String facilityName, LocalDateTime start, LocalDateTime end) {
		this.getBookings(facilityName,start,end).forEach(x -> x.show());
	}
	
	// General
	public void show() {
		this.showFacilities();
		this.showMembers();
	}
}
