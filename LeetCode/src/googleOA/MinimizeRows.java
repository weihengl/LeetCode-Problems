package googleOA;

public class MinimizeRows {
	int num;
	public int findSolution(int[] A) {
		int m = A.length; if(m==0) return 0;
		int rows[] = new int[m];
		int[] r = new int[m]; // we do not need r here
		rows[0] = A[0];
		num = 1;
		for(int i=1;i<m;++i) {
			int row = findRow(A[i],rows,0,num-1);
			r[i] = row;//delete it
			if(row==num) {
				rows[num++] = A[i];
			}
			else {
				rows[row] = A[i];
			}
		}
		for(int i=0;i<m;++i) {
			System.out.print(r[i] + ";");
		}
		System.out.println();
		System.out.println("Ans is " + num);
		return num;
	}
	
	public int findRow(int target, int[] rows, int lo, int hi) {
		if(lo>hi) return num;
		int m = (lo+hi)/2;
		if(target>=rows[m]) {
			if(m==num-1) return num;
			else
				return findRow(target,rows,m+1,hi);
		}
		else {
			if(m==0) return 0;
			else {
				if(target>=rows[m-1])
					return m;
				else
					return findRow(target,rows,lo,m-1);
			}
		}
	}
	
	public static void main(String[] args) {
		new MinimizeRows().findSolution(new int[] {5,6,4,5,9,7,9,9,3});
	}
}
