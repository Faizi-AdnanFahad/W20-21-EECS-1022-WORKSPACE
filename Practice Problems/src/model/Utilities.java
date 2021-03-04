package model;

public class Utilities {
	
	
	// Problem: Sort an array in an increasing order;
	public static int[] increasing(int[] array) {
		int[] result = null;                      // [4, 2, 3, 1]
		
		for (int i = 0; i < array.length - 1; i ++ ) {
			for (int m = 0; m < array.length - 1; m ++ ) {
				int temp = array[m];
				if (array[m] > array[m+1]) {
					array[m] = array[m+1];
					array[m+1] = temp;
				}
				else if (array[m] < array[m+1]) {
					array[m] = array[m];
					array[m+1] = array[m+1]; 
				}
			}
		}
		result = array;
		
		return result;
		}
	
	// Problem: sort an array in a decreasing order?
	public static int[] decreasing(int[] array) {
		int[] result = null;                      // [4, 2, 3, 1]
		
		for (int i = 0; i < array.length - 1; i ++ ) {
			
			for (int m = 0; m < array.length - 1; m ++ ) {
				int temp = array[m];
				
				if (array[m] > array[m+1]) {
					array[m] = array[m];
					array[m+1] = array[m+1]; 
				}
				else if (array[m] < array[m+1]) {
					array[m] = array[m+1];
					array[m+1] = temp;
				}
			}
		}
		result = array;
		
		return result;
		}
	
	// Problem: Sort an array in an non-descending(increasing or equal) order;
		public static int[] nonDescending(int[] array) {
			int[] result = null;                      // [4, 2, 2, 1]
			
			for (int i = 0; i < array.length - 1; i ++ ) {
				for (int m = 0; m < array.length - 1; m ++ ) {
					int temp = array[m];
					if (array[m] > array[m+1]) {
						array[m] = array[m+1];
						array[m+1] = temp;
					}
					else if (array[m] <= array[m+1]) {
						array[m] = array[m];
						array[m+1] = array[m+1]; 
					}
				}
			}
			result = array;
			
			return result;
			}
	
		// Problem: Sort an array in an non-descending(increasing or equal) order;
				public static int[] nonAscending(int[] array) {
					int[] result = null;                      // [1, 2, 2, 5]  ---> [4, 2, 2, 1]
					
					for (int i = 0; i < array.length - 1; i ++ ) {
						for (int m = 0; m < array.length - 1; m ++ ) {
							int temp = array[m];
							if (array[m] >= array[m+1]) {
								array[m] = array[m];
								array[m+1] = array[m+1];
							}
							else if (array[m] < array[m+1]) {
								array[m] = array[m+1];
								array[m+1] = temp; 
							}
						}
					}
					result = array;
					
					return result;
					}
				
		// Problem: Given an array a of integers, how do you determine if it is sorted in a non-decreasing order?
		public static boolean nonDecreasing(int[] array) {
			boolean result = true; 
			
			for(int i = 0; i < array.length - 1; i ++) {
				if (array[i] > array[i + 1]) {
					result = false;		
					i = array.length;
				}
				else {
					result = true;
				}
			}
			
			return result;
		}
		
		// Ask the user how many integers they would like to input,
		// prompt them accordingly, then ask them for an integer index, 
		// and check if the number stored at that index is even (i.e., error if it is odd).
		
		// a console application in the name of "CheckIndexEvenOdd"  has been created in the console applicarion.
		public static String CheckingIndexEvenOdd(int[] array, int index) {
			String result = "";               // [24, 5, 6]
			
			if ((0 <= index && index < array.length)&& (array[index] % 2 == 0)) {
				result = array[index] + " at index " + index + " is EVEN.";
			}
			else if (array[index] % 2 == 1){
				result = "Error!" + " index " + index + " is ODD!";
			}
			
			return result;
		}
		
		// Problem: Make an animated array
		
		public static String animatedArray(String[] array) {
			String result = "";
			
			return result;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
					
				
				
}
