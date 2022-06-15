package data;

import org.junit.Test;

import scrabble.data.SimpleWordList;
import scrabble.data.WordList;

import static org.junit.Assert.*;

public class InitFromWordListTest {
	@Test
	public void initFromFile() {
		WordList wl = new SimpleWordList()
				.initFromFile("wordlists/sowpods.txt");
		assertEquals("Task1: initFromFile / words should be stored in wordlist", 267751, wl.size());
	}
}