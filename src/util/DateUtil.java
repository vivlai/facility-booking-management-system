package util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateUtil {
	public static Timestamp convertStringToTimestamp(String dateString) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm a",Locale.ENGLISH);
		
		try {
			Timestamp timestamp = new Timestamp(dateFormat.parse(dateString).getTime());
			return timestamp;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
