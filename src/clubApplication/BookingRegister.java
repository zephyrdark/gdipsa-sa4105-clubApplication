package clubApplication;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingRegister {
	
	// Attributes
	
	// HashMap to contain K: Facility, V: List of Bookings
	private Map<Facility, List<Booking>> bookings;
	
	
	// Constructor
	public BookingRegister() {
		bookings = new HashMap<Facility, List<Booking>>();
	}
	
	
	// Methods
	
	// Accepts references to Member and Facility objects, and to 
	// the start and end LocalDateTime objects.
	public void addBooking(Member member, Facility facility, 
			LocalDateTime start, LocalDateTime end) throws BadBookingException {
		
		// Instantiate Booking object
		Booking bookingRequest = new Booking(member, facility, start, end);
		// get booking list of given facility
		List<Booking> facilityBookingList = bookings.get(facility);
		// if given facility has no booking list, create new bookings list
		if (facilityBookingList == null) {
			List<Booking> newBookingList = new ArrayList<Booking>();
			bookings.put(facility, newBookingList);
		}
		// if given facility has booking list, check for overlap bookings
		for (Booking booking: facilityBookingList) {
			if (booking.overlaps(bookingRequest)) {
				throw new BadBookingException("Error: Booking overlaps!");
			}
		}
		// if no overlap/BadBookingException, add bookingRequest to booking list
		facilityBookingList.add(bookingRequest);
	}
	
	
}
