/**
 * 
 */
package co.escapeideas.jira.web.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tmullender
 *
 */
public class Formatter {
	
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String toString(Date date){
		return DATE_FORMATTER.format(date);
	}
	
	public static Date toDate(String string){
		try {
			return DATE_FORMATTER.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
