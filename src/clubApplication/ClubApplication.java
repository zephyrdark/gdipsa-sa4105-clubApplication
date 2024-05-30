package clubApplication;

public class ClubApplication {

	public static void main(String[] args) {
		System.out.println("--ClubApplication main--");
		
		// Test Member and respective Club methods.
		Club club1 = new Club();
		club1.addMember(new Person("Lee", "Alvin"));
		club1.addMember(new Person("Tan", "Ah", "Beng"));
		club1.addMember(new Person("Stan", "Laurel"));
		club1.showMembers();
		
		System.out.println("\nRemove Member 1");
		club1.removeMember(1);
		club1.showMembers();
		
		System.out.println("\nFind members 0 and 2");
		System.out.println(club1.findMember(0));
		System.out.println(club1.findMember(2));
			
		// Test Facility and respective Club methods.
		Facility facility1 = new Facility("Gym");
		Facility facility2 = new Facility("Spa","Treat yourself to a rejuvenating spa");
				
		club1.addFacility(facility1);
		club1.addFacility(facility2);
		
		System.out.println("\nShow club Facilities:");
		club1.showFacilities();
	}

}
