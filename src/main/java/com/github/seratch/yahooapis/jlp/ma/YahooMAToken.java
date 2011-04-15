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

/**
 * Yahoo!JAPAN 日本語形態素解析API解析結果トークン
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
public class YahooMAToken {

	/**
	 * 表記
	 */
	private String surface;

	/**
	 * 品詞
	 */
	private String pos;

	/**
	 * 読み仮名
	 */
	private String reading;

	/**
	 * 基本形表記
	 */
	private String baseform;

	/**
	 * 全情報
	 */
	private String feature;

	/**
	 * 出現数
	 */
	private String count;

	public YahooMAToken() {
	}

	public YahooMAToken(String surface, String reading, String baseform,
			String feature, String pos) {
		this.surface = surface;
		this.reading = reading;
		this.baseform = baseform;
		this.feature = feature;
		this.pos = pos;
	}

	public String getSurface() {
		return surface;
	}

	public String getReading() {
		return reading;
	}

	public String getBaseform() {
		return baseform;
	}

	public String getFeature() {
		return feature;
	}

	public String getPos() {
		return pos;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[表記:").append(surface);
		sb.append(",読み仮名:").append(reading);
		sb.append(",基本形表記:").append(baseform);
		sb.append(",品詞:").append(pos);
		sb.append(",全情報:").append(feature);
		if (count != null) {
			sb.append(",出現数:").append(count);
		}
		sb.append("]");
		return sb.toString();
	}

	public static class Pos {
		private Pos() {
		}
		public static final String adjective = "形容詞";
		public static final String adjectiveVerb = "形容動詞";
		public static final String interjection = "感動詞";
		public static final String adverb = "副詞";
		public static final String rentaishi = "連体詞";
		public static final String conjunction = "接続詞";
		public static final String prefix = "接頭辞";
		public static final String suffix = "接尾辞";
		public static final String noun = "名詞";
		public static final String verb = "動詞";
		public static final String particle = "助詞";
		public static final String auxiliaryVerb = "助動詞";
		public static final String special = "特殊";
	}

}
