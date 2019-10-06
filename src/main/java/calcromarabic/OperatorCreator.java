package calcromarabic;

import org.apache.commons.lang3.tuple.Triple;


public class OperatorCreator {
    public static BinaryOperator createFromExpression(String expression) throws 
Exception {
    	BinaryOperator op = null;
		expression = expression.trim();
		BinaryOperator.Operation<IntOperand> operation = null;
		String operator;
    	if(expression.indexOf("*") != -1) {
        	operation = (a, b) -> {
				return new IntOperand(a.intValue() * b.intValue());
			};
			operator = "*";
        } else if(expression.indexOf("+") != -1) {
        	operation = (a, b) -> {
				return new IntOperand(a.intValue() + b.intValue());
			};
			operator = "+";
        } else if(expression.indexOf("-") != -1) {
        	operation = (a, b) -> {
				return new IntOperand(a.intValue() - b.intValue());
			};
			operator = "-";
        } else if(expression.indexOf("/") != -1) {
        	operation = (a, b) -> {
				return new IntOperand(a.intValue() / b.intValue());
			};
			operator = "-";
        } else 
			throw new Exception("Operator not found");
		int operatorIndex = expression.indexOf(op.getOperator());
		
        return  op;
    }
}
