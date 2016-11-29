package util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	public static Date convertStringToDate(String dateString) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		
		try {
			return new Date(dateFormat.parse(dateString).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
