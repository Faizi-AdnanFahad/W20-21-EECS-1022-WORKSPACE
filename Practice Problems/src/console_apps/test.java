package console_apps;

public class test {

	public static void main(String[] args) {
		
		char[][] ns = {
				{'0', '0', '0', '0'},
				{'0', '0', '0', '0'},
				{'0', '0', '0', '0'},
				{'0', '0', '0', '0'}
		};
		
		
		for (int i = 0; i < ns.length; i ++) {
			for (int j = 0; j < ns.length; j ++) {
				if (j > i) {
					System.out.print(ns[i][j]);
				}
				else {
					System.out.print(" ");
				}
			}
		}
	}

}
