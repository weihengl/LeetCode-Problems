package dfs;

import java.util.Arrays;
import java.util.List;

/*
 * Leetcode No.841
 */
public class RoomsAndKeys {
	boolean visited[];
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int numberOfRooms = rooms.size();
        if(numberOfRooms == 1)
        	return true;
        visited = new boolean[numberOfRooms];
        Arrays.fill(visited, false);
        visitRooms(rooms,0);
        for(int i=0;i<numberOfRooms;++i) {
        	if(!visited[i]) return false;
        }
        return true;
    }
	
	private void visitRooms(List<List<Integer>> rooms, int roomNumber) {
		List<Integer> keys = rooms.get(roomNumber);
		if(visited[roomNumber])
			return;
		visited[roomNumber] = true;
		for(int i=0;i<keys.size();i++) {
			visitRooms(rooms,keys.get(i));
		}
	}
}
