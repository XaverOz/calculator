package calcromarabic;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class IntOperand extends Number {
	private int numValue;

	public enum FormatNumber {
		ROMA,
		ARABIC
	};
	private FormatNumber formatNumber;
	public IntOperand(int value) {
		this.numValue = value;
		this.formatNumber = FormatNumber.ARABIC;
	}
	public IntOperand(int value, FormatNumber format) {
		this.numValue = value;
		this.formatNumber = format;
	}
	private int tryRoma(String value) throws Exception {
		int res = 0;
		Pattern pattern = Pattern.compile("^(V?I{0,3}|I?(X|V))$");
		Matcher matcher = pattern.matcher(value);
		if(!matcher.find())
			throw new Exception("Operand format error");
		for(int i = 0; i < value.length(); i++) {
			char ch = value.charAt(i);
			if(ch == 'I') {
				res += 1;
			} else if(ch == 'V') {
				if(i == 0)
					res += 5;
				else 
					res = 5 - res;
			} else if(ch == 'X') {
				res = 10 - res;
			} else 
				throw new Exception("Operand format error");
		}
		return res;
	}
	public IntOperand(String value) throws Exception {
		value = value.trim();
		try {
			this.numValue = Integer.parseInt(value);
			this.formatNumber = FormatNumber.ARABIC;
			return;
		} catch (NumberFormatException e) {
			this.numValue = tryRoma(value);
			this.formatNumber = FormatNumber.ROMA;
		}
		
	}
	public FormatNumber getFormatNumber() {
		return formatNumber;
	}
	public int intValue() {
		return numValue;
	}
	public double doubleValue() {
		return numValue;
	}
	public float floatValue() {
		return numValue;
	}	
	public long longValue() {
		return numValue;
	}		
	private String romaToString() {
		int value = numValue;
		String res = "";
		while (value >= 100) {
			res += "C";
			value -= 100;
		}
		while (value >= 90) {
			res += "XC";
			value -= 90;
		}
		while (value >= 50) {
			res += "L";
			value -= 50;
		}
		while (value >= 40) {
			res += "XL";
			value -= 40;
		}
		while (value >= 10) {
			res += "X";
			value -= 10;
		}
		while (value >= 9) {
			res += "IX";
			value -= 9;
		}
		while (value >= 5) {
			res += "V";
			value -= 5;
		}
		while (value >= 4) {
			res += "IV";
			value -= 4;
		}
		while (value >= 1) {
			res += "I";
			value -= 1;
		}    
		return res;
	}
	public String toString() {
		if (this.formatNumber == FormatNumber.ROMA) {
			if(numValue <= 0) {
				return "Result can't be displayed in selected format";
			}
			return romaToString();
		}
		return String.valueOf(numValue);
	}
}
