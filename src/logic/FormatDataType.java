package logic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FormatDataType {
	
	private static final Map<Integer, String> formatDataTypes = new HashMap<>();
	
	static {
		// Binary bit value	
		formatDataTypes.put(1, "ONE_BIT_BINARY");
		// Single bit from 16-bit register.	
		formatDataTypes.put(2, "ONE_BIT_BINARY_BIT_0");
		// Single bit from 16-bit register.	
		formatDataTypes.put(3, "ONE_BIT_BINARY_BIT_1");
		// Single bit from 16-bit register.	
		formatDataTypes.put(4, "ONE_BIT_BINARY_BIT_2");
		// Single bit from 16-bit register.	
		formatDataTypes.put(5, "ONE_BIT_BINARY_BIT_3");
		// Single bit from 16-bit register.	
		formatDataTypes.put(6, "ONE_BIT_BINARY_BIT_4");
		// Single bit from 16-bit register.	
		formatDataTypes.put(7, "ONE_BIT_BINARY_BIT_5");
		// Single bit from 16-bit register.	
		formatDataTypes.put(8, "ONE_BIT_BINARY_BIT_6");
		// Single bit from 16-bit register.	
		formatDataTypes.put(9, "ONE_BIT_BINARY_BIT_7");
		// Single bit from 16-bit register.	
		formatDataTypes.put(10, "ONE_BIT_BINARY_BIT_8");
		// Single bit from 16-bit register.	
		formatDataTypes.put(11, "ONE_BIT_BINARY_BIT_9");
		// Single bit from 16-bit register.	
		formatDataTypes.put(12, "ONE_BIT_BINARY_BIT_10");
		// Single bit from 16-bit register.	
		formatDataTypes.put(13, "ONE_BIT_BINARY_BIT_11");
		// Single bit from 16-bit register.	
		formatDataTypes.put(14, "ONE_BIT_BINARY_BIT_12");
		// Single bit from 16-bit register.	
		formatDataTypes.put(15, "ONE_BIT_BINARY_BIT_13");
		// Single bit from 16-bit register.	
		formatDataTypes.put(16, "ONE_BIT_BINARY_BIT_14");
		// Single bit from 16-bit register.	
		formatDataTypes.put(17, "ONE_BIT_BINARY_BIT_15");
		// 16-bit unsigned integer	
		formatDataTypes.put(18, "16_BIT_UNSIGNED");
		// 16-bit unsigned integer	
		formatDataTypes.put(19, "16_BIT_UNSIGNED_SWAPPED");
		// 16-bit unsigned integer	
		formatDataTypes.put(20, "16_BIT_SIGNED");
		// 16-bit unsigned integer	
		formatDataTypes.put(21, "16_BIT_SIGNED_SWAPPED");
		// 16-bit binary coded decimal	
		formatDataTypes.put(22, "16_BIT_BCD");
		// Double ASCII characters	
		formatDataTypes.put(23, "16_BIT_ASCII_CHARSET");
		// 32-bit unsigned integer	
		formatDataTypes.put(24, "32_BIT_UNSIGNED");
		// 32-bit unsigned integer	
		formatDataTypes.put(25, "32_BIT_UNSIGNED_SWAPPED");
		// 32-bit unsigned integer	
		formatDataTypes.put(26, "32_BIT_UNSIGNED_SWAPPED_SWAPPED");
		// 32-bit signed integer	
		formatDataTypes.put(27, "32_BIT_SIGNED");
		// 32-bit signed integer	
		formatDataTypes.put(28, "32_BIT_SIGNED_SWAPPED");
		// 32-bit signed integer	
		formatDataTypes.put(29, "32_BIT_SIGNED_SWAPPED_SWAPPED");
		// 32-bit single precision float	
		formatDataTypes.put(30, "32_BIT_FLOAT");
		// 32-bit single precision float	
		formatDataTypes.put(31, "32_BIT_FLOAT_SWAPPED");
		// 32-bit single precision float	
		formatDataTypes.put(32, "32_BIT_FLOAT_SWAPPED_INVERTED");
		// 32-bit unsigned MOD10K	
		formatDataTypes.put(33, "32_BIT_UNSIGNED_MOD10K");
		// 32-bit unsigned MOD10K	
		formatDataTypes.put(34, "32_BIT_UNSIGNED_MOD10K_SWAPPED");
		// 32-bit signed MOD10K	
		formatDataTypes.put(35, "32_BIT_SIGNED_MOD10K");
		// 32-bit binary coded decimal	
		formatDataTypes.put(36, "32_BIT_BCD");
		// 32-bit binary coded decimal	
		formatDataTypes.put(37, "32_BIT_BCD_SWAPPED");
		// 48-bit unsigned MOD10K	
		formatDataTypes.put(38, "48_BIT_UNSIGNED_MOD10K");
		// 48-bit unsigned MOD10K	
		formatDataTypes.put(39, "48_BIT_UNSIGNED_MOD10K_SWAPPED");
		// 64-bit double precision float	
		formatDataTypes.put(40, "64_BIT_FLOAT");
		// 64-bit double precision float	
		formatDataTypes.put(41, "64_BIT_FLOAT_SWAPPED");
		// 64-bit unsigned MOD10K	
		formatDataTypes.put(42, "64_BIT_UNSIGNED_MOD10K");
		// 64-bit unsigned MOD10K	
		formatDataTypes.put(43, "64_BIT_UNSIGNED_MOD10K_SWAPPED");
		// 64-bit unsigned integer	
		formatDataTypes.put(44, "64_BIT_UNSIGNED");
		// 64-bit unsigned integer	
		formatDataTypes.put(45, "64_BIT_UNSIGNED_SWAPPED");
		// 64-bit signed integer	
		formatDataTypes.put(46, "64_BIT_SIGNED");
		// 64-bit signed integer	
		formatDataTypes.put(47, "64_BIT_SIGNED_SWAPPED");
		// User-defined format
		formatDataTypes.put(98, "USER_DEFINED_FORMAT");
		// Unknown format
		formatDataTypes.put(99, "UNKNOWN_FORMAT");
		// Add additinal formats in the 100+ range.
	}
	
	public static Map getMap() {
	     return Collections.unmodifiableMap(formatDataTypes);
	}
	
	public static int getIndex(String description) {
		int index = 99;
		for (Map.Entry<Integer, String> dataType : formatDataTypes.entrySet()) {
			if (dataType.getValue().equals(description.toUpperCase())) {
				index = dataType.getKey();
			}
		}
		return index;
	}
	
	public static String getDescription(int index) {
		String value = "UNKNOWN_FORMAT";
		return formatDataTypes.get(index);
	}
	
}
