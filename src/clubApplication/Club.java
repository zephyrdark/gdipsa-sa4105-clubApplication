package clubApplication;

public class Club {
	// attributes
	private Member[] members = new Member[0];
	private int currentNumber = 0;
	
	// methods
	private Member[] extendMembersArray(Member[] arr) {
		Member[] extendedMembersArray = new Member[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			extendedMembersArray[i] = arr[i];
		}
		return extendedMembersArray;
	}
	
	public Member addMember(Person person) {
		// initialize new Member using Person, since Person object may already
		// exist and we can get the attributes required for Member from Person.
		Member newMember = new Member(currentNumber, person.getSurName(), 
				person.getFirstName(), person.getSecondName());
		members = extendMembersArray(members);
		members[currentNumber] = newMember;
		currentNumber += 1;
		return newMember;
	}
	
	public void removeMember(int memberNumber) {
		Member[] resizedMembersArray = new Member[members.length-1];
		for (int i = 0; i < members.length; i++) {
			
			// since member number is an integer, we can use comparison operators
			// to check condition whether to add them to new array or not.
			if (members[i].getMemberNumber() < memberNumber) {
				resizedMembersArray[i] = members[i];
			}
			else if (members[i].getMemberNumber() > memberNumber) {
				resizedMembersArray[i-1] = members[i];
			}
		}
		members = resizedMembersArray;
	}
	
	public void showMembers() {
		// C# foreach equivalent
		for (Member member: members) {
			if (member != null) {
				member.show();				
			}
		}
	}
}
