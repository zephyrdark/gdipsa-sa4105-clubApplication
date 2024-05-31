package clubApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// Booking class is used to represent facility bookings made by Members
public class Booking {
	
	// Attributes of a Booking
	private Member member;
	private Facility facility;
	private LocalDateTime start;
	private LocalDateTime end;
	// Instantiate DateTimeFormatter object that will create LocalDateTime objects
	static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	
	
	// Constructor
	public Booking(Member member, Facility facility, LocalDateTime start
			, LocalDateTime end) throws BadBookingException {
		
		// Throw BadBookingException if any of the parameters are null
		String error = null;
		error = (member == null) ? "Member cannot be null!" : null;
		error = (facility == null) ? "Facility cannot be null" : null;
		error = (start == null) ? "Start date cannot be null!" : null;
		error = (end == null) ? "End date cannot be null!" : null;
		error = (start.isAfter(end)) ? "Start date cannot be after End date!" : null;
		if (error != null) {
			throw new BadBookingException(error);			
		}
		
		// Use setters to set the Member and Facility objects
		setMember(member);
		setFacility(facility);
		setStart(start);
		setEnd(end);
	}

	
	// Getters & setters
	public Member getMember() {
		return member;
	}
	
	public void setMember(Member member) {
		this.member = member;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}
	
	// Methods
	
	// Checks if given Booking object overlaps with this Booking object's
	// start and end times.
	public Boolean overlaps(Booking booking) {
		// No overlap if this Booking and target Booking are for different
		// facilities.
		if (facility != booking.getFacility()) {
			return false;
		}

		// This Booking does not overlap if:
		// 1. this Booking's start is after target Booking's end, or
		// 2. this Booking's end is before target Booking's start
		if (start.isAfter(booking.getEnd())
			|| end.isBefore(booking.getStart())
			) {
			return false;
		}
		
		// If above conditions are not met, there is overlap.
		return true;
	}
	
	// 
	@Override
	public String toString() {
		return "\nBooking Details:"
				+ "\n\tMember:" + member.toString() 
				+ "\n\tFacility" + facility.toString() 
				+ "\n\tBooking start: " + start.format(df) 
				+ "\n\tBooking end: " + end.format(df);
	}
	
	public void show() {
		System.out.println(toString());
	}
}
