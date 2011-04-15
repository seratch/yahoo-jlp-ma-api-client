/*
 * Copyright 2011 Kazuhiro Sera
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.github.seratch.yahooapis.jlp.ma;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * Yahoo!JAPAN 日本語形態素解析APIクライアント
 * 
 * <pre>
 * ＜ダウンロード＞
 * http://www.sbcr.jp/books/download/art.asp?newsid=2327
 * http://www.sbcr.jp/books/img/CIiA-src.zip
 * ＜API仕様＞
 * http://developer.yahoo.co.jp/webapi/jlp/ma/v1/parse.html
 * </pre>
 * 
 * @author 集合知イン・アクション(著：Satnam Alag,ISBN：978-4-7973-5200-9)
 * @author Kazuhiro SERA
 */
public class YahooMAClient {

	/**
	 * リクエストURL
	 */
	public static final String REQUEST_URL = "http://jlp.yahooapis.jp/MAService/V1/parse";

	/**
	 * <pre>
	 * レスポンス項目設定パラメータ 
	 * カンマ区切りで渡します。
	 * ma": 形態素解析の結果を ma_result に返します。 "uniq": 出現頻度情報を uniq_result に返します。
	 * </pre>
	 */
	public static final String PARAM_RESULTS = "results";

	/**
	 * <pre>
	 * 品詞番号によるフィルターパラメータ 
	 * カンマ区切りで渡します。
	 * 1:形容詞, 2:形容動詞, 3:感動詞, 4:副詞, 5:連体詞, 6:接続詞, 7:接頭辞, 8:接尾辞, 9:名詞, 10:動詞,
	 * 11:助詞, 12:助動詞, 13:特殊（句読点、カッコ、記号など
	 * </pre>
	 */
	public static final String PARAM_FILTER = "filter";

	/**
	 * <pre>
	 * レスポンス項目設定パラメータ 
	 * カンマ区切りで渡します。
	 * surface:表記, reading:読みがな, pos:品詞, baseform:基本形表記, feature:全情報
	 * </pre>
	 */
	public static final String PARAM_RESPONSE = "response";

	/**
	 * リクエストパラメータ
	 */
	private Map<String, String> requestParameters = new HashMap<String, String>();

	/**
	 * コンストラクタ
	 * 
	 * @param applicationId
	 *            Yahoo!JAPANから発効されるアプリケーションID
	 */
	public YahooMAClient(String applicationId) {
		requestParameters.put("appid", applicationId);
		requestParameters.put(PARAM_RESULTS, "ma");
		requestParameters.put(PARAM_RESPONSE,
				"surface,reading,pos,baseform,feature");
	}

	public void setParameter(String key, String value) {
		requestParameters.put(key, value);
	}

	/**
	 * 日本語形態素解析APIを叩きます。
	 * 
	 * @param sentence
	 *            センテンス
	 * @return 形態素解析されたトークンのリスト
	 * @throws IOException
	 *             API呼び出しで何らかのエラー発生時
	 */
	public List<YahooMAToken> analyze(String sentence) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) new URL(REQUEST_URL).openConnection();
		conn.setConnectTimeout(3000);
		conn.setReadTimeout(10000);
		conn.setRequestProperty("User-Agent",
				"Yahoo! MA API Client (+https://github.com/seratch/yahoo-jlp-ma-api-client/)");
		conn.setRequestMethod("POST");
		OutputStream os = null;
		OutputStreamWriter writer = null;
		try {
			conn.setDoOutput(true);
			os = conn.getOutputStream();
			writer = new OutputStreamWriter(os);
			requestParameters.put("sentence", sentence);
			for (String key : requestParameters.keySet()) {
				writer.append(key);
				writer.append("=");
				writer.append(requestParameters.get(key).toString());
				writer.append("&");
			}
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e) {
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (Exception e) {
				}
			}
		}
		conn.connect();
		try {
			List<YahooMAToken> tokens = new ArrayList<YahooMAToken>();
			YahooMAResponseParser handler = new YahooMAResponseParser(tokens);
			SAXParser saxp = SAXParserFactory.newInstance().newSAXParser();
			saxp.parse(conn.getInputStream(), handler);
			return tokens;
		} catch (ParserConfigurationException e) {
			throw new YahooMAException(e);
		} catch (SAXException e) {
			throw new YahooMAException(e);
		}
	}

}
