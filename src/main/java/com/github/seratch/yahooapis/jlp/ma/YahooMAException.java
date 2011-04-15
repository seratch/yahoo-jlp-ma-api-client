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
 * Yahoo!JAPAN 日本語形態素解析APIクライアントで発生した例外
 * 
 * @author Kazuhiro SERA
 */
public class YahooMAException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public YahooMAException() {
		super();
	}

	public YahooMAException(Throwable t) {
		super(t);
	}

}
