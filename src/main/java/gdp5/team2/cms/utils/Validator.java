package gdp5.team2.cms.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	public static final String VALID_PHONE_REGEX = "^\\d{10,}$";
	public static final String VALID_EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String VALID_DATE_REGEX = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
	public static Set<String> ids = new HashSet<>();

	/**
	 * Create by: Yen Trinh - CMC
	 * Create date: Jan 11, 2019
	 * Modifier: Yen Trinh
	 * Modified date: Jan 11, 2019
	 * Description: check phone format.
	 * Version 1.0
	 * @param phone
	 * @return
	 */
	public static boolean isPhone(String phone) {
		Pattern pattern = Pattern.compile(VALID_PHONE_REGEX);
		Matcher matcher = pattern.matcher(phone);
		return matcher.matches();
	}

	/**
	 * Create by: Yen Trinh - CMC
	 * Create date: Jan 11, 2019
	 * Modifier: Yen Trinh
	 * Modified date: Jan 11, 2019
	 * Description: Check email format. 
	 * Version 1.0
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		Pattern pattern = Pattern.compile(VALID_EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	/**
	 * Create by: Yen Trinh - CMC
	 * Create date: Jan 11, 2019
	 * Modifier: Yen Trinh
	 * Modified date: Jan 11, 2019
	 * Description: Check date format - allow leading zeros to be omitted. Valid value e.g.:
	 *  1/1/11 :        true
		01/01/11 :      true
		01/01/2011 :    true
		01/1/2011 :     true
		1/11/2011 :     true
		1/11/11 :       true
		11/1/11 :       true
	 * Version 1.0
	 * @param date
	 * @return
	 */
	public static boolean isDate(String date) {
		Pattern pattern = Pattern.compile(VALID_DATE_REGEX);
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}

	/**
	 * Create by: Yen Trinh - CMC
	 * Create date: Jan 11, 2019
	 * Modifier: Yen Trinh
	 * Modified date: Jan 11, 2019
	 * Description: Check if a String is empty or not.
	 * Version 1.0
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}

	/**
	 * Create by: Yen Trinh - CMC
	 * Create date: Jan 11, 2019
	 * Modifier: Yen Trinh
	 * Modified date: Jan 11, 2019
	 * Description: Check if is integer or not.
	 * Version 1.0
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str) {
		if (str == null || !str.matches("[0-9]+$")) {
			return false;
		}
		return true;
	}

	/**
	 * Create by: Yen Trinh - CMC
	 * Create date: Jan 11, 2019
	 * Modifier: Yen Trinh
	 * Modified date: Jan 11, 2019
	 * Description: Validate the searching keyword.
	 * Version 1.0
	 * @param str
	 * @return
	 */
	public static String validateKeySearch(String str) {
		return str.replaceAll("%", "&%").replaceAll("_", "&_");
	}

	/**
	 * Create by: Yen Trinh - CMC
	 * Create date: Jan 11, 2019
	 * Modifier: Yen Trinh
	 * Modified date: Jan 11, 2019
	 * Description: Check if id is existed in a set or not.
	 * Version 1.0
	 * @param id
	 * @return
	 */
	public static boolean isExisted(String id) {
		if (!ids.contains(id)) {
			ids.add(id);
			return true;

		} else {
			return false;

		}
	}

	/**
	 * Create by: Yen Trinh - CMC
	 * Create date: Jan 11, 2019
	 * Modifier: Yen Trinh
	 * Modified date: Jan 11, 2019
	 * Description: Set of id: do not allow id to be duplicated.
	 * Version 1.0
	 * @return
	 */
	public static Set<String> getIds() {
		return ids;
	}

}
