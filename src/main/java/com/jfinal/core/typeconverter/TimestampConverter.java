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

public class TimestampConverter implements IConverter<java.sql.Timestamp> {
	private static final String datePattern = "yyyy-MM-dd";
	private static final int dateLen = datePattern.length();
	@Override
	public java.sql.Timestamp convert(String s) throws ParseException {
		if (s.length() > dateLen) {
			return java.sql.Timestamp.valueOf(s);
		}
		else {
			return new java.sql.Timestamp(new SimpleDateFormat(datePattern).parse(s).getTime());
		}
	}
	
}
