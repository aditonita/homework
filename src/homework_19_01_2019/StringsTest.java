package homework_19_01_2019;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

class StringsTest {

	@Test
	void testIndexOf() {
		Strings s = new Strings("exemplu");
		int result = s.IndexOf('m');
		assertEquals(3, result);
	}
	
	@Test
	void testPalindrom() {
		Strings s = new Strings("minim");
		boolean r = s.Palindrom();
		assertEquals(true,r);
	}

}
