package histogram;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Lab03 {

	private static String bigIntFile = "/Users/tweak/CloudStation/IMI/2. Semester/Informatik 2/labs/lab-03/source/deu_news_1995_10K/deu_news_1995_10K-inv_w.txt";
	private static String bigTextFile = "/Users/tweak/CloudStation/IMI/2. Semester/Informatik 2/labs/lab-03/source/deu_news_1995_10K/deu_news_1995_10K-sentences.txt";
	private static String smallTextFile = "/Users/tweak/CloudStation/IMI/2. Semester/Informatik 2/labs/lab-03/source/deu_news_1995_10K/deu_news_1995_10K-meta.txt";
	private static String exercise07 = "/Users/tweak/CloudStation/IMI/2. Semester/Informatik 2/labs/lab-03/source/eng_news_2015_3M/eng_news_2015_3M-sentences.txt";
	private InputStream is;
	private int[] frequencies;

	public Lab03() throws IOException {
	}

	public static void main(String[] args) throws IOException {
		Lab03 main = new Lab03();

		main.readFirstCharacterOfFile(bigTextFile);
		//main.test();
		main.writeToFile("AABBBCCCC");
		main.writeToFile(3897236);
		main.writeToFile(2387532);
		main.writeFrequenciesToFile(exercise07, true, "frequency-exercise07.txt");
		main.printHistogram(bigTextFile, true, 1000);
	}


	public void readFirstCharacterOfFile(String uri) throws IOException {
		Path path = Paths.get(uri);
		is = Files.newInputStream(path);
		char output = (char) is.read();
		System.out.println("First character of specified file is: " + output);
	}

	public void test() {
		String test = "1234";
		byte[] result = test.getBytes();
		for (int i = 0; i < result.length; i++) {
			System.out.println((char) result[i]);
		}
	}

	public void writeToFile(String text) throws FileNotFoundException {
		String file = "stringToFile.txt";
		PrintWriter writer = new PrintWriter(file);
		writer.println(text);
		writer.close();
	}

	public void writeToFile(Integer input) throws FileNotFoundException {
		String file = "integerToFile.txt";
		PrintWriter writer = new PrintWriter(file);
		writer.println(input);
		writer.close();
	}

	public void writeToFile(int input) {
		String file = "intToFile.txt";
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);
			writer.println(input);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @param str
	 *            a Path in UNIX Format or a simple String
	 * @param button
	 *            specifies if str shall be seen as a String or a Path True for
	 *            Path and False for String
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public void writeFrequenciesToFile(String str, boolean button, String fileLocation) throws IOException {
		byte[] bytes;
		int[] frequencies = new int['z' + 1];

		// check if str is a path or just a string by checking the boolean button
		if (button) {
			Path path = Paths.get(str);
			bytes = Files.readAllBytes(path);
		} else {
			StringBufferInputStream is = new StringBufferInputStream(str);
			bytes = new byte[is.available()];
			for (int i = 0; i < bytes.length; i++) {
				is.read(bytes);
			}
		}

		// add found characters to new frequencies
		for (int i = 0; i < bytes.length; i++) {
			if (bytes[i] >= 'A' && bytes[i] <= 'Z') {
				frequencies[bytes[i]]++;
			}
			if (bytes[i] >= 'a' && bytes[i] <= 'z') {
				frequencies[bytes[i]]++;
			}
		}

		this.frequencies = frequencies;

		// calculate all frequencies
		String result = "";
		for (int i = 0; i < frequencies.length; i++) {
			if (frequencies[i] != 0) {

				result += (char) i + " - Frequency = " + frequencies[i] + "\n";
			}
		}

		// print frequencies to file
		if (fileLocation != null) {
			PrintWriter writer = new PrintWriter(fileLocation);
			writer.println(result);
			writer.close();
		}
	}

	public int[] getFrequencyArray() {
		return frequencies;
	}


	public char getHighestFrequencyCharacter(String str, boolean button) throws IOException {
		writeFrequenciesToFile(str, button, null);
		int[] freqArray = getFrequencyArray();
		int f = 0;
		char c = ' ';

		for (int i = 0; i < freqArray.length; i++) {
			if (freqArray[i] > f){
				f = freqArray[i];
				c = (char) i;
			}
		}
		return c;
	}
	
	public void printHistogram(String str, boolean button, int threshold) throws IOException{
		writeFrequenciesToFile(str, button, null);
		int[] freq = getFrequencyArray();
		String result = "";
		
		for (int i = 0; i < freq.length; i++){
			if (freq[i] != 0){
				String starCount = "";
				for (int h = 0; h < (freq[i]/threshold); h++){
					starCount += "*";
				}
				result += (char) i + " : " + starCount + "\n";
			}
		}
		System.out.println(result);
	}

}
