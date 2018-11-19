package misc;

/*
 * Google Ãæ¾­
 * Print a 2D array in a single for loop
 */
public class Print2DArray {
	public void printArray(int[][] array) {
		for(int i=0,j=0;i<array.length&&j<array[0].length;j++) {
			System.out.print(array[i][j]);
			if(j==array[0].length-1) {
				i++;
				j=-1;
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] array = new int[4][3];
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[0].length;++j) {
				array[i][j] = (i+1)*(j+1);
			}
		}
		new Print2DArray().printArray(array);
	}
}
