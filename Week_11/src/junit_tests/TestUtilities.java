package junit_tests;

import static org.junit.Assert.*;
import model.Utilities;

import org.junit.Test;


public class TestUtilities {

	@Test
	public void test_getRowByRow_01() {
		int[][] input1 = {
				{1, 2 , 3 , 4 }, 
				{5, 6 , 7 , 8 },
				{9, 10, 11, 12} 
			};
		
		String output1 = Utilities.getPrintoutRowByRow(input1);
		String expected1 = "{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}";
		
		assertEquals(expected1, output1);
	}
	
	@Test
	public void test_getRowByRow_02() {
		int[][] input2 = {
				{1, 2, 3, 4}, 
				{5, 6, 7   },
				{8          } 
			};
		
		String output2 = Utilities.getPrintoutRowByRow(input2);
		String expected2 = "{{1, 2, 3, 4}, {5, 6, 7}, {8}";
		
		assertEquals(expected2, output2);
	}

	@Test
	public void test_getColByCol_01() {
		int[][] input1 = {
				{1, 2 , 3 , 4 }, 
				{5, 6 , 7 , 8 },
				{9, 10, 11, 12} 
			};
		
		String output1 = Utilities.getPrintoutColByCol(input1);
		String expected1 = "{{1, 5, 9}, {2, 6, 10}, {3, 7, 11}, {4, 8, 12}";
		
		assertEquals(expected1, output1);
	}
	
	@Test
	public void test_getAverage_01() {
		int[][] input1 = {
				{1, 2 , 3 , 4 }, 
				{5, 6 , 7 , 8 },
				{9, 10, 11, 12} 
			};
		
		double output1 = Utilities.getAverage(input1);
		double expected1 = 6.5;
		
		assertEquals(expected1, output1, 0.01);
	}
	
	@Test
	public void est_getAverage_02() {
		int[][] input2 = {
				{1, 2, 3, 4}, 
				{5, 6, 7   },
				{8          } 
			};
		
		double output2 = Utilities.getAverage(input2);
		double expected2 = 4.5;
		
		assertEquals(expected2, output2, 0.01);
	}
	
	
	@Test
	public void est_getRowAverage_01() {
		
		int[][] input1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		
		double[] output1 = Utilities.getRowAverage(input1);
		double[] expected1 = {2.5, 6.5, 10.5};
		assertTrue(output1.length == expected1.length);
		
		for (int i = 0; i < expected1.length; i ++) {
			assertEquals(expected1[i], output1[i], 0.001);
		}
	}
	
	@Test
	public void est_getRowAverage_02() {
		
		int[][] input1 = {{1, 2, 3, 4}, {5, 8, 7}, {6}};
		
		double[] output1 = Utilities.getRowAverage(input1);
		double[] expected1 = {2.5, 6.6, 6.0};
		assertTrue(output1.length == expected1.length);
		
		for (int i = 0; i < expected1.length; i ++) {
			assertEquals(expected1[i], output1[i], 0.1);
		}
	}
	
	@Test
	public void test_getMinMax_01() {
		int[][] input1 = {
				{1, 10 , 5, 7 }, 
				{6, 2 , 12 , 9},
				{3, 8, 4, 11} 
			};
		
		int[] output1 = Utilities.getMaxMin(input1);
		int[] expected1 = {12, 1};
		
		assertArrayEquals(expected1, output1);
	}
	
	@Test
	public void test_getMinMax_02() {
		int[][] input1 = {
				{1, 2, 3, 4}, 
				{5, 6, 7   },
				{8          } 
			};
		
		int[] output1 = Utilities.getMaxMin(input1);
		int[] expected1 = {8, 1};
		
		assertArrayEquals(expected1, output1);
	}
	
	// -------------------------------------------------------------------------------------------------
	// Test case for the first version 
	@Test
	public void test_getRowWithMaxSum_01() {
		int[][] input1 = {
				{10, 10, 10, 10}, 
				{41},
				{-4, 29, 13} 
			};
		
		int[] output1 = Utilities.getRowWithMaxSum1(input1);
		int[] expected1 = {41};
		
		assertArrayEquals(expected1, output1);
	}
	
	@Test
	public void test_getRowWithMaxSum_02() {
		int[][] input1 = {
				{1, 10 , 5, 7 }, 
				{6, 2 , 12 , 9},
				{3, 8, 4, 11} 
			};
		
		int[] output1 = Utilities.getRowWithMaxSum1(input1);
		int[] expected1 = {6, 2 , 12 , 9};
		
		assertArrayEquals(expected1, output1);
	}
	
	// test cases for the second version
	@Test
	public void test_getRowWithMaxSum_03() {
		int[][] input1 = {
				{10, 10, 10, 10}, 
				{41},
				{-4, 29, 13} 
			};
		
		int[] output1 = Utilities.getRowWithMaxSum2(input1);
		int[] expected1 = {41};
		
		assertArrayEquals(expected1, output1);
	}
	
	@Test
	public void test_getRowWithMaxSum_04() {
		int[][] input1 = {
				{1, 10 , 5, 7 }, 
				{6, 2 , 12 , 9},
				{3, 8, 4, 11} 
			};
		
		int[] output1 = Utilities.getRowWithMaxSum2(input1);
		int[] expected1 = {6, 2 , 12 , 9};
		
		assertArrayEquals(expected1, output1);
	}
	// -------------------------------------------------------------------------------------------------
}
