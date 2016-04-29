package stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by sisyphuspan on 16/4/21.
 */
public class EvaluateReversePolish_150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<Integer>();
        if(tokens == null || tokens.length == 0)
            return 0;
        Set<String> operator = new HashSet<String>();
        operator.add("+");
        operator.add("-");
        operator.add("*");
        operator.add("/");

        for(String token : tokens) {
            if(operator.contains(token) && operands.size() >=2) {
                int int2 = operands.pop();
                int int1 = operands.pop();
                int result;
                switch(token) {
                    case "+": result = int1 + int2; break;
                    case "-": result = int1 - int2; break;
                    case "*": result = int1 * int2; break;
                    default: result = int1 / int2;
                }
                operands.push(result);
            }else {
                int number = Integer.parseInt(token);
                operands.push(number);
            }

        }
        if(operands.size() == 1)
            return operands.pop();
        return 0;
    }
}
