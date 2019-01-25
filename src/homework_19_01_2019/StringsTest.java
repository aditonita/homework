package homework_19_01_2019;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
