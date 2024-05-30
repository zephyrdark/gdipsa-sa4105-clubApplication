package clubApplication;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class Club {	
	// Attributes
	
	// --MEMBER RELATED--
	private List<Member> members = new ArrayList<Member>();
	private int currentNumber = 0;
	
	// --FACILITY RELATED--
	private Map<String, Facility> facilities = new HashMap<String, Facility>();
	
	
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
	
	// General
	public void show() {
		this.showFacilities();
		this.showMembers();
	}
}
