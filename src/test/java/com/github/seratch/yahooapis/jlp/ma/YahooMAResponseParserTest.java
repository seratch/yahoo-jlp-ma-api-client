package com.github.seratch.yahooapis.jlp.ma;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;
import org.xml.sax.Attributes;

public class YahooMAResponseParserTest {

	@Test 
	public void type() throws Exception {
		assertNotNull(YahooMAResponseParser.class);
	}

	@Test 
	public void instantiation() throws Exception {
		List<YahooMAToken> tokens = null;
		YahooMAResponseParser target = new YahooMAResponseParser(tokens);
		assertNotNull(target);
	}

	@Test 
	public void startElement_A$String$String$String$Attributes()
			throws Exception {
		List<YahooMAToken> tokens = null;
		YahooMAResponseParser parser = new YahooMAResponseParser(tokens);
		// given
		String uri = null;
		String localName = null;
		String name = null;
		Attributes attributes = mock(Attributes.class);
		// when
		parser.startElement(uri, localName, name, attributes);
		// then
		// e.g. : verify(mocked).called();
	}

	@Test 
	public void characters_A$charArray$int$int() throws Exception {
		List<YahooMAToken> tokens = null;
		YahooMAResponseParser parser = new YahooMAResponseParser(tokens);
		// given
		char[] ch = new char[] {};
		int start = 0;
		int length = 0;
		// when
		parser.characters(ch, start, length);
		// then
	}

	@Test 
	public void endElement_A$String$String$String() throws Exception {
		List<YahooMAToken> tokens = null;
		YahooMAResponseParser parser = new YahooMAResponseParser(tokens);
		// given
		String uri = null;
		String localName = null;
		String name = null;
		// when
		parser.endElement(uri, localName, name);
		// then
	}

}
