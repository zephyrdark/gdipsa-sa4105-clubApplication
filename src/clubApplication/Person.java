package clubApplication;

public class Person {
	// attributes
	private String surName;
	private String firstName;
	private String secondName;

	// constructors
	public Person(String surName, String firstName, String secondName) {
		this.surName = surName;
		this.firstName = firstName;
		this.secondName = secondName;
	}
	
	public Person(String surName, String firstName) {
		this.surName = surName;
		this.firstName = firstName;
	}

	// getters & setters
	public String getSurName() {
		return surName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}
	
	// methods
	public String toString() {
		String output = "";
		if (getSecondName() != null) {
			output += getSurName() + " " + getFirstName()
			+ " " + getSecondName();
		} else {
			output += getSurName() + " " + getFirstName();
		}
		return output;
	}
	
	public void show() {
		System.out.println(toString());
	}
}
