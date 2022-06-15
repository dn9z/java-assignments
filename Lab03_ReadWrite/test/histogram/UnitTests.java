package histogram;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class UnitTests {

	private Lab03 main;
	
	@Before
	public void setUp() throws Exception {
		main = new Lab03();
	}
	
	@Test
	public void testFrequencies() throws IOException{
		String output = "frequencyJUnit.txt";
		main.writeFrequenciesToFile("abbcccAAABBC |[“ “}{¶≠ 98135685", false, output);
		int[] result = main.getFrequencyArray();
		
		assertTrue(result['A'] == 3);
		assertTrue(result['B'] == 2);
		assertTrue(result['C'] == 1);
		assertTrue(result['a'] == 1);
		assertTrue(result['b'] == 2);
		assertTrue(result['c'] == 3);
		assertTrue(result[9] == 0);
	}
	
	@Test
	public void testHighestFrequencyCharacter() throws IOException{
		char result = main.getHighestFrequencyCharacter("HHHa", false);
		assertTrue(result == 'H');
	}

}
