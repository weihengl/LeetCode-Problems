package googleOA;

/*
 * Leetcode No.657 easy
 * Judge whether robot returns to start place
 */
public class RobotReturn {
	public boolean judgeCircle(String moves) {
        int Us = 0;
        int Ls = 0;
        char[] ms = moves.toCharArray();
        for(int i=0;i<ms.length;++i) {
        	if(ms[i] == 'U')
        		Us++;
        	else if(ms[i] == 'D')
        		Us--;
        	else if(ms[i] == 'L')
        		Ls++;
        	else
        		Ls--;
        }
        return Ls == 0 && Us == 0;
    }
}
