package clubApplication;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingRegister {
	
	// Attributes
	
	// HashMap to contain K: Facility, V: List of Bookings
	private Map<Facility, List<Booking>> bookingLists;
	
	
	// Constructor
	public BookingRegister() {
		bookingLists = new HashMap<Facility, List<Booking>>();
	}
	
	
	// Methods
	
	// Accepts references to Member and Facility objects, and to 
	// the start and end LocalDateTime objects.
	public void addBooking(Member member, Facility facility, 
			LocalDateTime start, LocalDateTime end) throws BadBookingException {
		
		// Instantiate Booking object
		Booking bookingRequest = new Booking(member, facility, start, end);
				
		// if given facility has no booking list, create new bookings list
		if (bookingLists.get(facility) == null) { // bookingLists.get(facility) returns List<Booking>
			List<Booking> newBookingList = new ArrayList<Booking>();
			bookingLists.put(facility, newBookingList);
		}
		
		// if given facility has booking list, check for overlap bookings
		for (Booking booking: bookingLists.get(facility)) {
			if (booking.overlaps(bookingRequest)) {
				throw new BadBookingException("Error: Booking overlaps!");
			}
		}
		
		// if no overlap/BadBookingException, add bookingRequest to booking list
		bookingLists.get(facility).add(bookingRequest);
	}
	
	// Accepts references to Facility, LocalDateTime start/end to return a 
	// ArrayList<Booking> which contains all Bookings for the given Facility
	// within the start/end times
	public ArrayList<Booking> getBookings(Facility facility, 
			LocalDateTime start, LocalDateTime end) {
		// TO-DO: to complete, question 21.
		return null;
	}
	
}
