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

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Yahoo!JAPAN 日本語形態素解析APIのレスポンスパーサー
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
public class YahooMAResponseParser extends DefaultHandler {

	/**
	 * タグ名
	 */
	private String tagName = "";

	/**
	 * 表記
	 */
	private String surface;

	/**
	 * 読み仮名
	 */
	private String reading;

	/**
	 * 表記基本形
	 */
	private String baseform;

	/**
	 * 全情報
	 */
	private String feature;

	/**
	 * 品詞
	 */
	private String pos;

	/**
	 * 出現数
	 */
	private String count;

	/**
	 * 解析結果トークンのリスト
	 */
	private List<YahooMAToken> tokens;

	/**
	 * @param tokens
	 *            解析結果トークンのリスト
	 */
	public YahooMAResponseParser(List<YahooMAToken> tokens) {
		this.tokens = tokens;
	}

	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException {
		if (!"".equals(name)) {
			tagName = name;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		if ("surface".equals(tagName)) {
			if (surface == null) {
				surface = "";
			}
			surface += new String(ch, start, length);
		} else if ("reading".equals(tagName)) {
			if (reading == null) {
				reading = "";
			}
			reading += new String(ch, start, length);
		} else if ("baseform".equals(tagName)) {
			if (baseform == null) {
				baseform = "";
			}
			baseform += new String(ch, start, length);
		} else if ("feature".equals(tagName)) {
			if (feature == null) {
				feature = "";
			}
			feature += new String(ch, start, length);
		} else if ("pos".equals(tagName)) {
			if (pos == null) {
				pos = "";
			}
			pos += new String(ch, start, length);
		} else if ("count".equals(tagName)) {
			if (count == null) {
				count = "";
			}
			count += new String(ch, start, length);
		}
	}

	@Override
	public void endElement(String uri, String localName, String name)
			throws SAXException {
		if ("word".equals(name)) {
			YahooMAToken token = new YahooMAToken(surface, reading, baseform, feature, pos);
			if (count != null) {
				token.setCount(count);
			}
			tokens.add(token);
			surface = null;
			reading = null;
			baseform = null;
			feature = null;
			pos = null;
			count = null;
		}
		tagName = "";
	}

}
