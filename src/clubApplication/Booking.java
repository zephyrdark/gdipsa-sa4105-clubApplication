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
	
	
	// Constructor
	public Booking(Member member, Facility facility, String start
			, String end) throws BadBookingException {
		if (member == null) {
			throw new BadBookingException("Member cannot be null!");
		}
		
		if (facility == null) {
			throw new BadBookingException("Facility cannot be null!");
		}
		
		if (start == null || stringToLocalDateTime(start) == null) {
			throw new BadBookingException("Start date cannot be null!");
		}
		
		if (end == null || stringToLocalDateTime(end) == null) {
			throw new BadBookingException("End date cannot be null!");
		}
		
//		if (stringToLocalDateTime(start) == null || (stringToLocalDateTime(end)) == null) {
//			throw new NullPointerException();
//		}
		
		if (stringToLocalDateTime(start).isAfter(stringToLocalDateTime(end))) {
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

	public void setStart(String start) {
		this.end = stringToLocalDateTime(start);
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = stringToLocalDateTime(end);
	}
	
	// Methods
	private LocalDateTime stringToLocalDateTime(String str) {
		try {
			LocalDateTime date = null;
			DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			date = LocalDateTime.parse(str, df);
			return date;
		} catch (DateTimeParseException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
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
		return member.toString() + facility.toString() + 
				"Booking start: " + start + " Booking end: " + end;
	}
	
	public void show() {
		System.out.println(toString());
	}
}
