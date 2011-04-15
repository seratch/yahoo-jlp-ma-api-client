package com.github.seratch.yahooapis.jlp.ma;

import static org.junit.Assert.*;
import org.junit.Test;


public class YahooMAExceptionTest {

	@Test
	public void type() throws Exception {
		assertNotNull(YahooMAException.class);
	}

	@Test
	public void instantiation() throws Exception {
		YahooMAException target = new YahooMAException();
		assertNotNull(target);
	}

}
