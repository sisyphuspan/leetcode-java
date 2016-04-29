package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by sisyphuspan on 16/4/21.
 */
public class ValidParentheses_20 {

    public static void main(String[] args) {
        boolean flag = isValid("()[]{}");
    }

    public static boolean isValid(String s) {
        if(s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for(int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if(map.keySet().contains(c) ) {
                if(!stack.empty() && map.get(c) == stack.peek())
                    stack.pop();
                else
                    return false;
            }else {
                stack.push(c);
            }

        }

        if(stack.empty())
            return true;
        return false;
    }
}
