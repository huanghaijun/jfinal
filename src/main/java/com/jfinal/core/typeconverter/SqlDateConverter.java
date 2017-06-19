/**
 * Copyright (c) 2011-2017, 玛雅牛 (myaniu AT gmail dot com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jfinal.core.typeconverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SqlDateConverter implements IConverter<java.sql.Date> {
	private static final String timeStampPattern = "yyyy-MM-dd HH:mm:ss";
	private static final String datePattern = "yyyy-MM-dd";
	private static final int dateLen = datePattern.length();
	@Override
	public java.sql.Date convert(String s) throws ParseException {
		if (s.length() > dateLen) {	// if (x < timeStampLen) 改用 datePattern 转换，更智能
			// return new java.sql.Date(java.sql.Timestamp.valueOf(s).getTime());	// error under jdk 64bit(maybe)
			return new java.sql.Date(new SimpleDateFormat(timeStampPattern).parse(s).getTime());
		}
		else {
			// return new java.sql.Date(java.sql.Date.valueOf(s).getTime());	// error under jdk 64bit
			return new java.sql.Date(new SimpleDateFormat(datePattern).parse(s).getTime());
		}
	}
	
}
