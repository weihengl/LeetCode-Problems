package bitManipulation;

// Problem NO. 476
/*
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer¡¯s binary representation.
 */
public class NumberComplement {
	public int findComplement(int num) {
		int n = 0;
		for(int i=0;i<32;++i) {
			if((num>>i)==0)
				return n;
			if((num&(1<<i))==0)
				n += 1<<i;
		}
		return n;
	}
}
