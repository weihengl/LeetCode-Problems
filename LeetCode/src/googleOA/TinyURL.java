package googleOA;

import java.util.HashMap;
import java.util.Map;

/*
 * Leetcode No.585 medium
 */
public class TinyURL {
	Map<Integer,String> map = new HashMap();
	int number = 0;
	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		++number;
		map.put(number, longUrl);
		return String.valueOf(number);
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		int index = Integer.parseInt(shortUrl);
		return map.get(index);
	}
}
