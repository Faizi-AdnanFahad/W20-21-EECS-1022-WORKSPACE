package model;

public class Participant {
	
	// Attributes
	private String studentName;
	private Registration[] registrations;
	private int count; // it is used to count the tumber of courses that has been added so far
	private final int MAX_NUM_OF_REGISTERATION = 5;
	private Registration[] allArray;
	
	// Constructor
	
	public Participant(String studentName) {
		allArray = new Registration[MAX_NUM_OF_REGISTERATION];
		this.studentName = studentName;
		
	}
	
	// Accessor 
	
	public Registration[] getRegistrations() {
		this.registrations = new Registration[this.count];
		for(int i = 0; i < this.count; i ++) {
			this.registrations[i] = allArray[i];
		}
		return this.registrations;
	}
	
	public String getGPAReport() {
		String result = "";
		String seq = "{";
		double gpaSum = 0;
		if (this.getRegistrations().length == 0) { // If no course has been registered - trace using paper or using debugger in case of any confustion.
			result = "No GPA available yet for " + this.studentName;
		}
		else {
			for (int i = 0; i < this.count; i ++) {
				gpaSum += this.registrations[i].getGradePoint();
				if (i < this.count - 1) {
					seq += this.registrations[i].getGradePoint() + " " + "(" + this.registrations[i].getGradeReport()[0] + "), ";
				}
				else if (i == this.count - 1){
					seq += this.registrations[i].getGradePoint() + " " + "(" + this.registrations[i].getGradeReport()[0] + ")";
				}
			}
			seq += "}";
			result = this.studentName + "'s GPA of " + seq + ": " + String.format("%.1f",gpaSum/this.count);
		}
		return result;
	}
	
	public int marksOf(String courseName) {
		int result = 0;
		boolean stay = true;;
		boolean found = false;
		for (int i = 0; stay && i < this.count; i ++) {
			if (this.registrations[i].getTitle().equals(courseName)) {
				result = this.registrations[i].getMarks();
				stay = false;
				found = true;
			}
		}
		if (found == false) {
			result = -1;
		}
		return result;
	}
	
	// Mutator
	
	public void addRegistration(Registration registration) {
		if (this.count < MAX_NUM_OF_REGISTERATION) {
			allArray[this.count] = registration;
			this.count ++;
		}
		// check the maximum number of count that should be 5 at most
	}
	
	public void addRegistration(String newCourse) {
		if (this.count < MAX_NUM_OF_REGISTERATION) {
			Registration newRegister = new Registration(newCourse);
			allArray[this.count] = newRegister;
			this.count ++;
		}
		}
	
	public Registration[] getArrayNoNull() {
		return this.allArray;
	}
	
	public void updateMarks(String course, int mark) {
		this.registrations = new Registration[this.count];
		for(int i = 0; i < this.count; i ++) {
			this.registrations[i] = allArray[i];
		}
		boolean stay = true;
		for (int i = 0; stay && i < count; i ++) {
			if (this.registrations[i].getTitle().equals(course)) {
				this.registrations[i].setMarks(mark);
				
				if (mark >= 90) {
					this.registrations[i].setGradePoint(9);
				}
				else if (mark >= 80) {
					this.registrations[i].setGradePoint(8);
				}
				else if (mark >= 70) {
					this.registrations[i].setGradePoint(7);
				}
				else if (mark >= 60) {
					this.registrations[i].setGradePoint(6);
				}
				else if (mark >= 50) {
					this.registrations[i].setGradePoint(5);
				}
				else {
					this.registrations[i].setGradePoint(0);
				}
				
				stay = false;
			}
		}
		
	}
	
	public void clearRegistrations() {
		for (int i = 0; i < this.count; i ++) {
			this.registrations[i] = null;
		}
		this.count = 0;
	}
	
	
}
 