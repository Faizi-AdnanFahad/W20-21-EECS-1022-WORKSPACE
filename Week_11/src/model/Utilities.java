package model;

public class Utilities {
	
	public static String getPrintoutRowByRow(int[][] a) {
		String result = "{";
		
		for (int i = 0; i < a.length; i ++ ) {
			result += "{";
		
			//----------------------------------------
			for (int m = 0; m < a[i].length; m ++) {
				if (m == a[i].length - 1) {
					result += a[i][m];
				}
				else {
					result += a[i][m] + ", ";
				}
			}
			//----------------------------------------
			
			if (i == a.length - 1) {
				result += "}";
			}
			else {
				result += "}, ";
			}
			
		}
		return result;
	}
	
	// Version 1
	// Assumption: input array is rectangle
	public static String getPrintoutColByCol(int[][] a) {
		String result = "{";
		
		// since the input 'a' is rectangular, it's not empty.
		for (int m = 0; m < a[0].length; m ++) {
			result += "{";
		
			//----------------------------------------
			for (int i = 0; i < a.length; i ++ ) {
				if (i == a.length - 1) {
					result += a[i][m];
				}
				else {
					result += a[i][m] + ", ";
				}
			}
			//----------------------------------------
			
			if (m == a[0].length - 1) {
				result += "}";
			}
			else {
				result += "}, ";
			}
			
		}
		return result;
	}
		// Version 2
//		String result = "{";
//		
//		for (int i = 0; i < a.length + 1; i ++) {
//			
//			result += "{";
//			for (int m = 0; m < a[0].length - 1; m ++ ) {
//				if (m == a[0].length - 2) {
//					result += a[m][i];
//				}
//				else {
//					result += a[m][i] + ", ";
//				}
//			} 
//			
//			if (i == a.length) {
//				result += "}";
//			}
//			else {
//				result += "}, ";
//			}
//		}
//		
//		return result;
	
	public static double getAverage(int[][] a) {
		double sum = 0;
		int num = 0;
		
		for (int i = 0; i < a.length; i ++ ) {
			for (int m = 0; m < a[i].length; m ++) {
				sum += a[i][m];
				num ++;
			}
		}
		double average = sum / num;
		return average;
	}
	
	
	public static double[] getRowAverage(int[][] a) {
		double[] avg = new double[a.length];
	// alternative way of putting the sum
		// sum = 0;
		
		for (int i = 0; i < a.length; i ++ ) {
			double sum = 0;
			for (int m = 0; m < a[i].length; m ++) {
				sum += a[i][m];
			}
			avg[i] = sum / a[i].length;
			sum = 0;
		}
		
		return avg;
	}
	
	/*
	 * Assumption: the input array 'a' is non-empty
	 */
	public static int[] getMaxMin(int[][] a) {
		int max = a[0][0];
		int min = a[0][0];
		
		for (int i = 0; i < a.length; i ++ ) {
			for (int m = 0; m < a[i].length; m ++) {
				if (a[i][m] > max) {
					max = a[i][m];
				}
				
				if(a[i][m] < min) {
					min = a[i][m];
				}
			}
		}
		int[] array = {max, min};
		return array;
	}
	
	/*
	 * Assumption1: parameter given array is not empty
	 * Assumption2: The sum of arrays arrays are different
	 */
	// Version 1
	public static int[] getRowWithMaxSum1(int[][] a) {
		int[] result = null;
		
		int[] helper = new int[a.length];
		
		for(int i = 0; i < a.length; i ++ ) {
			int sumCurrent = 0;
			for(int m = 0; m < a[i].length; m ++) {
				sumCurrent += a[i][m];
			}
			helper[i] = sumCurrent;
		}
		
		int max = helper[0];
		int index = 0;
		for (int i = 0; i < helper.length; i ++) {
			if (helper[i] > max) {
				max = helper[i];
				index = i;
			}
		}
		
		result = a[index];
		return result;
	}
	

	/*
	 * Assumption1: parameter given array is not empty
	 * Assumption2: The sum of arrays arrays are different
	 */
	// Version 2
	public static int[] getRowWithMaxSum2(int[][] a) {
		int rowSum = 0;
		
		// Calculate the initial sum for the first row
		for (int i = 0; i < a[0].length; i ++) {
			rowSum += a[0][i];
		}
		
		int maxRowSum = rowSum;
		int rowIndex = 0; // Index of the row with maximum sum
		
		// Start the row with 1 since rowSum has been initialized to the sum of row 0.
		for (int i = 1; i < a.length; i ++)  {
			rowSum = 0;
			for (int c = 0; c < a[i].length; c ++) {
				rowSum += a[i][c];
			}
			if (rowSum > maxRowSum) {
				maxRowSum = rowSum;
				rowIndex = i;
			}
		}
		return a[rowIndex];
	}
	
	
}


















