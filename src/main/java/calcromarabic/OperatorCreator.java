package calcromarabic;

import org.apache.commons.lang3.tuple.Triple;


public class OperatorCreator {
    public static BinaryOperator createFromExpression(String expression) throws 
Exception {
    	BinaryOperator op = null;
    	expression = expression.trim();
    	if(expression.indexOf("*") != -1) {
        	op =  new BinaryOperator("*") {
        	    public <T extends Number> T operate(T operand1, T operand2) 
throws Exception {
        	    	Class[] b = new Class[1];
        	    	b[0] = int.class;
        	    	int pureRes = operand1.intValue() * operand2.intValue();
        	    	T res = null;
        	    	try {
        	    		res = 
(T)operand1.getClass().getDeclaredConstructor(b).newInstance(pureRes);
					} catch(Exception e) {
						throw new Exception("OperatorCreator intenal error");
					}
					return res;
				}
            };
        } else if(expression.indexOf("+") != -1) {
        	op =  new BinaryOperator("+") {
        	    public <T extends Number> T operate(T operand1, T operand2) 
throws Exception {
        	    	Class[] b = new Class[1];
        	    	b[0] = int.class;
        	    	int pureRes = operand1.intValue() + operand2.intValue();
        	    	T res = null;
        	    	try {
        	    		res = 
(T)operand1.getClass().getDeclaredConstructor(b).newInstance(pureRes);
					} catch(Exception e) {
						throw new Exception("OperatorCreator intenal error");
					}
					return res;
				}
            };
        } else if(expression.indexOf("-") != -1) {
        	op =  new BinaryOperator("-") {
        	    public <T extends Number> T operate(T operand1, T operand2) 
throws Exception {
        	    	Class[] b = new Class[1];
        	    	b[0] = int.class;
        	    	int pureRes = operand1.intValue() - operand2.intValue();
        	    	T res = null;
        	    	try {
        	    		res = 
(T)operand1.getClass().getDeclaredConstructor(b).newInstance(pureRes);
					} catch(Exception e) {
						throw new Exception("OperatorCreator intenal error");
					}
					return res;
				}
            };
        } else if(expression.indexOf("/") != -1) {
        	op =  new BinaryOperator("/") {
        	    public <T extends Number> T operate(T operand1, T operand2) 
throws Exception {
        	    	Class[] b = new Class[1];
        	    	b[0] = int.class;
        	    	int pureRes = operand1.intValue() / operand2.intValue();
        	    	T res = null;
        	    	try {
        	    		res = 
(T)operand1.getClass().getDeclaredConstructor(b).newInstance(pureRes);
					} catch(Exception e) {
						throw new Exception("OperatorCreator intenal error");
					}
					return res;
				}
            };
        } else 
			throw new Exception("Operator not found");
		int operatorIndex = expression.indexOf(op.getOperator());
		
        return  op;
    }
}
