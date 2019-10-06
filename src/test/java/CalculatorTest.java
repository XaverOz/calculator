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
			operationResult = 
OperatorCreator.createFromExpression("5:3").toString();
    	} catch (Exception e) {
    		operationResult = e.toString();
    	}
		assertEquals(operationResult, 
"java.lang.Exception: Operation not found");
    }
    @Test
    public void arabicOperandTest() throws Exception {
    	IntOperand romaOperand = null;
    	try{
    		romaOperand = new IntOperand("    X   ");
		} catch(Exception e) {
			throw new Exception("IntOperand intenal error");
		}
		assertEquals(romaOperand.getFormatNumber(), 
IntOperand.FormatNumber.ROMA);
    	assertEquals(romaOperand.intValue(), 10);
	}
	@Test
    public void operatorCreatorFaultError() throws Exception {
    	String operationResult;
    	try {
    		operationResult = OperatorCreator.createFromExpression("  5   +   X   ").toString();
    	} catch (Exception e) {
    		operationResult = e.toString();
		}
		assertEquals(operationResult, 
"java.lang.Exception: Operator format not equals");
	}
	@Test
    public void operator1FormatError() throws Exception {
    	String operationResult;
    	try {
			operationResult = 
OperatorCreator.createFromExpression("  5 3   +   X   ").toString();
    	} catch (Exception e) {
    		operationResult = e.toString();
		}
		assertEquals(operationResult, 
"java.lang.Exception: Operand format error");
    }
    @Test
    public void arabicOperandErrorTest() throws Exception {
    	String operationResult;
    	try {
    		operationResult = new IntOperand("    IIII   ").toString();
    	} catch(Exception e) {
    		operationResult = e.toString();
    	}
		assertEquals(operationResult, 
"java.lang.Exception: Operand format error");
    }    
    @Test
    public void binaryOperatorTest() throws Exception {
    	BinaryOperator.Operation<Integer> operation = (a, b) -> {
    		return new Integer(a.intValue() * b.intValue());
    	};
		BinaryOperator<Integer> c = new 
BinaryOperator<Integer>("*", operation);
    	Integer res = c.operate(new Integer(1), new Integer(3));
    	assertEquals(res.intValue(), 3);
    }
}
