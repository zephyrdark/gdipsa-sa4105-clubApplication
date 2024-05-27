package clubApplication;

public class Member extends Person {
	
	// attributes
	private int memberNumber;

	// constructors
	public Member(int memberNumber, String surName, String firstName, String secondName) {
		super(surName, firstName, secondName);
		this.memberNumber = memberNumber;
	}

	public Member(int memberNumber, String surName, String firstName) {
		super(surName, firstName);
		this.memberNumber = memberNumber;
	}

	// getters & setters
	public int getMemberNumber() {
		return memberNumber;
	}

	// methods
	public String toString() {
		return super.toString() + " Membership Number: " + getMemberNumber();
	}

	// by using Polymorphism, this Member class can access
	// the show() method from superclass Person, which calls
	// toString() method of the object.

}
