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
		if (member == null) {
			throw new BadBookingException("Member cannot be null!");
		}
		
		if (facility == null) {
			throw new BadBookingException("Facility cannot be null!");
		}
		
		if (start == null) {
			throw new BadBookingException("Start date cannot be null!");
		}
		
		if (end == null) {
			throw new BadBookingException("End date cannot be null!");
		}
		
//		if (stringToLocalDateTime(start) == null || (stringToLocalDateTime(end)) == null) {
//			throw new NullPointerException();
//		}
		
		if (start.isAfter(end)) {
			throw new BadBookingException("Start date cannot be after End date!");
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

		// No overlap if:
		// 1. this Booking's start is after target Booking's end, or
		// 2. this Booking's end is before target Booking's start
		if (start.isAfter(booking.getEnd()) ||
				start.isEqual(booking.getStart()) ||
				end.isBefore(booking.getStart()) ||
				end.isEqual(booking.getEnd())) {
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
