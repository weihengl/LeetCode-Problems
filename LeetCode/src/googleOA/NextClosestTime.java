package googleOA;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * Leetcode No.681 medium
 */
public class NextClosestTime {
	 Set<Integer> digits;
		int oHour;
		int oMinute;
		int ansHour;
		int ansMinute;
		int diffTime = 1440; // 24 * 60
		public String nextClosestTime(String time) {
			oHour = Integer.valueOf(time.split(":")[0]);
			oMinute = Integer.valueOf(time.split(":")[1]);
			initSet(time);
			backTrace(0,0,0);
			String ans = "";
			if(ansHour<10) ans += "0";
			ans += ansHour + ":";
			if(ansMinute<10) ans += "0";
			ans += ansMinute;
			return ans;
		}
		
		void initSet(String time){
			digits = new HashSet();
			digits.add(oHour/10);
	        digits.add(oHour%10);
	        digits.add(oMinute/10);
	        digits.add(oMinute%10);
	        
		}
		
		void backTrace(int index, int hour, int minute) {
			Iterator<Integer> iter = digits.iterator();
			while(iter.hasNext()) {
				int val = iter.next();
				if(index == 0) {
					if(val > 2) continue;
					else
						backTrace(index+1,val*10,0);
				}
				else if(index == 1) {
					if(hour == 20 && val > 4)  continue;
					else
						backTrace(index+1,hour + val,0);
				}
				else if(index == 2) {
					if(val>5) continue;
					else
						backTrace(index+1,hour,val*10);
				}
				else {
					int testHour = hour;
					int testMinute = minute + val;
					int time = 60 * (testHour-oHour) + (testMinute-oMinute);
					if(time <= 0) time += 1440;
					if(time<=diffTime) {
						diffTime = time;
						ansHour = testHour;
						ansMinute = testMinute;
					}
				}
			}
		}
}
