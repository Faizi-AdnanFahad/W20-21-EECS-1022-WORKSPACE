package model;

public class OnlineSchool {
	
	// Attributes
	private Participant[] participants;
	private final int MAX_NUM_OF_PARTICIPANTS = 100;
	private int count;
	private int add;
	private Participant[] backup;
	private Participant[] specificStudents;
	private int a;
	
	// Constructor
	
	public OnlineSchool() {
		this.participants = new Participant[MAX_NUM_OF_PARTICIPANTS];
	}
	
	// Accessor
	
	public Participant[] getParticipants(String course) {
		
//		for(int m = 0; )
//			for (int i = 0; i < this.participants.length; i ++ ) { 
//				if (this.participants[i] == null) {
//				}
//				else if (this.participants[i].getRegistrations()[i].getTitle().equals(course)) {
//					this.add ++;
//				}
//			}
			
		for(int m = 0; m < this.count; m ++) {
			for (int i = 0; i < this.participants[m].getArrayNoNull().length; i ++ ) {
				if (this.participants[m].getArrayNoNull()[i] == null) {
				}
				else if (this.participants[m].getArrayNoNull()[i].getTitle().equals(course)) {
					this.add ++;
				}
		}
//			for (int i = 0; i < this.participants.length; i ++ ) { 
//				if (this.participants[i] == null) {
//				}
//				else if (this.participants[i].getArrayNoNull()[i].getTitle().equals(course)) {
//					this.a ++;
//				}
//			}
		}
		boolean stay = true;
		int n = 0;
		this.backup = new Participant[this.add];
		for(int m = 0; m < this.count; m ++) {
			for (int i = 0; i < this.participants[m].getArrayNoNull().length; i ++ ) {
				if (this.participants[m].getArrayNoNull()[i] == null) {
				}
				else if (this.participants[m].getArrayNoNull()[i].getTitle().equals(course)) {
					stay = true;
					for (; stay && n < this.add; n ++) {
						this.backup[n] = this.participants[m];
						stay = false;
					}
				}
		}
		}
		
		
		
		
		
		
//		this.backup = new Participant[this.count];
//		
//		for(int i = 0; i < this.count; i ++) {
//			this.backup[i] = this.participants[i];
//		}
//		
//		
//		for (int i = 0; i < this.backup.length; i ++) {
//			if (this.backup[i].getRegistrations()[i].getTitle().equals(course)) {
//				this.add ++;
//			}
//		}
//		this.specificStudents = new Participant[this.add];
//		for (int i = 0; i < this.backup.length; i ++) {
//			if (this.backup[i].getRegistrations()[i].getTitle().equals(course)) {
//				this.specificStudents[i] = this.backup[i];
//				this.add ++;
//			}
//		}
		this.add = 0;
		return this.backup;
		}
	
	// Mutator 
	
	public void addParticipant(Participant participant) {
		this.participants[this.count] = participant;
		this.count ++;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
