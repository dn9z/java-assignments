package scrabble.util;

import java.util.Arrays;

public class Permutation {

	private String wordValue;
	private String normalized;
	
	public Permutation(String word) {
		wordValue = word;
		normalized = doNormalization();
		
	}

	@Override
	public int hashCode() {
		// TBD: implement this method
		int res=0;
		char[] f=normalized.toCharArray();
		for( char s :f){
			res+=1;
		}
		return res;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Permutation)) return false;
		Permutation casted = (Permutation) obj;
		String objNormalized = casted.getNormalized();
		return this.hashCode()==casted.hashCode(); // characterwise equal (sorted)
	}

	@Override
	public String toString() {
		return getWord() + " / " + getNormalized();
	}
	
	public String getNormalized() {
		StringBuilder sb=new StringBuilder();
		char[] f=normalized.toCharArray();
		for(char s:f){
			sb.append(s);
		}
		String out=sb.toString();
		return out;
	}

	private String doNormalization() {
		char[] chars = wordValue.toCharArray();
		 Arrays.sort(chars);
		return new String(chars);
	}

	public String getWord() {
		// TBD: implement this method
		return wordValue;
	}

	public int length() {
		// TBD: implement this method
		char[] f=normalized.toCharArray();
		return f.length;
	}

}
