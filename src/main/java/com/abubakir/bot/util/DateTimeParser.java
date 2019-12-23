package com.abubakir.bot.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeParser {

	public static LocalDateTime parseDateFromEpoch(Integer epochDate) {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochDate), ZoneId.systemDefault());
	}

}
