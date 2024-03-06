package com.cl.sodexo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	private static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
	private static final String DATE_FORMAT_1 = "dd/MM/YYYY HH:mm:ss";
	private static final String DATE_FORMAT_2 = "yyyy-MM-dd'T'HH:mm:ss";
	private static final String DATE_FORMAT_3 = "dd MMM yyyy";

	public static String dateFormat() {

		Date dt = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_3);

		return sdf.format(dt);

	}

	public static String timestampToDate(String value) {

		String fecha = null;

		if (value == null) {
			return fecha;
		}

		try {

			SimpleDateFormat sdf1 = new SimpleDateFormat(DATE_FORMAT_2);

			Date date = sdf1.parse(value);

			SimpleDateFormat sdf2 = new SimpleDateFormat(DATE_FORMAT_3);

			fecha = sdf2.format(date);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return fecha;

	}

	public static boolean validaEmail(String value) {

		if (value == null) {
			return false;
		}

		Matcher matcher = EMAIL_PATTERN.matcher(value);

		return matcher.matches();

	}

}
