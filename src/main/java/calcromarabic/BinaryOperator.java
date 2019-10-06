package calcromarabic;

public abstract class BinaryOperator {
    private String operator;

    public BinaryOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
    public abstract <T extends Number> T operate(T operand1, T operand2)
throws Exception;
}
