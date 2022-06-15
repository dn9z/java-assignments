package scrabble.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import scrabble.util.Permutation;

public class SimpleWordList implements WordList {
	
	private java.util.HashSet<String> listOfAllWords = new HashSet<>();
	HashSet<String> Perms = new HashSet<>();

	@Override
	public Set<String> validWordsUsingAllTiles(String tileRackPart) {
		Permutation p = new Permutation(tileRackPart);
		String pRes = p.getNormalized();
	        for (String sWord : listOfAllWords) {
	            Permutation current = new Permutation(sWord);
	            String sString = current.getNormalized();
	            if (sString.equals(pRes)) {
	               Perms.add(current.getWord());
	            }
	        }
			return Perms;
	}

	@Override
	public Set<String> allValidWords(String tileRack) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(String word) {
		if (word != null) {
			listOfAllWords.add(word);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean addAll(Collection<String> words) {
		if (words.size() > 0) {
			for (String word : words) {
				add(word);
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return listOfAllWords.size();
	}

	@Override
	public WordList initFromFile(String fileName) {
		BufferedReader br = null;
		String line;
		try {
			br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null) {
				add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return this;
	}

	@Override
	public String toString() {
		String result = "";
		for (String s : listOfAllWords) {
			result += s + "\n";
		}
		return result;
	}

}
