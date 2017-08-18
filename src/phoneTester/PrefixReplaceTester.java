package phoneTester;

import static org.junit.Assert.*;

import org.junit.Test;

import phone.PrefixReplace;

public class PrefixReplaceTester {

	@Test
	public void test() {
		String s="abcde cars ca bounse";
		String[] dic={"abc", "car", "race"};
		PrefixReplace pr=new PrefixReplace();
		assertTrue(pr.replace(s, dic).equals("abc car ca bounse"));
	}

}
