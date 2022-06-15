package scrabble.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Set;

public class PermutationUtilities {

	static StringBuilder sb = new StringBuilder();
	static Random rand = new Random();
	static byte[] alphabet = { 'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G', 'h', 'H', 'i', 'I',
			'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S', 't',
			'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z' };

	/**
	 * creates a set with all subsets of the input string
	 *
	 * @param str
	 * @return
	 */

	public static String createPermutation(int length) {
		for (int i = 0; i < length; i++) {
			int v = rand.nextInt(alphabet.length);
			char u = (char) alphabet[v];
			sb.append(u);
		}
		String erg = sb.toString();
		return erg;
	}

	 public static Set<String> getSubSets(String str) {
	        return null;
	    }
	
	
	public static String createPermutation(String p) {
		char[]cArray=p.toCharArray();
		ArrayList<Character>M=new ArrayList<Character>();
		for(char t: cArray){
			M.add(t);
			sb.append(t);
		}
		String erg = sb.toString();
		return erg;
	}
}