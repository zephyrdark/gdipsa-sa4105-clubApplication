package clubApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingRegister {
	
	// Attributes
	
	// HashMap to contain K: Facility, V: List of Bookings
	private HashMap<Facility, ArrayList<Booking>> bookingRegister = new HashMap<Facility, ArrayList<Booking>>();
	
	
//	// Constructor
//	public BookingRegister() {
//		bookingRegister = new HashMap<Facility, ArrayList<Booking>>();
//	}
	
	
	// Getter
	public HashMap<Facility, ArrayList<Booking>> getBookingRegister() {
		return bookingRegister;
	}
	
	
	// Methods
	
	// Accepts references to Member and Facility objects, and to 
	// the start and end LocalDateTime objects.
	public ArrayList<Booking> addBooking(Member member, Facility facility, 
			LocalDateTime start, LocalDateTime end) throws BadBookingException {
		
		// Instantiate Booking object
		Booking bookingRequest = new Booking(member, facility, start, end);
				
		// if given facility has no booking list, create new bookings list
		if (bookingRegister.get(facility) == null) { // bookingLists.get(facility) returns List<Booking>
			ArrayList<Booking> newBookingList = new ArrayList<Booking>();
			bookingRegister.put(facility, newBookingList);
		}
		
		// if given facility has booking list, check for overlap bookings
		for (Booking booking: bookingRegister.get(facility)) {
			if (booking.overlaps(bookingRequest)) {
				throw new BadBookingException("Error: Booking overlaps!");
			}
		}
						
		// if no overlap/BadBookingException, add bookingRequest to booking list
		bookingRegister.get(facility).add(bookingRequest);
		return bookingRegister.get(facility);
	}
	
	// Accepts references to Facility, LocalDateTime start/end to return a 
	// ArrayList<Booking> which contains all Bookings for the given Facility
	// within the start/end times
	
	// Implementation #1 - for loop - it works.
//	public ArrayList<Booking> getBookings(Facility facility, 
//			LocalDateTime start, LocalDateTime end) {
//		// Instantiate ArrayList<Booking> to hold the queried Bookings
//		ArrayList<Booking> bookingsWithinDates = new ArrayList<Booking>();
//		// Loop through each Booking to check for the start/end times.
//		for (Booking booking: bookingRegister.get(facility)) {
//			if ((booking.getStart().isAfter(start) || booking.getStart().equals(start)) && 
//					(booking.getEnd().isBefore(end) || booking.getEnd().equals(end))) {
//				bookingsWithinDates.add(booking);
//			}				
//		}
//		return bookingsWithinDates;
//	}
	
	
	// Implementation #2 - using Stream - it works.
	public ArrayList<Booking> getBookings(Facility facility, LocalDateTime start, LocalDateTime end) {
		List<Booking> filteredFacilityBookings = bookingRegister.get(facility).stream()
				.filter(booking -> booking.getStart().isAfter(start) && booking.getEnd().isBefore(end))
	            .collect(Collectors.toList());
		return (ArrayList<Booking>)filteredFacilityBookings;
	}
	
	// Remove Booking from bookingLists given a reference to a Booking object.
	public void removeBooking(Booking booking) {
		// TO-DO: complete this.
	}
}
