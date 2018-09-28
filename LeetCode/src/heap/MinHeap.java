package heap;

/*
 * 
 */
public class MinHeap {
	final int maxNodes;
	int numberOfNodes;
	int[] vals;
	MinHeap(int max){
        maxNodes = max;
        vals = new int[max+2];
        numberOfNodes = 0;
	}
        
    public int getTop(){
        return vals[1];
    }
	public void insert(int val) {
		if(numberOfNodes < maxNodes) {
			vals[++numberOfNodes] = val;
			shiftUp(val);
		}
		else {
			if(val >= vals[1]) return;
			vals[1] = val;
			shiftDown(val);
		}
	}

	private void shiftDown(int val) {
		int index = 1;
		while(index * 2 <= numberOfNodes) {
			System.out.println("down");
			if(index * 2 + 1 <= numberOfNodes) {
				if(val > vals[index*2] && val > vals[index * 2 + 1])
					return;
				if(val < vals[index*2] && val < vals[index * 2 + 1]) {
					if(vals[index*2] < vals[index*2+1]) {
						vals[index] = vals[index*2+1];
						vals[index*2+1] = val;
						index = index * 2 + 1;
					}
					else {
						vals[index] = vals[index*2];
						vals[index*2] = val;
						index = index * 2;
					}
				}
                else if(val < vals[index*2+1]){
                    vals[index] = vals[index*2+1];
					vals[index*2+1] = val;
					index = index * 2 + 1;
                }
                else{
                    vals[index] = vals[index*2];
					vals[index*2] = val;
					index = index * 2;
                }
			}
			else {
				if(val < vals[index*2]) return;
				else {
					vals[index] = vals[index*2];
					vals[index*2] = val;
					return;
				}
			}
		}
	}
	
	private void shiftUp(int val) {
		int index = numberOfNodes;
		while(index > 1) {
			System.out.println("up");
            if(val > vals[index/2]){
			    vals[index] = vals[index/2];
			    vals[index/2] = val;
                index = index / 2;
            }
            else
            	return;
		}
	}
}
