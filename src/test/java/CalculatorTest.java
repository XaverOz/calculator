import calcromarabic.BinaryOperator;
import calcromarabic.IntOperand;
import calcromarabic.OperatorCreator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testCreateFromExpressionFault() {
    	String operationResult;
    	try {
    		operationResult = OperatorCreator.createFromExpression("5:3").toString();
    	} catch (Exception e) {
    		operationResult = e.toString();
    	}
		assertEquals(operationResult, "java.lang.Exception: Operator not found");
    }
    @Test
    public void binaryOperatorTest() throws Exception {
    	BinaryOperator op = new BinaryOperator("*") {
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
    	Integer val = op.operate(6, 3);
		assertEquals(val, new Integer(18));    	
    }    
    @Test
    public void arabicOperandTest() throws Exception {
    	IntOperand romaOperand = null;
    	try{
    		romaOperand = new IntOperand("    X   ");
		} catch(Exception e) {
			throw new Exception("IntOperand intenal error");
		}
    	assertEquals(romaOperand.getFormatNumber(), IntOperand.FormatNumber.ROMA);
    	assertEquals(romaOperand.intValue(), 10);
    }
    @Test
    public void arabicOperandErrorTest() throws Exception {
    	String operationResult;
    	try {
    		operationResult = new IntOperand("    IIII   ").toString();
    	} catch(Exception e) {
    		operationResult = e.toString();
    	}
    	assertEquals(operationResult, "java.lang.Exception: Operand format error");
    }    
}
