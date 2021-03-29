package junit_tests;

public class RegistrationSystem {
	// Attributes
	private Transcript[] transcripts;
	private int numT;
	private Transcript[] backupT;
	private boolean courseNameExist;
	
		// Constructor
	public RegistrationSystem() {
		this.transcripts = new Transcript[500];
		this.numT = 0;
		this.courseNameExist = false;
		
	}
		// Accessor
	public Transcript[] getReport() {
		this.backupT = new Transcript[this.numT];
		for (int i = 0; i < this.numT; i ++) {
			this.backupT[i] = this.transcripts[i];
		}
		return this.backupT;
	}
	
	public int getMarks(String studentID, String courseName) {
		int result = 0;
		boolean found = false;
		for (int i = 0; i < this.numT; i ++) {
			if (this.transcripts[i].getStudentID().equals(studentID)) {
				result = this.transcripts[i].getMarks(courseName);
				found = true;
			}
		}
		
		if (found == false) {
			result = -1;
		}
		return result;
	}
	
		
		// Mutator
	public void addTranscript(Transcript transcripts) {
		this.transcripts[this.numT] = transcripts;
		this.numT ++;
	}
	
	// Helper Method
	
	public void setCourseNameExist(String courseName) {
		for (int i = 0; i < this.numT; i ++) {
			if (this.transcripts[i].checkCourseName(courseName).equals("good")) {
				this.courseNameExist = true;
			}
			
		}
	}
	
}

















 