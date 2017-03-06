package lycamPlusSdk.lycam.utils;

import java.text.MessageFormat;

/**
 * @ClassName: CodingUtils 
 * @Describe: utils for common coding
 *         
 * @Version: V0.1.0
 */
public class CodingUtils {
	public static void assertParameterNotNull(Object param, String paramName) {
		if (param == null) {
			throw new NullPointerException(String.format(
					"ParameterIsNull. Please Check your parameter:[%s]", paramName));
		}
	}
	
	public static void assertStringNotNullOrEmpty(String param, String paramName) {
		assertParameterNotNull(param, paramName);
		if (param.trim().length() == 0) {
			throw new IllegalArgumentException(String.format(
					"ParameterStringIsEmpty. Please Check your parameter:[%s]", paramName));
		}
	}
	
	public static void assertParameterInRange(long param, long lower, long upper) {
		if (!checkParamRange(param, lower, true, upper, true)) {
			throw new IllegalArgumentException(
					String.format("%d not in valid range [%d, %d]", param, lower, upper));
		}
	}
	
	public static void assertParameterInRange(long param, String paramName, long lower, long upper) {
		if (!checkParamRange(param, lower, true, upper, true)) {
			throw new IllegalArgumentException(
					String.format("[" + paramName + "] its length %d not in valid range [%d, %d]", param, lower, upper));
		}
	}
	
	public static  boolean checkParamRange(long param, long from, boolean leftInclusive, 
			long to, boolean rightInclusive) {
		
		if (leftInclusive && rightInclusive) {	// [from, to]
			if (from <= param && param <= to) {
				return true;
			} else {
				return false;
			}
		} else if (leftInclusive && !rightInclusive) {  // [from, to)
			if (from <= param && param < to) {
				return true;
			} else {
				return false;
			}
		} else if (!leftInclusive && !rightInclusive) {	// (from, to)
			if (from < param && param < to) {
				return true;
			} else {
				return false;
			}
		} else {	 // (from, to]
			if (from < param && param <= to) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static boolean checkParamIsNullOrEmpty(String param) {
		if(param==null || "".equals(param)) {
			return true;
		} else {
			return false;
		}
	}
}
