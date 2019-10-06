package calcromarabic;

import org.apache.commons.lang3.tuple.Triple;


public class OperatorCreator {
	public static 
Triple<BinaryOperator<IntOperand>, IntOperand, IntOperand>
createFromExpression(String expression) throws 
Exception {
    	BinaryOperator op = null;
		expression = expression.trim();
		BinaryOperator.Operation<IntOperand> operation = null;
		String operator;
    	if(expression.indexOf("*") != -1) {
        	operation = (a, b) -> {
				return new IntOperand(a.intValue() * b.intValue(), a.getFormatNumber());
			};
			operator = "*";
        } else if(expression.indexOf("+") != -1) {
        	operation = (a, b) -> {
				return new IntOperand(a.intValue() + b.intValue(), a.getFormatNumber());
			};
			operator = "+";
        } else if(expression.indexOf("-") != -1) {
        	operation = (a, b) -> {
				return new IntOperand(a.intValue() - b.intValue(), a.getFormatNumber());
			};
			operator = "-";
        } else if(expression.indexOf("/") != -1) {
        	operation = (a, b) -> {
				return new IntOperand(a.intValue() / b.intValue(), a.getFormatNumber());
			};
			operator = "/";
        } else 
			throw new Exception("Operation not found");
		op = new BinaryOperator<Integer>(operator, operation);
		int operatorIndex = expression.indexOf(op.getOperator());
		IntOperand op1 = new 
IntOperand(expression.substring(0, operatorIndex));		
		if(op1.intValue() > 10) 
			throw new Exception("Operator1 more than 10");
		IntOperand op2 =  new 
IntOperand(expression.substring(operatorIndex + 1));
		if(op2.intValue() > 10) 
			throw new Exception("Operator2 more than 10");
		if(op1.getFormatNumber() != op2.getFormatNumber())			
			throw new Exception("Operator format not equals");
		Triple<BinaryOperator<IntOperand>,IntOperand,IntOperand> res =
Triple.of(op, op1, op2);
        return  res;
    }
}
