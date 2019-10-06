package calcromarabic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.tuple.Triple;

public class Calculator {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new 
BufferedReader(new InputStreamReader(System.in));
        String expression = reader.readLine();
        Triple<BinaryOperator<IntOperand>, IntOperand, IntOperand> 
triple = OperatorCreator.createFromExpression(expression);
        IntOperand res = triple.getLeft()
.operate(triple.getMiddle(), triple.getRight());
        System.out.println(res);
    }
}
