package trie;

/*
 * Leetcode No.72 easy
 */
public class LongestWord {
	int max = 0;
	String ans = "";
	public String longestWord(String[] words) {
		if(words.length == 0) return null;
		Trie root = new Trie();
	    for(int i=0;i<words.length;++i) {
	    	root.insert(words[i], -1);
	    }
	    searchLongest(root,0,"");
	    return ans;
	}
	 
	public void searchLongest(Trie node,int length,String prefix) {
		if(length>=1) { // which means we do not have prefix as a word;
			if(node.hasChildren) {
				int childrenTimes = 0;
				for(int i=0;i<26;++i) {
					childrenTimes += node.children[i].times;
				}
				if(node.times==childrenTimes) {
					if(length-1>max) {
						max = length -1;
						ans = prefix;
						System.out.println("3ans is:"+ans);
					}
					return;
				}
			}
		}
		if(node.times == 0) {
			return;
		}
		if(node.hasChildren == false) {
			if(length > max) {
				max = length;
				ans = prefix + node.ch;
				System.out.println("2ans is:"+ans);
			}
			return;
		}
		else {
			if(length>0)
			for(int i=0;i<26;++i) {
				searchLongest(node.children[i],length+1,prefix+node.ch);
			}
			else
				for(int i=0;i<26;++i) {
					searchLongest(node.children[i],length+1,prefix);
				}
		}
	}
	
	class Trie{
		char ch;
		Trie[] children;
		boolean hasChildren;
		int times;
		
		Trie(){
			times = 0; 
			hasChildren = false;
		}	
		void setChar(char ch) {this.ch = ch;}
		void insert(String word, int index) {
			times ++;
			if(index < word.length()-1) {
				if(children == null) {
					initChildren();
				}
				if(index>=0)
					children[word.charAt(index+1)-'a'].insert(word, index+1);
				else
					children[word.charAt(0)-'a'].insert(word, 0);
			}
		}
		
		void initChildren() {
			children = new Trie[26];
			for(int i=0;i<26;++i) {
				children[i] = new Trie();
				children[i].setChar((char)('a'+i));
			}
			hasChildren = true;
		}
	};
	
	
	public static void main(String[] args) {
		System.out.println(new LongestWord().longestWord(new String[] {"sg","qgca","s","qzu","qzub","qzubvs","hlyc","hl","qg","qzubv","qgc","qgcab","qz","sgs","sgsnyn","hly","hlycf","sgsn"}));
		//String str = "hello";
		//System.out.println(str.substring(0,str.length()-1));
	}
}
