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
	public Booking(Member member, Facility facility) {
		this.member = member;
		this.setFacility(facility);
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
				end.isBefore(booking.getStart())) {
			return false;
		}
		
		// If above conditions are not met, there is overlap.
		return true;
	}
}
