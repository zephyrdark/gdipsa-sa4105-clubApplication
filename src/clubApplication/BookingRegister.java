package clubApplication;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingRegister {
	
	// Attributes
	
	// HashMap to contain K: Facility, V: List of Bookings
	private HashMap<Facility, ArrayList<Booking>> bookingLists;
	
	
	// Constructor
	public BookingRegister() {
		bookingLists = new HashMap<Facility, ArrayList<Booking>>();
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
			ArrayList<Booking> newBookingList = new ArrayList<Booking>();
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
	
	// Implementation #1 - for loop
//	public ArrayList<Booking> getBookings(Facility facility, 
//			LocalDateTime start, LocalDateTime end) {
//		// Instantiate ArrayList<Booking> to hold the queried Bookings
//		ArrayList<Booking> bookingsWithinDates = new ArrayList<Booking>();
//		// Loop through each Booking to check for the start/end times.
//		for (Booking booking: bookingLists.get(facility)) {
//			if (booking.getStart().isAfter(start) && booking.getEnd().isBefore(end)) {
//				bookingsWithinDates.add(booking);
//			}
//		}
//		return bookingsWithinDates;
//	}
	
	// Implementation #2 - by ChatGPT3.5 generated implementation using Stream
//	return bookingLists.entrySet().stream()
//            .filter(entry -> entry.getKey().equals(facility))
//            .flatMap(entry -> entry.getValue().stream())
//            .filter(booking -> booking.getStart().isAfter(start) && booking.getEnd().isBefore(end))
//            .collect(Collectors.toList());
	
	// Implementation #3 - after referencing Implementation #2
	public List<Booking> getBookings(Facility facility, LocalDateTime start, LocalDateTime end) {
		return bookingLists.get(facility).stream()
	            .filter(booking -> booking.getStart().isAfter(start) && booking.getEnd().isBefore(end))
	            .collect(Collectors.toList());
	}
	
}
