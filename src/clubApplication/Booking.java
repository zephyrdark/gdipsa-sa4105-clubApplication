package clubApplication;

import java.time.LocalDateTime;

// Booking class is used to represent facility bookings made by Members
public class Booking {
	
	// Attributes of a Booking
	private Member member;
	private Facility facility;
	private LocalDateTime start;
	private LocalDateTime end;
	
	
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
		
		if (start.isAfter(end)) {
			throw new BadBookingException("Start date cannot be after End date!");
		}		
		
		// Use setters to set the Member and Facility objects
		setMember(member);
		setFacility(facility);
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
