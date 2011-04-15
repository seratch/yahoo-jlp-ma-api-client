package com.github.seratch.yahooapis.jlp.ma;

import static org.junit.Assert.*;
import org.junit.Test;

public class YahooMATokenTest {

	@Test 
	public void type() throws Exception {
		assertNotNull(YahooMAToken.class);
	}

	@Test 
	public void instantiation() throws Exception {
		YahooMAToken token = new YahooMAToken();
		assertNotNull(token);
	}

	@Test 
	public void toString_A$() throws Exception {
		YahooMAToken token = new YahooMAToken("a", "b", "c", "d", "e");
		String actual = token.toString();
		String expected = "[表記:a,読み仮名:b,基本形表記:c,全情報:d,品詞:e]";
		assertEquals(expected, actual);
	}

}
