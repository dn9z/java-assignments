package util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import scrabble.util.Permutation;
import scrabble.util.PermutationUtilities;

public class PermutationTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void permutationStoresOriginalWord() {
		Permutation p = new Permutation("hallo");
		assertEquals("hallo", p.getWord());
	}

	@Test
	public void testNormalize2() {
		assertEquals("ab", (new Permutation("ab")).getNormalized());
	}

	@Test
	public void testNormalize3() {
		assertEquals("ab", (new Permutation("ba")).getNormalized());
	}

	@Test
	public void testNormalize4() {
		assertEquals("addehkms", (new Permutation("aksdehmd")).getNormalized());
	}

	@Test
	public void testEquals1() {
		assertTrue((new Permutation("abenr")).equals(new Permutation(
				"barne")));
	}

	@Test
	public void testEquals2() {
		assertTrue(new Permutation("berlin").equals(new Permutation("linber")));
	}
	@Test
	public void testEqual3() {
		assertFalse(new Permutation("berlin").equals(new Permutation("linper")));
	}
	@Test
	public void testEqualsOtherType() {
		assertFalse(new Permutation("berlin").equals(new Integer(42)));
	}

	@Test
	public void testToString() {
		assertEquals("bca / abc", (new Permutation("bca")).toString());
	}

	@Test
	public void testNormalize1() {
		assertEquals("a", (new Permutation("a")).getNormalized());
	}

	@Test
	public void hashCodeForPermutationsShouldBeTheSame() {
		for (int i = 0; i < 1000; i++) {
			String p1 = PermutationUtilities.createPermutation(7);
			String p2 = PermutationUtilities.createPermutation(p1);
			Permutation pp1 = new Permutation(p1);
			Permutation pp2 = new Permutation(p2);
			assertEquals(pp1.hashCode(), pp2.hashCode());
			// System.out.println(pp1.hashCode());
			assertEquals(pp1, pp2);
		}
	}
}