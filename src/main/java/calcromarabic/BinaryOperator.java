package calcromarabic;


public class BinaryOperator<T extends Number> {
    private String operator;
    public  interface Operation<T2 extends Number> {
    	public T2 operate(T2 operand1, T2 operand2);
	}
    private Operation operation;

    public BinaryOperator(String operator, Operation operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public String getOperator() {
        return operator;
    }
    public T operate(T operand1, T operand2)
throws Exception {
		Class[] b = new Class[1];
        b[0] = int.class;
		try {
			T res = (T)operation.operate(operand1, operand2);
			return res;
		} catch(Exception e) {
			throw new Exception("BinaryOperatorWrapped intenal error");		
		}
	}	
}
