package model;

public class Registration {
	// Attributes
	private String course;
	private int marks;
	private Instructor instructor;
	private String[] gradeReport;
	private String info;
	private int gradePoint;
	
	
	// Constructor
	
	public Registration(String course) {
		this.course = course;
		this.gradeReport = new String[2];
		
	}
	
	public Registration(String course, Instructor instructor) {
		this(course);
		this.instructor = instructor;
	}
	
	// Accessor 
	
	public String getTitle() {
		return this.course;
	}
	
	public int getMarks() {
		return this.marks;
	}
	
	public Instructor getInstructor() {
		return this.instructor;
	}
	
//	// Helper Method
//	public String[] helperGetGradeReport(String index0, String index1) {
//		String[] result = new String[2];
//		result[0].equals(index0);
//		result[1].equals(index1);
//		return result;
//	}
	
	public String[] getGradeReport() {
		if (this.marks >= 90) {
			this.gradeReport[0] = "A+";
			this.gradeReport[1] = "Exceptional";
			this.gradePoint = 9;
		}
		else if (this.marks >= 80) {
			this.gradeReport[0] = "A";
			this.gradeReport[1] = "Excellent";
			this.gradePoint = 8;
		}
		else if (this.marks >= 70) {
			this.gradeReport[0] = "B";
			this.gradeReport[1] = "Good";
			this.gradePoint = 7;
		}
		else if (this.marks >= 60) {
			this.gradeReport[0] = "C";
			this.gradeReport[1] = "Competent";
			this.gradePoint = 6;
		}
		else if (this.marks >= 50) {
			this.gradeReport[0] = "D";
			this.gradeReport[1] = "Passing";
			this.gradePoint = 5;
		}
		else {
			this.gradeReport[0] = "F";
			this.gradeReport[1] = "Failing";
			this.gradePoint = 0;
		}
		
		return this.gradeReport;
	}
	
	public String getInformation() {
		String result = "";
		if (this.instructor != null) {
			result = this.course + ", taught by " + this.instructor.getName() + ", is completed with raw marks " + this.marks + " (" +  this.gradeReport[0] + " ; " + this.gradeReport[1] + ")";
		}
		else {
			result = this.course + " has not yet been assigned an instructor";
		}
		return result;
	}
	
	public int getGradePoint() {
		return this.gradePoint;
	}
	
	// Mutator
	
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	public void setMarks(int newMark) {
		this.marks = newMark;
	}
	
	public void setGradePoint(int newGradePoint) {
		this.gradePoint = newGradePoint;
	}

	
	
	
}
