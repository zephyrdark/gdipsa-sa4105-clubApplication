package clubApplication;

public class Facility {
	// Attributes
	private String name;
	private String description;
		
	// Constructors
	public Facility(String name) {
		this.name = name;
		this.description = null;
	}
	
	public Facility(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	// Getters & setters
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	// Methods
	@Override
	public String toString() {
		String output = "";
		if (getDescription() == null) {
			output += "Facility Name: " + getName();			
		} else {
			output += "Facility Name: " + getName() + "\tDescription: " + getDescription();
		}
		return output;
	}
	
	public void show() {
		System.out.println(toString());
	}
}
