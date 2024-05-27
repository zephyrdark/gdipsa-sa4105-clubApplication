package clubApplication;

public class ClubApplication {

	public static void main(String[] args) {
		System.out.println("--ClubApplication main--");
		
		Club club1 = new Club();
		club1.addMember(new Person("Lee", "Alvin"));
		club1.addMember(new Person("Tan", "Ah", "Beng"));
		club1.addMember(new Person("Stan", "Laurel"));
		club1.showMembers();
		
		System.out.println("Remove Member 1");
		club1.removeMember(1);
		club1.showMembers();		
				
		Facility facility1 = new Facility("Gym");
		Facility facility2 = new Facility("Spa","Treat yourself to a rejuvenating spa");
		facility1.show();
		facility2.show();
	}

}
