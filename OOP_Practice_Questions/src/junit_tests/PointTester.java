package junit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.PointCollector;

import model.Point;

public class PointTester {

	@Test
	public void test_01() {
		PointCollector pc = new PointCollector();
		
		assertEquals(0, pc.getNumberOfPoints());
		
		pc.addPoints(3, 4);
		assertEquals(1, pc.getNumberOfPoints());
		
		pc.addPoints(-3, 4);
		assertEquals(2, pc.getNumberOfPoints());
		
		pc.addPoints(3, -4);
		assertEquals(3, pc.getNumberOfPoints());
		
		pc.addPoints(-3, -4);
		assertEquals(4, pc.getNumberOfPoints());
		
		Point[] ps = pc.getPointsinQudarantI();
		assertEquals(1, ps.length);
		
		double a = ps[0].getX();
	
	}

}
