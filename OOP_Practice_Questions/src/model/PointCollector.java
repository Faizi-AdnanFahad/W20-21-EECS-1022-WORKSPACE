package model;

public class PointCollector {
	
	/* Attributes */
	Point[] points;
	private int nop;
	
	/* Constructor */
	public PointCollector() {
		this.points = new Point[100];
	}
	
	public void addPoints(double x, double y) { 
		this.points[this.nop] = new Point(x, y);
		this.nop ++;
	}
	
	public Point[] getPointsinQudarantI() {
		
		int countI = 0;
		
		Point[] arrayPoints = new Point[this.nop];
		for (int i = 0; i < nop; i ++) {
			Point p = this.points[i];
			
			if(p.getX() > 0 && p.getY() > 0) {
				arrayPoints[i] = p;
				countI ++;
			}
		}
		
		Point[] firstQ = new Point[countI];
		for (int i = 0; i < countI; i ++) {
			firstQ[i] = arrayPoints[i];
		}
		
		return firstQ;
	}
	
	
	public int getNumberOfPoints() {
		return this.nop;
	}
	

	

}
 