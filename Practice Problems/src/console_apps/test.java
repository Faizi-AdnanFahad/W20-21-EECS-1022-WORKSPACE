package console_apps;

public class test {

	public static void main(String[] args) {
		
		boolean condition = true;
		boolean stay = true;
		
		 char[][] board = {
	                {'_', '_', 'x'},
	                {'_', 'x', '_'},
	                {'x', '_', '_'}
	        };
		 char firstChar = 'z';
		 if (board[0][2] != '_') {
			 firstChar = board[0][2];
		 }
		 else {
			 condition = false;
			 stay = false;
		 }
		 
		 
		 for (int i = 0; stay && i < 3; i ++) {
			 if (board[i][2 - i] != firstChar) {
				 condition = false;
				 stay = false;
			 }
		 }
		 
		 System.out.println(condition);
	}
}
