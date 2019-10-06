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
	public IntOperand(int value) throws Exception {
		this.numValue = value;
		this.formatNumber = FormatNumber.ARABIC;
		if (numValue > 10) 
			throw new Exception("Operator more than 10");
	}
	private int tryRoma(String value) throws Exception {
		int res = 0;
		value = value.trim();
		Pattern pattern = Pattern.compile("^[V?I{0,3}|I?[X|V]]$");
		Matcher matcher = pattern.matcher(value);
		if(!matcher.find())
			throw new Exception("Operand format error");
		for(int i = 0; i < value.length(); i++) {
			char ch = value.charAt(i);
			if(ch == 'I') {
				res += 1;
			} else if(ch == 'V') {
				if(i != 0)
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
		try {
			this.numValue = Integer.parseInt(value);
			this.formatNumber = FormatNumber.ARABIC;
			if (this.numValue > 10) 
				throw new Exception("Operator more than 10");
			return;
		} catch (NumberFormatException e) {
			this.numValue = tryRoma(value);
			this.formatNumber = FormatNumber.ROMA;
			if (this.numValue > 10) 
				throw new Exception("Operator more than 10");
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
}
