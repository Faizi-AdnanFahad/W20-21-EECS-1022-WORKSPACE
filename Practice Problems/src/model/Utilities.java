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
	
//-----------------------------------------------------------------------------------------------------------
	
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
	
//-----------------------------------------------------------------------------------------------------------
	
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
	
//-----------------------------------------------------------------------------------------------------------
		
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
				
//-----------------------------------------------------------------------------------------------------------
				
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
		
//-----------------------------------------------------------------------------------------------------------
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
		
//-----------------------------------------------------------------------------------------------------------
		
		// Problem: Make an animated array
		
		public static String animatedArray(String[] array) {
			String result = "";
			
			return result;
		}
		
//-----------------------------------------------------------------------------------------------------------
		
		// Problem: Return an array that contains exactly the same numbers as the given array, 
		// but rearranged so that every 3 is immediately followed by a 4. Do not move the 3's, 
		// but every other number may move. The array contains the same number of 3's and 4's, 
		// every 3 has a number after it that is not a 3, and a 3 appears in the array before any 4.
		
		// For example:        fix34([1, 3, 1, 4])  [1, 3, 4, 1]
		
		public static int[] fix34(int[] nums) {
			int[] result = new int[nums.length];
			
			int m = 0;
			int i = 0;
			boolean stay = true;
			
			for (; i < nums.length; i ++) {
				if(nums[i] == 3) {
					stay = true;
					if (nums[i + 1] == 4) {
						result = nums;
					}
					else {
						for (; stay && m < nums.length; m ++) {
							if(nums[m] == 4) {
								int temp = nums[i + 1];
								nums[i + 1] = nums[m];
								nums[m] = temp;
								stay = false;
							}
						}
					}
				}
				else {
					result = nums;
				}
			}
			
			return result;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
					
				
				
}
