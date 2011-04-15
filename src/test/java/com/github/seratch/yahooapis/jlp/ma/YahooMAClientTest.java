package com.github.seratch.yahooapis.jlp.ma;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Properties;

import org.junit.Test;

public class YahooMAClientTest {

	static String appid = "";

	static {
		Properties props = new Properties();
		try {
			props.load(YahooMAClientTest.class.getClassLoader().getResourceAsStream("yahoo-api.properties"));
			appid = props.getProperty("appid");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test 
	public void type() throws Exception {
		assertNotNull(YahooMAClient.class);
	}

	@Test 
	public void instantiation() throws Exception {
		YahooMAClient yahooJMA = new YahooMAClient(appid);
		assertNotNull(yahooJMA);
	}

	@Test 
	public void setParameter_A$String$String() throws Exception {
		YahooMAClient yahoo = new YahooMAClient(appid);
		// given
		String key = "名前";
		String value = "値";
		// when
		yahoo.setParameter(key, value);
		// then
	}

	@Test 
	public void analyze_A$String() throws Exception {
		YahooMAClient ma = new YahooMAClient(appid);
		String sentence = "庭には二羽ニワトリがいる。";
		List<YahooMAToken> resultList = ma.analyze(sentence);
		assertNotNull(resultList);
		for (YahooMAToken token : resultList) {
			String result = "[表記:" + token.getSurface() + ",読み仮名:" + token.getReading() + ",基本形表記:"
					+ token.getBaseform() + ",品詞:" + token.getPos() + "]";
			System.out.println(result);
		}
	}

}
